package pl.jakubjaroszek.pracadyplomowa.konfiguracja;

import java.util.HashMap;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;

@Configuration
public class KonfiguracjaPaypal {

	@Bean
	public Map<String, String> konfiguracjaTrybu() {
		Map<String, String> konfiguracja = new HashMap<>();
		konfiguracja.put("mode", KonfiguracjaOperacjiPaypal.trybPlatnosci);
		return konfiguracja;
	}

	@Bean
	public OAuthTokenCredential autoryzacja() {
		return new OAuthTokenCredential(KonfiguracjaOperacjiPaypal.identyfikatorKlienta, 
				KonfiguracjaOperacjiPaypal.hasloKlienta, konfiguracjaTrybu());
	}

	@Bean
	public APIContext warunkiInterfejsu() throws PayPalRESTException {
		APIContext warunkiInterfejsu = new APIContext(autoryzacja().getAccessToken());
		warunkiInterfejsu.setConfigurationMap(konfiguracjaTrybu());
		return warunkiInterfejsu;
	}

}
