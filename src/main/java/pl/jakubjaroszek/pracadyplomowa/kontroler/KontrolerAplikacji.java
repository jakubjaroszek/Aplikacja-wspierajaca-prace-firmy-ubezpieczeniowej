package pl.jakubjaroszek.pracadyplomowa.kontroler;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.jakubjaroszek.pracadyplomowa.model.Kontakt;
import pl.jakubjaroszek.pracadyplomowa.model.Transakcja;
import pl.jakubjaroszek.pracadyplomowa.model.UbezpieczenieSamochodu;
import pl.jakubjaroszek.pracadyplomowa.model.Uprawnienia;
import pl.jakubjaroszek.pracadyplomowa.model.Uzytkownik;
import pl.jakubjaroszek.pracadyplomowa.serwisy.KontaktSerwis;
import pl.jakubjaroszek.pracadyplomowa.serwisy.TransakcjaSerwis;
import pl.jakubjaroszek.pracadyplomowa.serwisy.UbezpieczenieSamochoduSerwis;
import pl.jakubjaroszek.pracadyplomowa.serwisy.UprawnieniaSeriws;
import pl.jakubjaroszek.pracadyplomowa.serwisy.UzytkownikSerwis;
import pl.jakubjaroszek.pracadyplomowa.walidator.AdresEmailWalidator;
import pl.jakubjaroszek.pracadyplomowa.walidator.KontaktWalidator;
import pl.jakubjaroszek.pracadyplomowa.walidator.UzytkownikWalidator;

@Controller
@RequestMapping("/")
@SessionAttributes("role")
public class KontrolerAplikacji {

	@Autowired
	UzytkownikSerwis uzytkownikSerwis;

	@Autowired
	UprawnieniaSeriws uprawnieniaSerwis;

	@Autowired
	UbezpieczenieSamochoduSerwis ubezpieczenieSamochoduSerwis;

	@Autowired
	TransakcjaSerwis transakcjaSerwis;

	@Autowired
	AdresEmailWalidator AdresEmailWalidator;

	@Autowired
	KontaktSerwis kontaktSerwis;

	@Autowired
	UzytkownikWalidator uzytkownikWalidator;

	@Autowired
	KontaktWalidator kontaktWalidator;

	@Autowired
	MessageSource komunikaty;

	@Autowired
	AuthenticationTrustResolver zarzadzanieIdentyfikacjia;

	@InitBinder("uzytkownik")
	protected void initBinder(WebDataBinder powiaz) {
		powiaz.setValidator(uzytkownikWalidator);
	}

	@InitBinder("kontakt")
	protected void initBinderKontakt(WebDataBinder powiaz) {
		powiaz.setValidator(kontaktWalidator);
	}

	@RequestMapping(value = { "/", "/system" }, method = RequestMethod.GET)
	public String menu(ModelMap model) {

		List<Uzytkownik> uzytkownicy = uzytkownikSerwis.znajdzWszystkichKlientow();
		List<Uzytkownik> pracownicy = uzytkownikSerwis.znajdzWszystkichPracownikow();
		List<Transakcja> transakcje = transakcjaSerwis.znajdzWszystkieTransakcje();
		List<Kontakt> kontakty = kontaktSerwis.znajdzWszystkieKontakty();

		model.addAttribute("uzytkownicy", uzytkownicy);
		model.addAttribute("pracownicy", pracownicy);
		model.addAttribute("transakcje", transakcje);
		model.addAttribute("kontakty", kontakty);
		return "stronaMenuGlowne";
	}

	@RequestMapping(value = { "/menu" }, method = RequestMethod.GET)
	public String menuKlienta(ModelMap model) {
		UbezpieczenieSamochodu ubezpieczenieSamochodu = new UbezpieczenieSamochodu();
		Transakcja transakcja = new Transakcja();
		Uzytkownik uzytkownik = new Uzytkownik();

		uzytkownik = uzytkownikSerwis.znajdzPoLoginie(getDaneKonta());
		ubezpieczenieSamochodu = uzytkownik.getUbezpieczenieSamochodu();
		ubezpieczenieSamochodu = ubezpieczenieSamochoduSerwis.znajdzPoIdentyfikatorze(ubezpieczenieSamochodu.getIdentyfikator());
		transakcja = transakcjaSerwis.znajdzPoKluczuObcymSamochodu(ubezpieczenieSamochodu.getIdentyfikator());

		model.addAttribute("uzytkownik", uzytkownik);
		model.addAttribute("ubezpieczenieSamochodu", ubezpieczenieSamochodu);
		model.addAttribute("transakcja", transakcja);
		return "stronaMenuKlienta";
	}

