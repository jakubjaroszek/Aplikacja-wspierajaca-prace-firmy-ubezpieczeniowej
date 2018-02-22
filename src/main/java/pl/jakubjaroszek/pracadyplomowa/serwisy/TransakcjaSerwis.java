package pl.jakubjaroszek.pracadyplomowa.serwisy;

import java.util.List;

import pl.jakubjaroszek.pracadyplomowa.model.Transakcja;

public interface TransakcjaSerwis {
	
	Transakcja znajdzPoIdentyfikatorze(int identyfikator);
	
	void zapiszTransakcje(Transakcja transakcja);
	
	void usunTransakcje(int identyfikator);
	
	void aktualizujTransakcje(Transakcja transakcja);
	
	List<Transakcja> znajdzWszystkieTransakcje();
	
	Transakcja znajdzPoKluczuObcymSamochodu(int identyfikatorSamochodu);

}
