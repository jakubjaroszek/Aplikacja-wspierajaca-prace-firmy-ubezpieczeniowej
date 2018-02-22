package pl.jakubjaroszek.pracadyplomowa.kontroler;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.jakubjaroszek.pracadyplomowa.model.UbezpieczenieSamochodu;
import pl.jakubjaroszek.pracadyplomowa.serwisy.UbezpieczenieSamochoduSerwis;
import pl.jakubjaroszek.pracadyplomowa.walidator.UbezpieczenieSamochoduWalidator;

@Controller
public class KontrolerUbezpieczen {

	@Autowired
	UbezpieczenieSamochoduWalidator ubezpieczenieSamochoduWalidator;

	@Autowired
	UbezpieczenieSamochoduSerwis ubezpieczenieSamochoduSerwis;

	@InitBinder
	protected void initBinder(WebDataBinder powiaz) {
		powiaz.setValidator(ubezpieczenieSamochoduWalidator);

	}

	@RequestMapping(value = "/noweUbezpieczenie", method = RequestMethod.GET)
	public String noweUbezpieczenie(ModelMap model) {
		UbezpieczenieSamochodu ubezpieczenieSamochodu = new UbezpieczenieSamochodu();
		model.addAttribute("ubezpieczenieSamochodu", ubezpieczenieSamochodu);
		wartosciWyboruFormularzaUbezpieczenia(model);
		return "formularzNoweUbezpieczenie";

	}

	@RequestMapping(value = "/noweUbezpieczenie", method = RequestMethod.POST)
	public String zapiszUbezpieczenie(@Validated UbezpieczenieSamochodu ubezpieczenieSamochodu, BindingResult rezultat,
			ModelMap model, HttpServletRequest zapytanie) {

		if (rezultat.hasErrors()) {
			wartosciWyboruFormularzaUbezpieczenia(model);
			return "formularzNoweUbezpieczenie";
		}

		ubezpieczenieSamochodu.setCzasTrwaniaUbezpieczenia("12");
		ubezpieczenieSamochoduSerwis.zapiszUbezpieczenieSamochodu(ubezpieczenieSamochodu);
		ubezpieczenieSamochoduSerwis.obliczSkladkeUbezpieczeniaSamochodu(ubezpieczenieSamochodu);

		HttpSession sesja = zapytanie.getSession();
		sesja.setAttribute("identyfikatorUbezpieczenia", ubezpieczenieSamochodu.getIdentyfikator());

		return "redirect:/skladkaUbezpieczenieSamochodu/" + sesja.getAttribute("identyfikatorUbezpieczenia");

	}

	@RequestMapping(value = "skladkaUbezpieczenieSamochodu/{identyfikator}", method = RequestMethod.GET)
	public String pokazObliczonaSkladkeUbezpieczenia(@PathVariable("identyfikator") int identyfikator, ModelMap model) {

		UbezpieczenieSamochodu ubezpieczenieSamochodu = ubezpieczenieSamochoduSerwis
				.znajdzPoIdentyfikatorze(identyfikator);
		model.addAttribute("skladka", ubezpieczenieSamochodu.getWartoscSkladkiUbezpieczenia());

		return "stronaSkladkaUbezpieczenieSamochodu";
	}

