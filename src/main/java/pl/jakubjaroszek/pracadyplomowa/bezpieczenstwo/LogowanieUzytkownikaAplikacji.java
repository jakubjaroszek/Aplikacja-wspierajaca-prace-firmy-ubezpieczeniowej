package pl.jakubjaroszek.pracadyplomowa.bezpieczenstwo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.jakubjaroszek.pracadyplomowa.model.Uprawnienia;
import pl.jakubjaroszek.pracadyplomowa.model.Uzytkownik;
import pl.jakubjaroszek.pracadyplomowa.serwisy.UzytkownikSerwis;

@Service("logowanieUzytkownikaAplikacji")
public class LogowanieUzytkownikaAplikacji implements UserDetailsService {
	
	static final Logger rejestrator = LoggerFactory.getLogger(LogowanieUzytkownikaAplikacji.class);
	
	@Autowired
	private UzytkownikSerwis uzytkownikSerwis;

	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Uzytkownik uzytkownik = uzytkownikSerwis.znajdzPoLoginie(login);
		rejestrator.info("Uzytkownik : {}", uzytkownik);
		if (uzytkownik==null) {
			rejestrator.info("Uzytkownik nie znaleziony");
			throw new UsernameNotFoundException("login nie znaleziony");
		}
		return new org.springframework.security.core.userdetails.User(uzytkownik.getLogin(),uzytkownik.getHaslo(),
				true,true,true,true, getPrzyznaneUprawnienia(uzytkownik));
	}
	
	private List<GrantedAuthority> getPrzyznaneUprawnienia(Uzytkownik uzytkownik) {
		List<GrantedAuthority> przyznaneUprawnienia = new ArrayList<GrantedAuthority>();
		
		for(Uprawnienia uprawnienia : uzytkownik.getUprawnienia()) {
			rejestrator.info("Uprawnienia uzytkownika: {}", uprawnienia);
			przyznaneUprawnienia.add(new SimpleGrantedAuthority("ROLE_"+uprawnienia.getRodzajUprawnien()));
		}
		
		rejestrator.info("przyznane uprawnienia: {}", przyznaneUprawnienia);
		return przyznaneUprawnienia;
	}
	
}
