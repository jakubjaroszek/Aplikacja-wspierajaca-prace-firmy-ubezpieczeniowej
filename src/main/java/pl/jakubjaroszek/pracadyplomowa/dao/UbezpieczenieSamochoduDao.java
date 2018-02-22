package pl.jakubjaroszek.pracadyplomowa.dao;

import pl.jakubjaroszek.pracadyplomowa.model.UbezpieczenieSamochodu;

public interface UbezpieczenieSamochoduDao {
	
	UbezpieczenieSamochodu znajdzPoIdentyfikatorze(int identyfikator);
	
	void zapisz(UbezpieczenieSamochodu ubezpieczenieSamochodu);
	
	void usunPoIdentyfikatorze(int identyfikator);
	
}
