package pl.jakubjaroszek.pracadyplomowa.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "resetowanie_hasla_token")
public class ResetowanieHaslaToken {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long identyfikator;

	@Column(name = "token", nullable = false)
	private String token;

	@NotEmpty
	@Column(name = "login_uzytkownika", nullable = false)
	private String loginUzytkownika;

	@Column(name = "data_wygasniecia_tokena", nullable = false)
	private Date dataWygasnieciaTokena;

	public Long getIdentyfikator() {
		return identyfikator;
	}

	public void setIdentyfikator(Long identyfikator) {
		this.identyfikator = identyfikator;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getLoginUzytkownika() {
		return loginUzytkownika;
	}

	public void setLoginUzytkownika(String loginUzytkownika) {
		this.loginUzytkownika = loginUzytkownika;
	}

	public Date getDataWygasnieciaTokena() {
		return dataWygasnieciaTokena;
	}

	public void setDataWygasnieciaTokena(int dataWygasnieciaTokena) {
		Calendar kalendarz = Calendar.getInstance();
		kalendarz.add(Calendar.MINUTE, dataWygasnieciaTokena);
		this.dataWygasnieciaTokena = kalendarz.getTime();
	}

	public boolean tokenStracilWaznosc() {
		return new Date().after(this.dataWygasnieciaTokena);
	}

}
