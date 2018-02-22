package pl.jakubjaroszek.pracadyplomowa.walidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pl.jakubjaroszek.pracadyplomowa.model.Kontakt;

@Component
public class KontaktWalidator implements Validator {

	@Autowired
	AdresEmailWalidator adresEmailWalidator;
	
	@Autowired
	TelefonWalidator telefonWalidator;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Kontakt.class.equals(clazz);
		
	}

	@Override
	public void validate(Object cel, Errors bledy) {
		
		Kontakt kontakt = (Kontakt) cel;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(bledy, "imie", "NotEmpty.kontakt.imie");
		ValidationUtils.rejectIfEmptyOrWhitespace(bledy, "nazwisko", "NotEmpty.kontakt.nazwisko");
		ValidationUtils.rejectIfEmptyOrWhitespace(bledy, "numerTelefonu", "NotEmpty.kontakt.numerTelefonu");
		ValidationUtils.rejectIfEmptyOrWhitespace(bledy, "adresEmail", "NotEmpty.kontakt.adresEmail");
		
		if(kontakt.getRodzajUbezpieczenia().equalsIgnoreCase("NONE")) {
			bledy.rejectValue("rodzajUbezpieczenia", "NotEmpty.kontakt.rodzajUbezpieczenia");
		}
		
		if (!adresEmailWalidator.walidacja(kontakt.getAdresEmail())) {
			bledy.rejectValue("adresEmail", "Wzorzec.kontakt.adresEmail");
		}
		
		if (!telefonWalidator.walidacja(kontakt.getNumerTelefonu())) {
			bledy.rejectValue("numerTelefonu", "Wzorzec.kontakt.numerTelefonu");
		}
		
	}

}
