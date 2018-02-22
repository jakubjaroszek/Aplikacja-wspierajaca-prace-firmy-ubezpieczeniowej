package pl.jakubjaroszek.pracadyplomowa.serwisy;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

import pl.jakubjaroszek.pracadyplomowa.konfiguracja.KonfiguracjaMetodPlatnosciPaypal;
import pl.jakubjaroszek.pracadyplomowa.konfiguracja.KonfiguracjaOperacjiPaypal;

@Service
public class PaypalSerwisImpl implements PaypalSerwis{
	
	@Autowired
	private APIContext warunkiInterfejsu;
	
	public Payment utworzPlatnosc (
		Double cena,
		String waluta,
		KonfiguracjaMetodPlatnosciPaypal metodaPlatnosci,
		KonfiguracjaOperacjiPaypal operacja,
		String opis,
		String adresAnulowaniaPlatnosci,
		String AdresZatwierdzonejPlatnosci) throws PayPalRESTException {
			Amount kwota = new Amount();
			kwota.setTotal(String.format(Locale.ROOT,"%.2f",cena));
			kwota.setCurrency(waluta);
			
			Item przedmiot = new Item();
			przedmiot.setQuantity("1");
			przedmiot.setName("Ubezpieczenie samochodu");
			przedmiot.setPrice(String.format(Locale.ROOT,"%.2f",cena));
			przedmiot.setCurrency(waluta);
			przedmiot.setSku("01");
			
			List<Item> listaPrzedmiotow = new ArrayList<>();
			listaPrzedmiotow.add(przedmiot);
			
			ItemList listaPrzedmiotowPayPal = new ItemList();
			listaPrzedmiotowPayPal.setItems(listaPrzedmiotow);
			
			Transaction transakcja = new Transaction();
			transakcja.setDescription(opis);
			transakcja.setAmount(kwota);
			transakcja.setItemList(listaPrzedmiotowPayPal);
			
			List<Transaction> transakcje = new ArrayList<>();
			transakcje.add(transakcja);
			
			Payer platnik = new Payer();
			platnik.setPaymentMethod(metodaPlatnosci.toString());
			
			RedirectUrls adresyPrzekierowywujace = new RedirectUrls();
			adresyPrzekierowywujace.setCancelUrl(adresAnulowaniaPlatnosci);
			adresyPrzekierowywujace.setReturnUrl(AdresZatwierdzonejPlatnosci);
			
			Payment platnosc = new Payment();
			platnosc.setIntent(operacja.toString());
			platnosc.setPayer(platnik);
			platnosc.setTransactions(transakcje);
			platnosc.setRedirectUrls(adresyPrzekierowywujace);
			
			return platnosc.create(warunkiInterfejsu);
		}
	
		public Payment realizacjaPlatnosci (String identyfikatorPlatnosci, String identyfikatorPlatnika) throws PayPalRESTException {
			Payment platnosc = new Payment();
			platnosc.setId(identyfikatorPlatnosci);
			PaymentExecution realizacjaPlatnosci = new PaymentExecution();
			realizacjaPlatnosci.setPayerId(identyfikatorPlatnika);
			return platnosc.execute(warunkiInterfejsu, realizacjaPlatnosci);
		}

	
		
	}

