package pl.jakubjaroszek.pracadyplomowa.walidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
@Component("kodPocztowyWalidator")
public class KodPocztowyWalidator {
	
	private static final String WZORZEC_KODU_POCZTOWEGO = "[0-9]{2}\\-[0-9]{3}" ;

	private Pattern wzorzec;
	private Matcher porownanie;
	
	public KodPocztowyWalidator() {
		wzorzec= Pattern.compile(WZORZEC_KODU_POCZTOWEGO);
	}
	
	public boolean walidacja (final String kodPocztowy) {
		porownanie = wzorzec.matcher(kodPocztowy);
		return porownanie.matches();
	}

}
