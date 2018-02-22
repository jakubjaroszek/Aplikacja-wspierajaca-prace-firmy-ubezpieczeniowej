package pl.jakubjaroszek.pracadyplomowa.dao;

import java.util.List;

import pl.jakubjaroszek.pracadyplomowa.model.Kontakt;

public interface KontaktDao {
	
	void zapisz(Kontakt kontakt);
	
	void usun(int identyfikator);
	
	List<Kontakt> znajdz();

}
