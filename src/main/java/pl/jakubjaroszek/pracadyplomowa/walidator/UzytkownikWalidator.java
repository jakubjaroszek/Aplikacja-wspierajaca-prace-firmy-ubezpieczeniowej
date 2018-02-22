package pl.jakubjaroszek.pracadyplomowa.walidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pl.jakubjaroszek.pracadyplomowa.model.Uzytkownik;
import pl.jakubjaroszek.pracadyplomowa.serwisy.UzytkownikSerwis;

@Component
public class UzytkownikWalidator implements Validator {
	
	@Autowired
	UzytkownikSerwis uzytkownikSerwis;
	
	@Autowired
	AdresEmailWalidator adresEmailWalidator;
	
	@Autowired
	KodPocztowyWalidator kodPocztowyWalidator;
	
	@Autowired
	TelefonWalidator telefonWalidator;

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Uzytkownik.class.equals(clazz);
	}

	@Override
	public void validate(Object cel, Errors bledy) {
		
		Uzytkownik uzytkownik = (Uzytkownik) cel;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(bledy, "login", "NotEmpty.uzytkownik.login");
		ValidationUtils.rejectIfEmptyOrWhitespace(bledy, "haslo", "NotEmpty.uzytkownik.haslo");
		ValidationUtils.rejectIfEmptyOrWhitespace(bledy, "powtorzHaslo", "NotEmpty.uzytkownik.haslo");
		ValidationUtils.rejectIfEmptyOrWhitespace(bledy, "imie", "NotEmpty.uzytkownik.imie");
		ValidationUtils.rejectIfEmptyOrWhitespace(bledy, "nazwisko", "NotEmpty.uzytkownik.nazwisko");
		ValidationUtils.rejectIfEmptyOrWhitespace(bledy, "ulica", "NotEmpty.uzytkownik.ulica");
		ValidationUtils.rejectIfEmptyOrWhitespace(bledy, "numerDomuMieszkania", "NotEmpty.uzytkownik.numerDomuMieszkania");
		ValidationUtils.rejectIfEmptyOrWhitespace(bledy, "kodPocztowy", "NotEmpty.uzytkownik.kodPocztowy");
		ValidationUtils.rejectIfEmptyOrWhitespace(bledy, "numerTelefonu", "NotEmpty.uzytkownik.numerTelefonu");
		
		
		if (uzytkownik.getDzienUrodzenia().equalsIgnoreCase("NONE")) {
			bledy.rejectValue("dzienUrodzenia", "NotEmpty.uzytkownik.dataUrodzenia");
		}
		
		if (uzytkownik.getMiesiacUrodzenia().equalsIgnoreCase("NONE")) {
			bledy.rejectValue("miesiacUrodzenia", "NotEmpty.uzytkownik.dataUrodzenia");
		}
		
		if (uzytkownik.getRokUrodzenia().equalsIgnoreCase("NONE")) {
			bledy.rejectValue("rokUrodzenia", "NotEmpty.uzytkownik.dataUrodzenia");
		}
		
		
		if(!uzytkownikSerwis.czyUzytkownikPosiadaUnikalnyLogin(uzytkownik.getIdentyfikator(), uzytkownik.getLogin())){
		bledy.rejectValue("login", "non.unique.login");
		
		}
		
		
		if(!adresEmailWalidator.walidacja(uzytkownik.getLogin())){
			bledy.rejectValue("login", "Wzorzec.kontakt.adresEmail");
		}
		
		if(!kodPocztowyWalidator.walidacja(uzytkownik.getKodPocztowy())){
			bledy.rejectValue("kodPocztowy", "Wzorzec.uzytkownik.kodPocztowy");
		}
		
		if(!telefonWalidator.walidacja(uzytkownik.getNumerTelefonu())) {
			bledy.rejectValue("numerTelefonu", "Wzorzec.uzytkownik.numerTelefonu");
		}
		
		if(!uzytkownik.getHaslo().equals(uzytkownik.getPowtorzHaslo())) {
			bledy.rejectValue("powtorzHaslo", "match.powtorzhaslo");
		}

	}
}
