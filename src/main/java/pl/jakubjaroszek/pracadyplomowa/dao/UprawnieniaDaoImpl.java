package pl.jakubjaroszek.pracadyplomowa.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import pl.jakubjaroszek.pracadyplomowa.model.Uprawnienia;

@Repository("uprawnieniaDao")
public class UprawnieniaDaoImpl extends KlasaAbstrakcyjnaDao<Integer, Uprawnienia> implements UprawnieniaDao {

	@SuppressWarnings("unchecked")
	public List<Uprawnienia> znajdzWszystkie() {
		Criteria kryteria = utworzKryteriumZapytania();
		kryteria.addOrder(Order.asc("rodzajUprawnien"));
		return (List<Uprawnienia>)kryteria.list();
	}

	
	public Uprawnienia znajdzPoRodzajuUprawnien(String rodzajUprawnien) {
		Criteria kryteria = utworzKryteriumZapytania();
		kryteria.add(Restrictions.eq("rodzajUprawnien", rodzajUprawnien));
		return (Uprawnienia) kryteria.uniqueResult();
	}

	
	public Uprawnienia znajdzPoIdentyfikatorze(int identyfikator) {
		return znajdzPoKluczu(identyfikator);
	}

}
