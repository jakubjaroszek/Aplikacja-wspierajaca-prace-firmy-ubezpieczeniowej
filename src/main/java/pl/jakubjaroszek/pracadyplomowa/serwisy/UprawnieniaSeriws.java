package pl.jakubjaroszek.pracadyplomowa.serwisy;

import java.util.List;

import pl.jakubjaroszek.pracadyplomowa.model.Uprawnienia;

public interface UprawnieniaSeriws {
	
	Uprawnienia znajdzPoIdentyfikatorze(int identyfikator);
	
	Uprawnienia znajdzPoRodzajuUprawnien(String rodzajUprawnien);
	
	List<Uprawnienia> znajdzWszystkie();

}
