package pl.jakubjaroszek.pracadyplomowa.kontroler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

import pl.jakubjaroszek.pracadyplomowa.konfiguracja.KonfiguracjaAdresowPaypal;
import pl.jakubjaroszek.pracadyplomowa.konfiguracja.KonfiguracjaMetodPlatnosciPaypal;
import pl.jakubjaroszek.pracadyplomowa.konfiguracja.KonfiguracjaOperacjiPaypal;
import pl.jakubjaroszek.pracadyplomowa.model.Transakcja;
import pl.jakubjaroszek.pracadyplomowa.model.UbezpieczenieSamochodu;
import pl.jakubjaroszek.pracadyplomowa.model.Uzytkownik;
import pl.jakubjaroszek.pracadyplomowa.serwisy.PaypalSerwis;
import pl.jakubjaroszek.pracadyplomowa.serwisy.TransakcjaSerwis;
import pl.jakubjaroszek.pracadyplomowa.serwisy.UbezpieczenieSamochoduSerwis;
import pl.jakubjaroszek.pracadyplomowa.serwisy.UzytkownikSerwis;
import pl.jakubjaroszek.pracadyplomowa.walidator.DaneUbezpieczenieSamochoduWalidator;

@Controller
public class KontrolerPlatnosciPaypal {

	public static final String ADRES_ANULOWANIA_PLATNOSCI = "/adresAnulowaniaPlatnosci";
	public static final String ADRES_ZATWIERDZENIA_PLATNOSCI = "/adresZatwierdzeniaPlatnosci";

	private Logger rejestrator = LoggerFactory.getLogger(getClass());

	@Autowired
	PaypalSerwis paypalSerwis;

	@Autowired
	UzytkownikSerwis uzytkownikSerwis;

	@Autowired
	TransakcjaSerwis transakcjaSerwis;

	@Autowired
	UbezpieczenieSamochoduSerwis ubezpieczenieSamochoduSerwis;

	@Autowired
	DaneUbezpieczenieSamochoduWalidator daneUbezpieczenieSamochoduWalidator;

	@Autowired
	MessageSource komunikaty;

	@RequestMapping(value = "podsumowanie", method = RequestMethod.POST)
	public String zaplac(HttpServletRequest zapytanie, Transakcja transakcja, Uzytkownik uzytkownik,
			UbezpieczenieSamochodu ubezpieczenieSamochodu, BindingResult rezultat, ModelMap model) {

		HttpSession sesja = zapytanie.getSession();
		Double wartoscSkladkiUbezpieczenia = (Double) sesja.getAttribute("wartoscSkladkiUbezpieczeniaSamochodu");
		int identyfikatorUbezpieczenia = (Integer) sesja.getAttribute("identyfikatorUbezpieczenia");

		if (ubezpieczenieSamochodu.getAkceptacjaZawarciaUbezpieczenia() == null) {
			ubezpieczenieSamochodu = ubezpieczenieSamochoduSerwis.znajdzPoIdentyfikatorze(identyfikatorUbezpieczenia);
			uzytkownik = (Uzytkownik) sesja.getAttribute("uzytkownik");
			model.addAttribute("uzytkownik", uzytkownik);
			model.addAttribute("ubezpieczenieSamochodu", ubezpieczenieSamochodu);
			rezultat.rejectValue("akceptacjaZawarciaUbezpieczenia", null, "Pole musi zostać zaznaczone");
			return "stronaPodsumowaniaPlatnosciUbezpieczenia";
		}

		ubezpieczenieSamochodu = ubezpieczenieSamochoduSerwis.znajdzPoIdentyfikatorze(identyfikatorUbezpieczenia);
		ubezpieczenieSamochoduSerwis.zapiszWarunek(ubezpieczenieSamochodu);
		
		uzytkownik = (Uzytkownik) sesja.getAttribute("uzytkownik");
		uzytkownik.setUbezpieczenieSamochodu(ubezpieczenieSamochodu);
		uzytkownikSerwis.zapiszUzytkownika(uzytkownik);
		
		transakcja.setUbezpieczenieSamochodu(ubezpieczenieSamochodu);
		transakcja.setWartoscSkladkiUbezpieczeniaSamochodu(ubezpieczenieSamochodu.getWartoscSkladkiUbezpieczenia());
		transakcja.setStatusTransakcji("Niezrealizowana");

		transakcjaSerwis.zapiszTransakcje(transakcja);

		sesja.setAttribute("identyfikatorTransakcji", transakcja.getIdentyfikator());

		String adresAnulowaniaPlatnosci = KonfiguracjaAdresowPaypal.znajdzAdresBazowy(zapytanie) + "/"
				+ ADRES_ANULOWANIA_PLATNOSCI;
		String adresZatwierdzeniaPlatnosci = KonfiguracjaAdresowPaypal.znajdzAdresBazowy(zapytanie) + "/"
				+ ADRES_ZATWIERDZENIA_PLATNOSCI;

		try {
			Payment platnosc = paypalSerwis.utworzPlatnosc(wartoscSkladkiUbezpieczenia, "PLN",
					KonfiguracjaMetodPlatnosciPaypal.paypal, KonfiguracjaOperacjiPaypal.sale,
					"Ubezpieczenie samochodowe", adresAnulowaniaPlatnosci, adresZatwierdzeniaPlatnosci);
			for (Links adresy : platnosc.getLinks()) {
				if (adresy.getRel().equals("approval_url")) {
					return "redirect:" + adresy.getHref();
					}
				}
			}
		catch (PayPalRESTException wyjatek) {
			rejestrator.error(wyjatek.getMessage());
			}
		return "stronaBrakDostepu";

	}

	@RequestMapping(value = ADRES_ANULOWANIA_PLATNOSCI, method = RequestMethod.GET)
	public String anulujPlatnosc() {
		return "stronaAnulowaniePlatnosci";
	}

	@RequestMapping(value = ADRES_ZATWIERDZENIA_PLATNOSCI, method = RequestMethod.GET)
	public String platnoscZatwierdzona(@RequestParam("paymentId") String identyfikatorPlatnosci,
			@RequestParam("PayerID") String identyfikatorPlatnika, HttpServletRequest zapytanie) {
		try {
			Payment platnosc = paypalSerwis.realizacjaPlatnosci(identyfikatorPlatnosci, identyfikatorPlatnika);
			if (platnosc.getState().equals("approved")) {

				HttpSession sesja = zapytanie.getSession();
				Integer identyfikatorTransakcji = (Integer) sesja.getAttribute("identyfikatorTransakcji");

				Transakcja transakcja = new Transakcja();

				transakcja = transakcjaSerwis.znajdzPoIdentyfikatorze(identyfikatorTransakcji);
				transakcjaSerwis.aktualizujTransakcje(transakcja);
				return "stronaZatwierdzeniePlatnosci";
			}
		} catch (PayPalRESTException wyjatek) {
			rejestrator.error(wyjatek.getMessage());
		}

		return "redirect:/";

	}

}