	@RequestMapping(value = "/przegladajUbezpieczenia", method = RequestMethod.GET)
	public String przegladajUbezpieczenia(ModelMap model) {
		return "stronaPrzegladajUbezpieczenia";
	}
	
	@RequestMapping(value = "/informacje", method = RequestMethod.GET)
	public String przegladajInformacje(ModelMap model) {
		return "stronaInformacje";
	}
	@RequestMapping(value = "/kontakt", method = RequestMethod.GET)
	public String zamowKontakt(ModelMap model) {

		Kontakt kontakt = new Kontakt();

		model.addAttribute("kontakt", kontakt);
		wartosciWyboruFormularzaKontaktu(model);
		return "formularzKontaktowy";
	}

	@RequestMapping(value = "/kontakt", method = RequestMethod.POST)
	public String zapiszKontakt(@Validated Kontakt kontakt, BindingResult rezultat, ModelMap model) {

		if (rezultat.hasErrors()) {
			wartosciWyboruFormularzaKontaktu(model);
			return "formularzKontaktowy";
		}

		kontaktSerwis.zapiszKontakt(kontakt);
		return "stronaPotwierdzeniePrzeslaniaFormularzaKontaktowego";
	}

	@RequestMapping(value = "/nowyUzytkownik", method = RequestMethod.GET)
	public String nowyUzytkownik(ModelMap model) {

		Uzytkownik uzytkownik = new Uzytkownik();

		wartosciWyboruFormularzaUzytkownika(model);
		model.addAttribute("uzytkownik", uzytkownik);
		model.addAttribute("edycja", false);
		return "formularzDodanieEdycjaUzytkownika";
	}

	@RequestMapping(value = "/nowyUzytkownik", method = RequestMethod.POST)
	public String zapiszUzytkownika(@Validated Uzytkownik uzytkownik, BindingResult rezultat, ModelMap model) {

		if (rezultat.hasErrors()) {
			wartosciWyboruFormularzaUzytkownika(model);
			return "formularzDodanieEdycjaUzytkownika";
		}
		uzytkownikSerwis.zapiszUzytkownika(uzytkownik);
		model.addAttribute("zalogowanyUzytkownik", getDaneKonta());
		return "stronaDodanieUzytkownikaSukces";
	}

	@RequestMapping(value = "/edytujUzytkownika{login}", method = RequestMethod.GET)
	public String edytujUzytkownika(@PathVariable String login, ModelMap model) {
		Uzytkownik uzytkownik = uzytkownikSerwis.znajdzPoLoginie(login);

		wartosciWyboruFormularzaUzytkownika(model);
		model.addAttribute("uzytkownik", uzytkownik);
		model.addAttribute("edycja", true);
		return "formularzDodanieEdycjaUzytkownika";
	}

	@RequestMapping(value = "/edytujUzytkownika{login}", method = RequestMethod.POST)
	public String aktualizujUzytkownika(@Valid Uzytkownik uzytkownik, BindingResult rezultat, ModelMap model,
			@PathVariable String login) {

		if (rezultat.hasErrors()) {
			wartosciWyboruFormularzaUzytkownika(model);
			return "formularzDodanieEdycjaUzytkownika";
		}

		uzytkownikSerwis.aktualizujUzytkownika(uzytkownik);
		return "stronaEdycjaUzytkownikaSukces";
	}
	

