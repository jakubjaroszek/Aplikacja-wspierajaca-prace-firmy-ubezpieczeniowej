package pl.jakubjaroszek.pracadyplomowa.serwisy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.jakubjaroszek.pracadyplomowa.dao.ResetowanieHaslaTokenDao;
import pl.jakubjaroszek.pracadyplomowa.model.ResetowanieHaslaToken;

@Service("resetowanieHaslaTokenSerwisImpl")
@Transactional
public class ResetowanieHaslaTokenSerwisImpl implements ResetowanieHaslaTokenSerwis {

	@Autowired
	private ResetowanieHaslaTokenDao resetowanieHaslaTokenDao;
	
	public ResetowanieHaslaToken znajdzPoTokenie(String token) {
		
		return resetowanieHaslaTokenDao.znajdzPoTokenie(token);
	}

	public void zapiszToken(ResetowanieHaslaToken resetowanieHaslaToken) {
	resetowanieHaslaTokenDao.zapisz(resetowanieHaslaToken);
		
	}

}
