package pl.jakubjaroszek.pracadyplomowa.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pl.jakubjaroszek.pracadyplomowa.model.Uzytkownik;

@Repository("uzytkownikDao")
public class UzytkownikDaoImpl extends KlasaAbstrakcyjnaDao<Integer, Uzytkownik> implements UzytkownikDao {
	
	static final Logger rejestrator = LoggerFactory.getLogger(UzytkownikDaoImpl.class);

	
	public Uzytkownik znajdzPoIdentyfikatorze(int identyfikator) {
			Uzytkownik uzytkownik = znajdzPoKluczu(identyfikator);
					if(uzytkownik!=null) {
						Hibernate.initialize(uzytkownik.getUprawnienia());
					}
		return uzytkownik;
	}

	
	public Uzytkownik znajdzPoLoginie(String login) {
		rejestrator.info("Login: {}", login);
		Criteria kryteria = utworzKryteriumZapytania();
		kryteria.add(Restrictions.eq("login", login));
		Uzytkownik uzytkownik = (Uzytkownik)kryteria.uniqueResult();
		if (uzytkownik!=null) {
			Hibernate.initialize(uzytkownik.getUprawnienia());
		}
		return uzytkownik;
	}

	
	public void zapisz(Uzytkownik uzytkownik) {
		persist(uzytkownik);
		
	}

	
	public void usunPoLoginie(String login) {
		Criteria kryteria = utworzKryteriumZapytania();
		kryteria.add(Restrictions.eq("login",login));
		Uzytkownik uzytkownik = (Uzytkownik)kryteria.uniqueResult();
		usun(uzytkownik);
		
	}
	
	public void usunPoIdentyfikatorze (int identyfikator) {
		Criteria kryteria = utworzKryteriumZapytania();
		kryteria.add(Restrictions.eq("identyfikator", identyfikator));
		Uzytkownik uzytkownik = (Uzytkownik) kryteria.uniqueResult();
		usun(uzytkownik);
	}

	
	@SuppressWarnings("unchecked")
	public List<Uzytkownik> znajdzWszystkichKlientow() {
		Criteria kryteria = utworzKryteriumZapytania().addOrder(Order.asc("imie"));
		kryteria.add(Restrictions.isNotNull("ubezpieczenieSamochodu.identyfikator"));
		kryteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Uzytkownik> uzytkownicy = (List<Uzytkownik>) kryteria.list();
		return uzytkownicy;
	}

	
	@SuppressWarnings("unchecked")
	public List<Uzytkownik> znajdzWszystkichPracownikow() {
		Criteria kryteria = utworzKryteriumZapytania().addOrder(Order.asc("imie"));
		kryteria.add(Restrictions.isNull("ubezpieczenieSamochodu.identyfikator"));
		kryteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Uzytkownik> pracownicy = (List<Uzytkownik>) kryteria.list();
		return pracownicy;
	}

}
