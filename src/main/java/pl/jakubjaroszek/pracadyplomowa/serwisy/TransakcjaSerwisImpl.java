package pl.jakubjaroszek.pracadyplomowa.serwisy;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.jakubjaroszek.pracadyplomowa.dao.TransakcjaDao;
import pl.jakubjaroszek.pracadyplomowa.model.Transakcja;

@Service("transakcjaSerwis")
@Transactional
public class TransakcjaSerwisImpl implements TransakcjaSerwis {

	@Autowired
	private TransakcjaDao transakcjaDao;

	public Transakcja znajdzPoIdentyfikatorze(int identyfikator) {

		return transakcjaDao.znajdzPoIdentyfikatorze(identyfikator);
	}

	public void zapiszTransakcje(Transakcja transakcja) {
		transakcjaDao.zapisz(transakcja);

	}

	public void usunTransakcje(int identyfikator) {
		transakcjaDao.usun(identyfikator);

	}

	public void aktualizujTransakcje(Transakcja transakcja) {

		Date d1 = new Date();
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/YYYY HH:mm a");
		String formattedDate = df.format(d1);

		Transakcja encja = transakcjaDao.znajdzPoIdentyfikatorze(transakcja.getIdentyfikator());

		encja.setStatusTransakcji("Zrealizowana");
		encja.setDataWplaty(formattedDate);

	}

	public List<Transakcja> znajdzWszystkieTransakcje() {
		return transakcjaDao.znajdz();
	}

	public Transakcja znajdzPoKluczuObcymSamochodu(int identyfikatorSamochodu) {

		return transakcjaDao.znajdzPoKluczuObcymSamochodu(identyfikatorSamochodu);
	}

}
