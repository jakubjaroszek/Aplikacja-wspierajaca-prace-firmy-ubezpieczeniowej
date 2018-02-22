package pl.jakubjaroszek.pracadyplomowa.serwisy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.jakubjaroszek.pracadyplomowa.dao.UzytkownikDao;
import pl.jakubjaroszek.pracadyplomowa.kontroler.dto.ResetowanieHaslaDaneDto;
import pl.jakubjaroszek.pracadyplomowa.model.Uzytkownik;

@Service("uzytkownikSerwis")
@Transactional
public class UzytkownikSerwisImpl implements UzytkownikSerwis {

	@Autowired
	private UzytkownikDao uzytkownikDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public Uzytkownik znajdzPoIdentyfikatorze(int identyfikator) {
		return uzytkownikDao.znajdzPoIdentyfikatorze(identyfikator);
	}

	public Uzytkownik znajdzPoLoginie(String login) {
		Uzytkownik uzytkownik = uzytkownikDao.znajdzPoLoginie(login);
		return uzytkownik;
	}

	public void zapiszUzytkownika(Uzytkownik uzytkownik) {
		uzytkownik.setHaslo(passwordEncoder.encode(uzytkownik.getHaslo()));
		uzytkownik.setPowtorzHaslo(passwordEncoder.encode(uzytkownik.getPowtorzHaslo()));
		uzytkownikDao.zapisz(uzytkownik);
	}

	public void aktualizujUzytkownika(Uzytkownik uzytkownik) {
		Uzytkownik encja = uzytkownikDao.znajdzPoIdentyfikatorze(uzytkownik.getIdentyfikator());
		if (encja != null) {
			encja.setLogin(uzytkownik.getLogin());
			if (!uzytkownik.getHaslo().equals(encja.getHaslo())) {
				encja.setHaslo(passwordEncoder.encode(uzytkownik.getHaslo()));
			}
			encja.setImie(uzytkownik.getImie());
			encja.setNazwisko(uzytkownik.getNazwisko());
			encja.setDzienUrodzenia(uzytkownik.getDzienUrodzenia());
			encja.setMiesiacUrodzenia(uzytkownik.getMiesiacUrodzenia());
			encja.setRokUrodzenia(uzytkownik.getRokUrodzenia());
			encja.setUlica(uzytkownik.getUlica());
			encja.setNumerDomuMieszkania(uzytkownik.getNumerDomuMieszkania());
			encja.setKodPocztowy(uzytkownik.getKodPocztowy());
			encja.setNumerTelefonu(uzytkownik.getNumerTelefonu());
			encja.setUprawnienia(uzytkownik.getUprawnienia());
		}

	}
	
	public void usunUzytkownikaPoIdentyfikatorze(int identyfikator) {
		uzytkownikDao.usunPoIdentyfikatorze(identyfikator);

	}
	public void usunUzytkownikaPoLoginie(String login) {
		uzytkownikDao.usunPoLoginie(login);
	}

	public List<Uzytkownik> znajdzWszystkichKlientow() {
		return uzytkownikDao.znajdzWszystkichKlientow();
	}
	
	public List<Uzytkownik> znajdzWszystkichPracownikow() {
		return uzytkownikDao.znajdzWszystkichPracownikow();
	}

	public boolean czyUzytkownikPosiadaUnikalnyLogin(Integer identyfikator, String login) {
		Uzytkownik uzytkownik = znajdzPoLoginie(login);
		return (uzytkownik == null || ((identyfikator != null) && (uzytkownik.getIdentyfikator() == identyfikator)));
	}

	public void aktualizujHasloUzytkownika(ResetowanieHaslaDaneDto resetowanieHaslaDaneDto) {
		Uzytkownik encja = uzytkownikDao.znajdzPoLoginie(resetowanieHaslaDaneDto.getLoginUzytkownika());
		if (!resetowanieHaslaDaneDto.getHaslo().equals(encja.getHaslo())) {
			encja.setHaslo(passwordEncoder.encode(resetowanieHaslaDaneDto.getHaslo()));
		}

	}


}
