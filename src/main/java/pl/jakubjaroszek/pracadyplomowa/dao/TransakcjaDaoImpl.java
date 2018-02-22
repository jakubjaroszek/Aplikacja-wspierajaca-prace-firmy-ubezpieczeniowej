package pl.jakubjaroszek.pracadyplomowa.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import pl.jakubjaroszek.pracadyplomowa.model.Transakcja;


@Repository("transakcjaDao")
public class TransakcjaDaoImpl extends KlasaAbstrakcyjnaDao<Integer, Transakcja> implements TransakcjaDao {

	
	public Transakcja znajdzPoIdentyfikatorze(int identyfikator) {
		Transakcja transakcja = znajdzPoKluczu(identyfikator);
		return transakcja;
	}

	
	public void zapisz(Transakcja transakcja) {
		persist(transakcja);
		
	}

	
	public void usun(int identyfikator) {
		Criteria kryteria = utworzKryteriumZapytania();
		kryteria.add(Restrictions.eqOrIsNull("identyfikator", identyfikator));
		Transakcja transakcja = (Transakcja)kryteria.uniqueResult();
		usun(transakcja);
	}


	@SuppressWarnings("unchecked")
	public List<Transakcja> znajdz() {
		Criteria kryteria = utworzKryteriumZapytania().addOrder(Order.asc("identyfikator"));
		kryteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Transakcja> transakcje = (List<Transakcja>) kryteria.list();
		return transakcje;
	}
		
	public Transakcja znajdzPoKluczuObcymSamochodu(int identyfikator) {
		Criteria kryteria = utworzKryteriumZapytania();
		kryteria.add(Restrictions.eq("ubezpieczenieSamochodu.identyfikator", identyfikator));
		Transakcja transakcja = (Transakcja)kryteria.uniqueResult();
		return transakcja;
	}

}
