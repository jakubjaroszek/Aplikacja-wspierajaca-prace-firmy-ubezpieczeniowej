package pl.jakubjaroszek.pracadyplomowa.kontroler;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.jakubjaroszek.pracadyplomowa.model.UbezpieczenieSamochodu;
import pl.jakubjaroszek.pracadyplomowa.model.Uprawnienia;
import pl.jakubjaroszek.pracadyplomowa.model.Uzytkownik;
import pl.jakubjaroszek.pracadyplomowa.serwisy.TransakcjaSerwis;
import pl.jakubjaroszek.pracadyplomowa.serwisy.UbezpieczenieSamochoduSerwis;
import pl.jakubjaroszek.pracadyplomowa.serwisy.UprawnieniaSeriws;
import pl.jakubjaroszek.pracadyplomowa.serwisy.UzytkownikSerwis;
import pl.jakubjaroszek.pracadyplomowa.walidator.AdresEmailWalidator;
import pl.jakubjaroszek.pracadyplomowa.walidator.DaneUbezpieczenieSamochoduWalidator;
import pl.jakubjaroszek.pracadyplomowa.walidator.UzytkownikWalidator;

@Controller
public class KontrolerZakupu {

	@Autowired
	UzytkownikSerwis uzytkownikSerwis;

	@Autowired
	UbezpieczenieSamochoduSerwis ubezpieczenieSamochoduSerwis;

	@Autowired
	UprawnieniaSeriws uprawnieniaSerwis;

	@Autowired
	AdresEmailWalidator AdresEmailWalidator;

	@Autowired
	UzytkownikWalidator uzytkownikWalidator;

	@Autowired
	DaneUbezpieczenieSamochoduWalidator daneUbezpieczenieSamochoduWalidator;

	@Autowired
	TransakcjaSerwis transakcjaSerwis;

	@Autowired
	MessageSource komunikaty;

	@InitBinder("uzytkownik")
	protected void initBinder(WebDataBinder powiaz) {
		powiaz.setValidator(uzytkownikWalidator);
	}

	@InitBinder("ubezpieczenieSamochodu")
	protected void initBinder2(WebDataBinder powiaz) {
		powiaz.setValidator(daneUbezpieczenieSamochoduWalidator);
	}

	@RequestMapping(value = "/zakupUbezpieczenie", method = RequestMethod.GET)
	public String formularzRejestracjiUbezpieczenia(ModelMap model, HttpServletRequest zapytanie) {
		Uzytkownik uzytkownik = new Uzytkownik();

		Set<Uprawnienia> lista = new HashSet<Uprawnienia>();
		lista.add(uprawnieniaSerwis.znajdzPoRodzajuUprawnien("KLIENT"));
		uzytkownik.setUprawnienia(lista);
		wartosciWyboruFormularzaRejestracjiKlienta(model);
		model.addAttribute("uzytkownik", uzytkownik);
		model.addAttribute("edycja", false);
		return "formularzRejestracja";
	}

	@RequestMapping(value = "/zakupUbezpieczenie", method = RequestMethod.POST)
	public String zakupUbezpieczenie(@Validated Uzytkownik uzytkownik, BindingResult rezultat, ModelMap model,
			HttpServletRequest zapytanie) {

		if (rezultat.hasErrors()) {
			Set<Uprawnienia> lista = new HashSet<Uprawnienia>();
			lista.add(uprawnieniaSerwis.znajdzPoRodzajuUprawnien("KLIENT"));
			uzytkownik.setUprawnienia(lista);
			model.addAttribute("uzytkownik", uzytkownik);
			wartosciWyboruFormularzaRejestracjiKlienta(model);
			return "formularzRejestracja";
		}

		HttpSession sesja = zapytanie.getSession();

		sesja.setAttribute("uzytkownik", uzytkownik);

		return "redirect:/daneUbezpieczenia";
	}

	@RequestMapping(value = "daneUbezpieczenia", method = RequestMethod.GET)
	public String daneUbezpieczeniaSamochodu(ModelMap model) {

		UbezpieczenieSamochodu ubezpieczenieSamochodu = new UbezpieczenieSamochodu();

		model.addAttribute("ubezpieczenieSamochodu", ubezpieczenieSamochodu);
		return "formularzDaneUbezpieczenieSamochodu";

	}

