package pl.jakubjaroszek.pracadyplomowa.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pl.jakubjaroszek.pracadyplomowa.model.Kontakt;


@Repository("kontaktDao")
public class KontaktDaoImpl extends KlasaAbstrakcyjnaDao<Integer, Kontakt> implements KontaktDao {
	
	static final Logger rejestrator = LoggerFactory.getLogger(KontaktDaoImpl.class);

	
	public void zapisz(Kontakt kontakt) {
		persist(kontakt);
	}

	
	public void usun(int identyfikator) {
		Criteria kryteria = utworzKryteriumZapytania();
		kryteria.add(Restrictions.eq("identyfikator", identyfikator));
		Kontakt kontakt = (Kontakt)kryteria.uniqueResult();
		usun(kontakt);
		
	}

	
	@SuppressWarnings("unchecked")
	public List<Kontakt> znajdz() {
		Criteria kryteria = utworzKryteriumZapytania().addOrder(Order.asc("identyfikator"));
		kryteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Kontakt> kontakty = (List<Kontakt>) kryteria.list();
		return kontakty;
	}

}
