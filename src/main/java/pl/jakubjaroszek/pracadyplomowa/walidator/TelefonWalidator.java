package pl.jakubjaroszek.pracadyplomowa.walidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component("telefonWalidator")
public class TelefonWalidator {
	
	private static final String WZORZEC_NUMERU_TELEFONU = "[0-9]{3}[0-9]{3}[0-9]{3}" ;

	private Pattern wzorzec;
	private Matcher porownanie;
	
	public TelefonWalidator() {
		wzorzec= Pattern.compile(WZORZEC_NUMERU_TELEFONU);
	}
	
	public boolean walidacja (final String numerTelefonu) {
		porownanie = wzorzec.matcher(numerTelefonu);
		return porownanie.matches();
	}

}
