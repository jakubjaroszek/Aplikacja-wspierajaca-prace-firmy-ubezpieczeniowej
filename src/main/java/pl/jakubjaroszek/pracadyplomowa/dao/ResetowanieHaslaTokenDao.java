package pl.jakubjaroszek.pracadyplomowa.dao;

import pl.jakubjaroszek.pracadyplomowa.model.ResetowanieHaslaToken;

public interface ResetowanieHaslaTokenDao {
	
	ResetowanieHaslaToken znajdzPoTokenie(String token);
	
	void zapisz(ResetowanieHaslaToken resetowanieHaslaToken);

}
