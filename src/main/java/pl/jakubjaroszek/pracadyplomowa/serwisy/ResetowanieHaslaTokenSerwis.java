package pl.jakubjaroszek.pracadyplomowa.serwisy;

import pl.jakubjaroszek.pracadyplomowa.model.ResetowanieHaslaToken;

public interface ResetowanieHaslaTokenSerwis {
	
	public ResetowanieHaslaToken znajdzPoTokenie(String token);
	
	public void zapiszToken(ResetowanieHaslaToken resetowanieHaslaToken);

}
