package pl.jakubjaroszek.pracadyplomowa.dao;

import java.util.List;

import pl.jakubjaroszek.pracadyplomowa.model.Uzytkownik;

public interface UzytkownikDao {

	Uzytkownik znajdzPoIdentyfikatorze (int identyfikator);
	
	Uzytkownik znajdzPoLoginie (String login);
	
	void zapisz (Uzytkownik uzytkownik);
	
	void usunPoLoginie(String login);
	
	void usunPoIdentyfikatorze(int identyfikator);
	
	List<Uzytkownik> znajdzWszystkichKlientow();
	
	List<Uzytkownik> znajdzWszystkichPracownikow();
}
