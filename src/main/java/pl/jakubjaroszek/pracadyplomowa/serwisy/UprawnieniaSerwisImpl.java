package pl.jakubjaroszek.pracadyplomowa.serwisy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.jakubjaroszek.pracadyplomowa.dao.UprawnieniaDao;
import pl.jakubjaroszek.pracadyplomowa.model.Uprawnienia;

@Service("uprawnieniaSerwis")
@Transactional
public class UprawnieniaSerwisImpl implements UprawnieniaSeriws {

	@Autowired
	UprawnieniaDao uprawnieniaDao;

	public Uprawnienia znajdzPoIdentyfikatorze(int identyfikator) {
		return uprawnieniaDao.znajdzPoIdentyfikatorze(identyfikator);
	}

	public Uprawnienia znajdzPoRodzajuUprawnien(String rodzajUprawnien) {
		return uprawnieniaDao.znajdzPoRodzajuUprawnien(rodzajUprawnien);
	}

	public List<Uprawnienia> znajdzWszystkie() {
		return uprawnieniaDao.znajdzWszystkie();
	}

}