	@RequestMapping(value = { "/usunUzytkownika{identyfikator}-{idUb}" }, method = RequestMethod.GET)
	public String usunUzytkownikaPoPoluIdentyfikator(@PathVariable int identyfikator, @PathVariable int idUb) {
		Transakcja	transakcja = transakcjaSerwis.znajdzPoKluczuObcymSamochodu(idUb);
		
		uzytkownikSerwis.usunUzytkownikaPoIdentyfikatorze(identyfikator);
		transakcjaSerwis.usunTransakcje(transakcja.getIdentyfikator());
		ubezpieczenieSamochoduSerwis.usunUbezpieczenieSamochoduPoIdentyfikatorze(idUb);
		return "redirect:/system";
	}
	
	@RequestMapping(value = { "/usunPracownika{identyfikator}"}, method = RequestMethod.GET)
	public String usunPracownikaPoPoluIdentyfikator (@PathVariable int identyfikator) {
		
		uzytkownikSerwis.usunUzytkownikaPoIdentyfikatorze(identyfikator);
		return "redirect:/system";
	}

	@ModelAttribute("role")
	public List<Uprawnienia> wczytajUprawnienia() {
		return uprawnieniaSerwis.znajdzWszystkie();
	}

	@RequestMapping(value = "/brakDostepu", method = RequestMethod.GET)
	public String brakDostepu(ModelMap model) {
		return "brakDostepu";
	}

	@RequestMapping(value = "/stronaGlowna", method = RequestMethod.GET)
	public String zaloguj() {
		if (anonimoweLogowanie()) {
			return "zalogujStronaGlowna";
		} else {
			return "redirect:/system";
		}
	}

	@RequestMapping(value = "/wyloguj", method = RequestMethod.GET)
	public String wyloguj() {
		Authentication autoryzacja = SecurityContextHolder.getContext().getAuthentication();
		if (autoryzacja != null) {
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		return "redirect:/stronaGlowna";
	}

	private String getDaneKonta() {
		String login = null;
		Object daneKonta = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (daneKonta instanceof UserDetails) {
			login = ((UserDetails) daneKonta).getUsername();
		} else {
			login = daneKonta.toString();

		}
		return login;
	}

	private boolean anonimoweLogowanie() {
		final Authentication autentyfikacja = SecurityContextHolder.getContext().getAuthentication();
		return zarzadzanieIdentyfikacjia.isAnonymous(autentyfikacja);
	}

	@RequestMapping(value = "/anulujUbezpieczenie", method = RequestMethod.GET)
	public String usunUbezpieczenie(HttpServletRequest zapytanie) {
		HttpSession sesja = zapytanie.getSession();
		Integer identyfikatorUbezpieczenia = (Integer) sesja.getAttribute("identyfikatorUbezpieczenia");

		ubezpieczenieSamochoduSerwis.usunUbezpieczenieSamochoduPoIdentyfikatorze(identyfikatorUbezpieczenia);
		return "redirect:/stronaGlowna";
	}

	@RequestMapping(value = { "/usunTransakcje{identyfikator}" }, method = RequestMethod.GET)
	public String usunTransakcje(@PathVariable Integer identyfikator) {
		transakcjaSerwis.usunTransakcje(identyfikator);
		return "redirect:/system";

	}

	@RequestMapping(value = { "/usunFormularzKontaktowy{identyfikator}" }, method = RequestMethod.GET)
	public String usunFormularzKontaktowy(@PathVariable Integer identyfikator) {
		kontaktSerwis.usunKontaktPoIdentyfikatorze(identyfikator);
		return "redirect:/system";

	}

	public void wartosciWyboruFormularzaKontaktu(ModelMap model) {
		Map<String, String> rodzajUbezpieczenia = new LinkedHashMap<String, String>();
		rodzajUbezpieczenia.put("Ubezpieczenie na zycie", "Ubezpieczenie na życie");
		rodzajUbezpieczenia.put("Ubezpieczenie domu / mieszkania", "Ubezpieczenie domu / mieszkania");
		model.addAttribute("rodzajUbezpieczenia", rodzajUbezpieczenia);

	}

	public void wartosciWyboruFormularzaUzytkownika(ModelMap model) {

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
		miesiacUrodzenia.put("Pazdziernik", "Pańdziernik");
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
