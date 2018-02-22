package pl.jakubjaroszek.pracadyplomowa.dao;

import java.util.List;

import pl.jakubjaroszek.pracadyplomowa.model.Uprawnienia;

public interface UprawnieniaDao {
	
	List<Uprawnienia> znajdzWszystkie();
	
	Uprawnienia znajdzPoRodzajuUprawnien(String rodzajUprawnien);
	
	Uprawnienia znajdzPoIdentyfikatorze(int identyfikator);

}
