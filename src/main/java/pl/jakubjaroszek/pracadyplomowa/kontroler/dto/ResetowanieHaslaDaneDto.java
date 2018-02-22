package pl.jakubjaroszek.pracadyplomowa.kontroler.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class ResetowanieHaslaDaneDto {
	
	@NotEmpty
	private String haslo;
	
	@NotEmpty
	private String powtorzHaslo;
	
	private String loginUzytkownika;

	public String getHaslo() {
		return haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	public String getPowtorzHaslo() {
		return powtorzHaslo;
	}

	public void setPowtorzHaslo(String powtorzHaslo) {
		this.powtorzHaslo = powtorzHaslo;
	}

	public String getLoginUzytkownika() {
		return loginUzytkownika;
	}

	public void setLoginUzytkownika(String loginUzytkownika) {
		this.loginUzytkownika = loginUzytkownika;
	}
}
