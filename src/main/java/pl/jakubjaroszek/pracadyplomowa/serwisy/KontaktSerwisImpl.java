package pl.jakubjaroszek.pracadyplomowa.serwisy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.jakubjaroszek.pracadyplomowa.dao.KontaktDao;
import pl.jakubjaroszek.pracadyplomowa.model.Kontakt;

@Service("kontaktSerwis")
@Transactional
public class KontaktSerwisImpl implements KontaktSerwis {

	@Autowired
	private KontaktDao kontaktDao;

	public void zapiszKontakt(Kontakt kontakt) {
		kontaktDao.zapisz(kontakt);

	}

	public void usunKontaktPoIdentyfikatorze(int identyfikator) {
		kontaktDao.usun(identyfikator);
	}

	public List<Kontakt> znajdzWszystkieKontakty() {
		return kontaktDao.znajdz();
	}

}
