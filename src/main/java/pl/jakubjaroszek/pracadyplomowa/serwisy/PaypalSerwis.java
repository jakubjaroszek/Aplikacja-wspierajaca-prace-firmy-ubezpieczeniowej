package pl.jakubjaroszek.pracadyplomowa.serwisy;

import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

import pl.jakubjaroszek.pracadyplomowa.konfiguracja.KonfiguracjaMetodPlatnosciPaypal;
import pl.jakubjaroszek.pracadyplomowa.konfiguracja.KonfiguracjaOperacjiPaypal;

public interface PaypalSerwis {

	Payment utworzPlatnosc(Double cena,
			String waluta,
			KonfiguracjaMetodPlatnosciPaypal metodaPlatnosci,
			KonfiguracjaOperacjiPaypal operacja,
			String opis,
			String adresAnulowaniaPlatnosci,
			String AdresZatwierdzonejPlatnosci) throws PayPalRESTException;
	
	Payment realizacjaPlatnosci(String identyfikatorPlatnosci, String identyfikatorPlatnika) throws PayPalRESTException;
}