	public void wartosciWyboruFormularzaUbezpieczenia(ModelMap model) {
		Date data = new Date();
		Calendar kalendarz = Calendar.getInstance();
		kalendarz.setTime(data);

		Map<String, String> miesiacWyboruRozpoczeciaUbezpieczenia = new LinkedHashMap<String, String>();
		miesiacWyboruRozpoczeciaUbezpieczenia.put("1", "Styczeń");
		miesiacWyboruRozpoczeciaUbezpieczenia.put("2", "Luty");
		miesiacWyboruRozpoczeciaUbezpieczenia.put("3", "Marzec");
		miesiacWyboruRozpoczeciaUbezpieczenia.put("4", "Kwiecień");
		miesiacWyboruRozpoczeciaUbezpieczenia.put("5", "Maj");
		miesiacWyboruRozpoczeciaUbezpieczenia.put("6", "Czerwiec");
		miesiacWyboruRozpoczeciaUbezpieczenia.put("7", "Lipiec");
		miesiacWyboruRozpoczeciaUbezpieczenia.put("8", "Sierpień");
		miesiacWyboruRozpoczeciaUbezpieczenia.put("9", "Wrzesień");
		miesiacWyboruRozpoczeciaUbezpieczenia.put("10", "Październik");
		miesiacWyboruRozpoczeciaUbezpieczenia.put("11", "Listopad");
		miesiacWyboruRozpoczeciaUbezpieczenia.put("12", "Grudzień");
		model.addAttribute("miesiacWyboruRozpoczeciaUbezpieczenia", miesiacWyboruRozpoczeciaUbezpieczenia);

		Map<Integer, Integer> dzienWyboruRozpoczeciaUbezpieczenia = new LinkedHashMap<Integer, Integer>();

		int miesiac = 31;
		int dzien = 1;
		for (int i = dzien; i <= miesiac; i++) {
			dzienWyboruRozpoczeciaUbezpieczenia.put(i, i);
		}
		model.addAttribute("dzienWyboruRozpoczeciaUbezpieczenia", dzienWyboruRozpoczeciaUbezpieczenia);

		Map<Integer, Integer> rokProdukcjiPojazdu = new LinkedHashMap<Integer, Integer>();
		int year = kalendarz.get(Calendar.YEAR);
		int max = year - 68;

		for (int i = year; i >= max; i--) {
			rokProdukcjiPojazdu.put(i, i);
		}
		model.addAttribute("rokProdukcjiPojazdu", rokProdukcjiPojazdu);

		Map<Integer, Integer> rokWydaniaPrawaJazdy = new LinkedHashMap<Integer, Integer>();
		int rok = kalendarz.get(Calendar.YEAR);
		int maksymalnyRok = rok - 68;

		for (int i = rok; i >= maksymalnyRok; i--) {
			rokWydaniaPrawaJazdy.put(i, i);
		}
		model.addAttribute("rokWydaniaPrawaJazdy", rokWydaniaPrawaJazdy);

		Map<String, String> pojemnoscSilnika = new LinkedHashMap<String, String>();
		pojemnoscSilnika.put("od 0.9 do 1.2", "od 0.9 do 1.2");
		pojemnoscSilnika.put("od 1.3 do 1.6", "od 1.3 do 1.6");
		pojemnoscSilnika.put("od 1.7 do 2.0", "od 1.7 do 2.0");
		pojemnoscSilnika.put("od 2.1 do 3.0", "od 2.1 do 3.0");
		pojemnoscSilnika.put("Powyzej 3.0", "Powyżej 3.0");
		model.addAttribute("pojemnoscSilnika", pojemnoscSilnika);

		Map<String, String> marka = new LinkedHashMap<String, String>();
		marka.put("Audi", "Audi");
		marka.put("BMW", "BMW");
		marka.put("Citroen", "Citroen");
		marka.put("Ford", "Ford");
		marka.put("Fiat", "Fiat");
		marka.put("Honda", "Honda");
		marka.put("Hyundai", "Hyundai");
		marka.put("Mercedes-Benz", "Mercedes-Benz");
		marka.put("Mazda", "Mazda");
		marka.put("Opel", "Opel");
		marka.put("Peugeot", "Peugeot");
		marka.put("Renault", "Renault");
		marka.put("Skoda", "Skoda");
		marka.put("Seat", "Seat");
		marka.put("Toyota", "Toyota");
		marka.put("Kia", "Kia");
		marka.put("Nissan", "Nissan");
		marka.put("Volvo", "Volvo");
		marka.put("Volkswagen", "Volkswagen");

		model.addAttribute("marka", marka);

		Map<String, String> wersjaNadwozia = new LinkedHashMap<String, String>();
		wersjaNadwozia.put("Sedan", "Sedan");
		wersjaNadwozia.put("Kombi", "Kombi");
		wersjaNadwozia.put("Hatchback", "Hatchback");
		wersjaNadwozia.put("SUV", "SUV");
		wersjaNadwozia.put("Coupe", "Coupe");
		wersjaNadwozia.put("Cabriolet", "Cabriolet");
		model.addAttribute("wersjaNadwozia", wersjaNadwozia);

		Map<String, String> zakresUbezpieczenia = new LinkedHashMap<String, String>();
		zakresUbezpieczenia.put("OC", "OC");
		zakresUbezpieczenia.put("OC i AC", "OC i AC");
		model.addAttribute("zakresUbezpieczenia", zakresUbezpieczenia);

		Map<String, String> kierowcyPonizej26RokuZycia = new LinkedHashMap<String, String>();
		kierowcyPonizej26RokuZycia.put("Tak", "Tak");
		kierowcyPonizej26RokuZycia.put("Nie", "Nie");
		model.addAttribute("kierowcyPonizej26RokuZycia", kierowcyPonizej26RokuZycia);

		Map<String, String> liczbaLatJazdyBezszkod = new LinkedHashMap<String, String>();
		liczbaLatJazdyBezszkod.put("0", "0");
		liczbaLatJazdyBezszkod.put("1", "1");
		liczbaLatJazdyBezszkod.put("2", "2");
		liczbaLatJazdyBezszkod.put("3", "3");
		liczbaLatJazdyBezszkod.put("4", "4");
		liczbaLatJazdyBezszkod.put("5", "5");
		model.addAttribute("liczbaLatJazdyBezszkod", liczbaLatJazdyBezszkod);

		Map<String, String> sredniRocznyPrzebieg = new LinkedHashMap<String, String>();
		sredniRocznyPrzebieg.put("Ponizej 5000", "Poniżej 5000");
		sredniRocznyPrzebieg.put("od 5001 do 10000", "5001-10000");
		sredniRocznyPrzebieg.put("od 10001 do 20000", "10001-20000");
		sredniRocznyPrzebieg.put("od 20001 do 4000", "20001-40000");
		sredniRocznyPrzebieg.put("Wiecej niz 40000", "Więcej niż 40000");
		model.addAttribute("sredniRocznyPrzebiegKm", sredniRocznyPrzebieg);

	}

}
