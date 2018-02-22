package pl.jakubjaroszek.pracadyplomowa.walidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component("numerRejestracyjnyWalidator")
public class NumerRejestracyjnyWalidator {
	
	private static final String WZORZEC_NUMERU_REJESTRACYJNEGO = "[A-Z]{1,3}\\ [A-Z0-9]{1,2}[A-Z0-9]{1,4}" ;

	private Pattern wzorzec;
	private Matcher porownanie;
	
	public NumerRejestracyjnyWalidator() {
		wzorzec= Pattern.compile(WZORZEC_NUMERU_REJESTRACYJNEGO);
	}
	
	public boolean walidacja (final String numerRejestracyjnyPojazdu) {
		porownanie = wzorzec.matcher(numerRejestracyjnyPojazdu);
		return porownanie.matches();
	}

}
