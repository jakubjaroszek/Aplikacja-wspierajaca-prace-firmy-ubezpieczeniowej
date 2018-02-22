package pl.jakubjaroszek.pracadyplomowa.bezpieczenstwo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class KonfiguracjaModuluSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	@Qualifier("logowanieUzytkownikaAplikacji")
	UserDetailsService logowanieUzytkownika;
	
	@Autowired
	public void konfiguracjaOgolnegoBezpieczenstwa(AuthenticationManagerBuilder autoryzacja) throws Exception {
		autoryzacja.userDetailsService(logowanieUzytkownika);
		autoryzacja.authenticationProvider(dostepAutoryzacji());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/","/listaWszystkichUzytkownikow")
		.access("hasRole('KLIENT') or hasRole('KONSULTANT') or hasRole('ADMINISTRATOR')")
		.antMatchers("/menu").access("hasRole('KLIENT')")
		.antMatchers("/nowyUzytkownik/**", "/usunUzytkownika*").access("hasRole('ADMINISTRATOR')")
		.antMatchers("/edytujUzytkownika*").access("hasRole('KONSULTANT') or hasRole('ADMINISTRATOR')")
		.and().formLogin().loginPage("/stronaGlowna").loginProcessingUrl("/stronaGlowna")
		.usernameParameter("login").passwordParameter("haslo").and().csrf().and().exceptionHandling()
		.accessDeniedPage("/brakDostepu");
	
	}
	
	@Bean
	public DaoAuthenticationProvider dostepAutoryzacji() {
		DaoAuthenticationProvider dostepAutoryzacji = new DaoAuthenticationProvider();
		dostepAutoryzacji.setUserDetailsService(logowanieUzytkownika);
		dostepAutoryzacji.setPasswordEncoder(passwordEncoder());
		return dostepAutoryzacji;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationTrustResolver getAuthenticationTrustResolver() {
		return new AuthenticationTrustResolverImpl();
	}
	

}
