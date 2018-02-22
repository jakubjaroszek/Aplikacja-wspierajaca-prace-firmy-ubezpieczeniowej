package pl.jakubjaroszek.pracadyplomowa.serwisy;

import java.util.List;

import pl.jakubjaroszek.pracadyplomowa.model.Kontakt;

public interface KontaktSerwis {
	
	void zapiszKontakt(Kontakt kontakt);
	
	void usunKontaktPoIdentyfikatorze (int identyfikator);
	
	List<Kontakt> znajdzWszystkieKontakty();
	

}
