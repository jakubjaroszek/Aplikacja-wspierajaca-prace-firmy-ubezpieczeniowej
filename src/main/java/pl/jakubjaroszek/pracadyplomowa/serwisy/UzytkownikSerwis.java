package pl.jakubjaroszek.pracadyplomowa.serwisy;

import java.util.List;

import pl.jakubjaroszek.pracadyplomowa.kontroler.dto.ResetowanieHaslaDaneDto;
import pl.jakubjaroszek.pracadyplomowa.model.Uzytkownik;

public interface UzytkownikSerwis {
	
	Uzytkownik znajdzPoIdentyfikatorze (int identyfikator);
	
	Uzytkownik znajdzPoLoginie (String login);
	
	void zapiszUzytkownika (Uzytkownik uzytkownik);
	
	void aktualizujUzytkownika (Uzytkownik uzytkownik);
	
	void usunUzytkownikaPoLoginie(String login);
	
	void usunUzytkownikaPoIdentyfikatorze (int identyfikator);
	
	List<Uzytkownik> znajdzWszystkichKlientow();
	
	List<Uzytkownik> znajdzWszystkichPracownikow();
	
	boolean czyUzytkownikPosiadaUnikalnyLogin(Integer identyfikator, String login);
	
	void aktualizujHasloUzytkownika(ResetowanieHaslaDaneDto resetowanieHaslaDaneDto);

}
