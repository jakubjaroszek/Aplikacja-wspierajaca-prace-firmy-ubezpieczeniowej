package pl.jakubjaroszek.pracadyplomowa.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import pl.jakubjaroszek.pracadyplomowa.model.ResetowanieHaslaToken;

@Repository("resetowanieHaslaTokenDao")
public class ResetowanieHaslaTokenDaoImpl extends KlasaAbstrakcyjnaDao<Integer, ResetowanieHaslaToken> implements ResetowanieHaslaTokenDao {

	
	public ResetowanieHaslaToken znajdzPoTokenie(String token) {
		Criteria kryteria = utworzKryteriumZapytania();
		kryteria.add(Restrictions.eq("token", token));
		ResetowanieHaslaToken resetowanieHaslaToken = (ResetowanieHaslaToken) kryteria.uniqueResult();
		return resetowanieHaslaToken;
	}

	
	public void zapisz(ResetowanieHaslaToken resetowanieHaslaToken) {
		persist(resetowanieHaslaToken);
		
	}

}
