package pl.jakubjaroszek.pracadyplomowa.dao;

import java.util.List;

import pl.jakubjaroszek.pracadyplomowa.model.Transakcja;

public interface TransakcjaDao {
	
	Transakcja znajdzPoIdentyfikatorze(int identyfikator);
	
	void zapisz(Transakcja transakcja);
	
	void usun(int identyfikator);
	
	List<Transakcja> znajdz();
	
	Transakcja znajdzPoKluczuObcymSamochodu(int identyfikatorSamochodu);

}
