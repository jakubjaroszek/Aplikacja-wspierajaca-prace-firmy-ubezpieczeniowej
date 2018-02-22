package pl.jakubjaroszek.pracadyplomowa.walidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component("adresEmailWalidator")
public class AdresEmailWalidator {
	
	private Pattern wzorzec;
	private Matcher porownanie;

	private static final String WZORZEC_ADRESU_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public AdresEmailWalidator() {
		wzorzec = Pattern.compile(WZORZEC_ADRESU_EMAIL);
	}
	
	public boolean walidacja (final String adresEmail) {
		porownanie = wzorzec.matcher(adresEmail);
		return porownanie.matches();
	}
}