	@RequestMapping(value = "daneUbezpieczenia", method = RequestMethod.POST)
	public String dodajDaneUbezpieczeniaSamochodu(@Validated UbezpieczenieSamochodu ubezpieczenieSamochodu,
			BindingResult rezultat, ModelMap model, HttpServletRequest zapytanie) {

		if (rezultat.hasErrors()) {
			return "formularzDaneUbezpieczenieSamochodu";
		}

		HttpSession sesja = zapytanie.getSession();
		Integer identyfikatorUbezpieczenia = (Integer) sesja.getAttribute("identyfikatorUbezpieczenia");
		ubezpieczenieSamochodu.setIdentyfikator(identyfikatorUbezpieczenia);
		ubezpieczenieSamochoduSerwis.zapiszDanePojazdu(ubezpieczenieSamochodu);
		return "redirect:/podsumowanie";

	}

	@RequestMapping(value = "podsumowanie", method = RequestMethod.GET)
	public String pokazPodsumowanie(ModelMap model, HttpServletRequest zapytanie) {

		UbezpieczenieSamochodu ubezpieczenieSamochodu = new UbezpieczenieSamochodu();

		HttpSession sesja = zapytanie.getSession();
		int identyfikatorUbezpieczenia = (Integer) sesja.getAttribute("identyfikatorUbezpieczenia");
		ubezpieczenieSamochodu = ubezpieczenieSamochoduSerwis.znajdzPoIdentyfikatorze(identyfikatorUbezpieczenia);
		Uzytkownik uzytkownik = (Uzytkownik) sesja.getAttribute("uzytkownik");

		sesja.setAttribute("wartoscSkladkiUbezpieczeniaSamochodu",
				ubezpieczenieSamochodu.getWartoscSkladkiUbezpieczenia());
		model.addAttribute("uzytkownik", uzytkownik);
		model.addAttribute("ubezpieczenieSamochodu", ubezpieczenieSamochodu);
		return "stronaPodsumowaniaPlatnosciUbezpieczenia";
	}

	public void wartosciWyboruFormularzaRejestracjiKlienta(ModelMap model) {
		Date data = new Date();
		Calendar kalendarz = Calendar.getInstance();
		kalendarz.setTime(data);

		Map<String, String> miesiacUrodzenia = new LinkedHashMap<String, String>();
		miesiacUrodzenia.put("Styczen", "Styczeń");
		miesiacUrodzenia.put("Luty", "Luty");
		miesiacUrodzenia.put("Marzec", "Marzec");
		miesiacUrodzenia.put("Kwiecien", "Kwiecień");
		miesiacUrodzenia.put("Maj", "Maj");
		miesiacUrodzenia.put("Czerwiec", "Czerwiec");
		miesiacUrodzenia.put("Lipiec", "Lipiec");
		miesiacUrodzenia.put("Sierpien", "Sierpień");
		miesiacUrodzenia.put("Wrzesien", "Wrzesień");
		miesiacUrodzenia.put("Pazdziernik", "Październik");
		miesiacUrodzenia.put("Listopad", "Listopad");
		miesiacUrodzenia.put("Grudzien", "Grudzień");

		model.addAttribute("miesiacUrodzenia", miesiacUrodzenia);

		Map<Integer, Integer> dzienUrodzenia = new LinkedHashMap<Integer, Integer>();

		int miesiac = 31;
		int dzien = 1;
		for (int i = dzien; i <= miesiac; i++) {
			dzienUrodzenia.put(i, i);
		}
		model.addAttribute("dzienUrodzenia", dzienUrodzenia);

		Map<Integer, Integer> rokUrodzenia = new LinkedHashMap<Integer, Integer>();
		int year = kalendarz.get(Calendar.YEAR);
		int max = year - 68;

		for (int i = year; i >= max; i--) {
			rokUrodzenia.put(i, i);
		}
		model.addAttribute("rokUrodzenia", rokUrodzenia);

	}

}
