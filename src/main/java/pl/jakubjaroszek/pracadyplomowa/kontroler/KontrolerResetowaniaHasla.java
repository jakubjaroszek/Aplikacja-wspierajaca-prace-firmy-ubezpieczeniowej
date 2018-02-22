package pl.jakubjaroszek.pracadyplomowa.kontroler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.jakubjaroszek.pracadyplomowa.kontroler.dto.ResetowanieHaslaDaneDto;
import pl.jakubjaroszek.pracadyplomowa.model.ResetowanieHaslaToken;
import pl.jakubjaroszek.pracadyplomowa.serwisy.ResetowanieHaslaTokenSerwis;
import pl.jakubjaroszek.pracadyplomowa.serwisy.UzytkownikSerwis;
import pl.jakubjaroszek.pracadyplomowa.serwisy.WyslanieWiadomosciEmailSerwis;

@Controller
public class KontrolerResetowaniaHasla {

	@Autowired
	UzytkownikSerwis uzytkownikSerwis;

	@Autowired
	ResetowanieHaslaTokenSerwis resetowanieHaslaTokenSerwis;

	@Autowired
	WyslanieWiadomosciEmailSerwis wyslanieWiadomosciEmailSerwis;

	@RequestMapping(value = "/zresetuj-haslo-token={token}", method = RequestMethod.GET)
	public String wyswietlStroneZresetowaniaHasla(@PathVariable("token") String token, ModelMap model) {
		ResetowanieHaslaToken resetowanieHaslaToken = resetowanieHaslaTokenSerwis.znajdzPoTokenie(token);
		ResetowanieHaslaDaneDto resetowanieHaslaDaneDto = new ResetowanieHaslaDaneDto();
		if (resetowanieHaslaToken == null) {
			return "stronaBleduZresetowaniaHasla";
		} else if (resetowanieHaslaToken.tokenStracilWaznosc()) {
			return "stronaBleduZresetowaniaHasla";
		} else {
			model.addAttribute("token", resetowanieHaslaToken.getToken());
			model.addAttribute("resetowanieHaslaDaneDto", resetowanieHaslaDaneDto);
		}
		return "stronaZresetowaniaHasla";
	}

	@RequestMapping(value = "/zresetuj-haslo-token={token}", method = RequestMethod.POST)
	public String zresetujHasloUzytkownika(@PathVariable("token") String token,
			@Validated ResetowanieHaslaDaneDto resetowanieHaslaDaneDto, HttpServletRequest zapytanie,
			BindingResult rezultat, ModelMap model) {

		ResetowanieHaslaToken resetowanieHaslaToken = resetowanieHaslaTokenSerwis.znajdzPoTokenie(token);
		if (rezultat.hasErrors()) {
			return "stronaZresetowaniaHasla";
		}

		if (!resetowanieHaslaDaneDto.getHaslo().equals(resetowanieHaslaDaneDto.getPowtorzHaslo())) {
			rezultat.rejectValue("powtorzHaslo", null, "Podane hasła się nie zgadzają");
			return "stronaZresetowaniaHasla";
		}

		resetowanieHaslaDaneDto.setLoginUzytkownika(resetowanieHaslaToken.getLoginUzytkownika());
		uzytkownikSerwis.aktualizujHasloUzytkownika(resetowanieHaslaDaneDto);
		return "stronaPrzejsciowaZresetowaniaHasla";
	}

}
