package pl.jakubjaroszek.pracadyplomowa.kontroler;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.jakubjaroszek.pracadyplomowa.model.ResetowanieHaslaToken;
import pl.jakubjaroszek.pracadyplomowa.model.Uzytkownik;
import pl.jakubjaroszek.pracadyplomowa.model.WiadomoscEmail;
import pl.jakubjaroszek.pracadyplomowa.serwisy.ResetowanieHaslaTokenSerwis;
import pl.jakubjaroszek.pracadyplomowa.serwisy.UzytkownikSerwis;
import pl.jakubjaroszek.pracadyplomowa.serwisy.WyslanieWiadomosciEmailSerwis;

@Controller
public class KontrolerPrzypomnieniaHasla {

	@Autowired
	UzytkownikSerwis uzytkownikSerwis;

	@Autowired
	ResetowanieHaslaTokenSerwis resetowanieHaslaTokenSerwis;

	@Autowired
	WyslanieWiadomosciEmailSerwis wyslanieWiadomosciEmailSerwis;

	@RequestMapping(value = "/przypomnijHaslo", method = RequestMethod.GET)
	public String wyswietlStronePrzypomnieniaHasla(ModelMap model) {
		ResetowanieHaslaToken resetowanieHaslaToken = new ResetowanieHaslaToken();
		model.addAttribute("resetowanieHaslaToken", resetowanieHaslaToken);
		return "stronaPrzypomnienieHasla";
	}

	@RequestMapping(value = "/przypomnijHaslo", method = RequestMethod.POST)
	public String przeslijWiadomoscResetujacaHaslo(@Validated ResetowanieHaslaToken resetowanieHaslaToken,
			HttpServletRequest zapytanie, BindingResult rezultat, ModelMap model) {

		if (rezultat.hasErrors()) {
			return "stronaPrzypomnienieHasla";
		}

		Uzytkownik uzytkownik = uzytkownikSerwis.znajdzPoLoginie(resetowanieHaslaToken.getLoginUzytkownika());
		if (uzytkownik == null) {
			rezultat.rejectValue("loginUzytkownika", null, "Konto z podanym adresem e-mail nie istnieje.");
			return "stronaPrzypomnienieHasla";
		}

		resetowanieHaslaToken.setToken(UUID.randomUUID().toString());
		resetowanieHaslaToken.setLoginUzytkownika(uzytkownik.getLogin());
		resetowanieHaslaToken.setDataWygasnieciaTokena(30);

		resetowanieHaslaTokenSerwis.zapiszToken(resetowanieHaslaToken);

		WiadomoscEmail wiadomoscEmail = new WiadomoscEmail();
		wiadomoscEmail.setNadawca("no-reply@insurancegroup.pl");
		wiadomoscEmail.setOdbiorca(uzytkownik.getLogin());
		wiadomoscEmail.setTemat("Zmiana hasla w systemie Insurance Group");
		wiadomoscEmail.setPoczatekWiadomosci("Witaj " + uzytkownik.getImie() + " " + uzytkownik.getNazwisko() + ".");
		String adresUrl = zapytanie.getScheme() + "://" + zapytanie.getServerName() + ":" + zapytanie.getServerPort();
		wiadomoscEmail.setAdresResetujacyHaslo(" Adres umożliwiający zresetowanie hasła: " + adresUrl
				+ "/zresetuj-haslo-token=" + resetowanieHaslaToken.getToken());
		wiadomoscEmail
				.setKoniecWiadomosci(" Prosimy nie odpowiadać na tą wiadomość, została wygenerowana automatycznie.");
		
		wyslanieWiadomosciEmailSerwis.wyslijWiadomoscEmail(wiadomoscEmail);
		return "stronaPrzejsciowaPrzypomnienieHasla";
	}

}
