package pl.jakubjaroszek.pracadyplomowa.serwisy;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.jakubjaroszek.pracadyplomowa.dao.UbezpieczenieSamochoduDao;
import pl.jakubjaroszek.pracadyplomowa.model.UbezpieczenieSamochodu;

@Service("ubezpieczenieSamochoduSerwis")
@Transactional
public class UbezpieczenieSamochoduSerwisImpl implements UbezpieczenieSamochoduSerwis {

	@Autowired
	private UbezpieczenieSamochoduDao ubezpieczenieSamochoduDao;

	public UbezpieczenieSamochodu znajdzPoIdentyfikatorze(int identyfikator) {

		return ubezpieczenieSamochoduDao.znajdzPoIdentyfikatorze(identyfikator);
	}

	public void zapiszUbezpieczenieSamochodu(UbezpieczenieSamochodu ubezpieczenieSamochodu) {
		ubezpieczenieSamochoduDao.zapisz(ubezpieczenieSamochodu);

	}

	public void usunUbezpieczenieSamochoduPoIdentyfikatorze(int identyfikator) {
		ubezpieczenieSamochoduDao.usunPoIdentyfikatorze(identyfikator);

	}

	public void obliczSkladkeUbezpieczeniaSamochodu(UbezpieczenieSamochodu ubezpieczenieSamochodu) {
		Double wynik, wartoscPomocniczna = 0.0;

		Double wartoscPolaPojemnoscSilnika = 0.0, wartoscPolaZakresUbezpieczenia = 0.0,
				wartoscPolaSredniRocznyPrzebieg = 0.0, wartoscPolaKierowcyPonizej26RokuZycia = 0.0,
				wartoscPolaLiczbaLatJazdyBezszkodowej = 0.0;

		switch (ubezpieczenieSamochodu.getPojemnoscSilnika()) {
		case "od 0.9 do 1.2":
			wartoscPolaPojemnoscSilnika = 100.0;
			break;
		case "od 1.2 do 1.6":
			wartoscPolaPojemnoscSilnika = 200.0;
			break;
		case "od 1.6 do 2.0":
			wartoscPolaPojemnoscSilnika = 300.0;
			break;
		case "od 2.0 do 3.0":
			wartoscPolaPojemnoscSilnika = 400.0;
			break;
		case "Powyzej 3.0":
			wartoscPolaPojemnoscSilnika = 500.0;
			break;

		}

		switch (ubezpieczenieSamochodu.getSredniRocznyPrzebieg()) {
		case "Ponizej 5000":
			wartoscPolaSredniRocznyPrzebieg = 100.0;
			break;
		case "od 5001 do 10000":
			wartoscPolaSredniRocznyPrzebieg = 200.0;
			break;
		case "od 10001 do 20000":
			wartoscPolaSredniRocznyPrzebieg = 300.0;
			break;
		case "od 20001 do 4000":
			wartoscPolaSredniRocznyPrzebieg = 400.0;
			break;
		case "Wiecej niz 40000":
			wartoscPolaSredniRocznyPrzebieg = 500.0;
			break;
		}

		switch (ubezpieczenieSamochodu.getLiczbaLatJazdyBezszkodowej()) {

		case "0":
			wartoscPolaLiczbaLatJazdyBezszkodowej = 100.0;
			break;
		case "1":
			wartoscPolaLiczbaLatJazdyBezszkodowej = 80.0;
			break;
		case "2":
			wartoscPolaLiczbaLatJazdyBezszkodowej = 60.0;
			break;
		case "3":
			wartoscPolaLiczbaLatJazdyBezszkodowej = 40.0;
			break;
		case "4":
			wartoscPolaLiczbaLatJazdyBezszkodowej = 30.0;
			break;
		case "5":
			wartoscPolaLiczbaLatJazdyBezszkodowej = 20.0;
			break;
		}

		if ("Tak".equals(ubezpieczenieSamochodu.getKierowcyPonizej26RokuZycia())) {

			wartoscPolaKierowcyPonizej26RokuZycia = 200.0;
		}

		else if ("Nie".equals(ubezpieczenieSamochodu.getKierowcyPonizej26RokuZycia())) {

			wartoscPolaKierowcyPonizej26RokuZycia = 0.0;
		}

		if ("OC".equals(ubezpieczenieSamochodu.getZakresUbezpieczenia())) {

			wartoscPolaZakresUbezpieczenia = 200.0;
		}

		else if ("OC i AC".equals(ubezpieczenieSamochodu.getZakresUbezpieczenia())) {

			wartoscPomocniczna = wartoscPolaPojemnoscSilnika + wartoscPolaSredniRocznyPrzebieg
					+ wartoscPolaLiczbaLatJazdyBezszkodowej + wartoscPolaKierowcyPonizej26RokuZycia;

			wartoscPolaZakresUbezpieczenia = wartoscPomocniczna;
		}

		wynik = wartoscPolaPojemnoscSilnika + wartoscPolaSredniRocznyPrzebieg + wartoscPolaLiczbaLatJazdyBezszkodowej
				+ wartoscPolaKierowcyPonizej26RokuZycia + wartoscPolaZakresUbezpieczenia;

		Date data = new Date();
		Calendar kalendarz = Calendar.getInstance();
		kalendarz.setTime(data);
		int rok = kalendarz.get(Calendar.YEAR);
		rok += 1;

		UbezpieczenieSamochodu encja = ubezpieczenieSamochoduDao
				.znajdzPoIdentyfikatorze(ubezpieczenieSamochodu.getIdentyfikator());
		encja.setWartoscSkladkiUbezpieczenia(wynik);
		encja.setRokZakonczeniaUbezpieczenia(rok);

	}


	public void zapiszDanePojazdu(UbezpieczenieSamochodu ubezpieczenieSamochodu) {
		UbezpieczenieSamochodu encja = ubezpieczenieSamochoduDao
				.znajdzPoIdentyfikatorze(ubezpieczenieSamochodu.getIdentyfikator());
		encja.setNumerRejestracyjnyPojazdu(ubezpieczenieSamochodu.getNumerRejestracyjnyPojazdu());
		encja.setNumerVinPojazdu(ubezpieczenieSamochodu.getNumerVinPojazdu());

	}

	public void zapiszWarunek(UbezpieczenieSamochodu ubezpieczenieSamochodu) {
		UbezpieczenieSamochodu encja = ubezpieczenieSamochoduDao
				.znajdzPoIdentyfikatorze(ubezpieczenieSamochodu.getIdentyfikator());
		encja.setAkceptacjaZawarciaUbezpieczenia("zaakceptowany");

	}

}
