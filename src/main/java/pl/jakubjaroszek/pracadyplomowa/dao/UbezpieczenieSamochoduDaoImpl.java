package pl.jakubjaroszek.pracadyplomowa.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import pl.jakubjaroszek.pracadyplomowa.model.UbezpieczenieSamochodu;

@Repository("ubezpieczenieSamochoduDao")
public class UbezpieczenieSamochoduDaoImpl extends KlasaAbstrakcyjnaDao<Integer, UbezpieczenieSamochodu> 
implements UbezpieczenieSamochoduDao {
	
	public UbezpieczenieSamochodu znajdzPoIdentyfikatorze(int identyfikator) {
		UbezpieczenieSamochodu ubezpieczenieSamochodu = znajdzPoKluczu(identyfikator);
		return ubezpieczenieSamochodu;
	}

	
	public void zapisz(UbezpieczenieSamochodu ubezpieczenieSamochodu) {
		persist(ubezpieczenieSamochodu);
		
	}

	public void usunPoIdentyfikatorze(int identyfikator) {
		Criteria kryteria = utworzKryteriumZapytania();
		kryteria.add(Restrictions.eq("identyfikator", identyfikator));
		UbezpieczenieSamochodu ubezpieczenieSamochodu = (UbezpieczenieSamochodu)kryteria.uniqueResult();
		usun(ubezpieczenieSamochodu);
	}

}
