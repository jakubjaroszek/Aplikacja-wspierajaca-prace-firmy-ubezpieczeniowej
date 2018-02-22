package pl.jakubjaroszek.pracadyplomowa.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class KlasaAbstrakcyjnaDao <PK extends Serializable,T> {
	
	private final Class<T> klasaTrwalosci;
	
	@SuppressWarnings("unchecked")
	public KlasaAbstrakcyjnaDao(){
		this.klasaTrwalosci =(Class <T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	@Autowired
	private SessionFactory fabrykaSesji;
	
	protected Session getSesja(){
		return fabrykaSesji.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public T znajdzPoKluczu(PK klucz) {
		return (T) getSesja().get(klasaTrwalosci, klucz);
	}
	
	public void persist(T encja) {
		getSesja().persist(encja);
	}
	
	public void aktualizuj(T encja) {
		getSesja().update(encja);	
	}
	
	public void usun(T encja) {
		getSesja().delete(encja);
	}
	
	protected Criteria utworzKryteriumZapytania() {
		return getSesja().createCriteria(klasaTrwalosci);
	}

}
