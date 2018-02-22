package pl.jakubjaroszek.pracadyplomowa.walidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import pl.jakubjaroszek.pracadyplomowa.model.UbezpieczenieSamochodu;


@Component
public class DaneUbezpieczenieSamochoduWalidator implements Validator {
	
	@Autowired
	NumerRejestracyjnyWalidator numerRejestracyjnyWalidator;
	
	@Override
	public boolean supports(Class<?> clazz) {
	
		return UbezpieczenieSamochodu.class.equals(clazz);
	}

	@Override
	public void validate(Object cel, Errors bledy) {
		
		UbezpieczenieSamochodu ubezpieczenieSamochodu = (UbezpieczenieSamochodu) cel;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(bledy, "numerRejestracyjnyPojazdu", "NotEmpty.daneUbezpieczenieSamochodu.numerRejestracyjnyPojazdu");
		ValidationUtils.rejectIfEmptyOrWhitespace(bledy, "numerVinPojazdu", "NotEmpty.daneUbezpieczenieSamochodu.numerVinPojazdu");
		
		if(!numerRejestracyjnyWalidator.walidacja(ubezpieczenieSamochodu.getNumerRejestracyjnyPojazdu())) {
			bledy.rejectValue("numerRejestracyjnyPojazdu","Wzorzec.daneUbezpieczenieSamochodu.numerRejestracyjnyPojazdu");
		}
		
		}

	}


