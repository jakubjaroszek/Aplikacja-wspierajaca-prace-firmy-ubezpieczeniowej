package pl.jakubjaroszek.pracadyplomowa.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.GenerationType;

@Entity
@Table(name = "uzytkownik")
public class Uzytkownik implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer identyfikator;

	@OneToOne
	@JoinColumn(name="identyfikator_ubezpieczenia")
	private UbezpieczenieSamochodu ubezpieczenieSamochodu;

	@Column(name = "login", nullable = false)
	private String login;

	@Column(name = "haslo", nullable = false)
	private String haslo;

	@Column(name = "powtorz_haslo", nullable = false)
	private String powtorzHaslo;

	@Column(name = "imie", nullable = false)
	private String imie;

	@Column(name = "nazwisko", nullable = false)
	private String nazwisko;

	@Column(name = "dzien_urodzenia", nullable = false)
	private String dzienUrodzenia;

	@Column(name = "miesiac_urodzenia", nullable = false)
	private String miesiacUrodzenia;

	@Column(name = "rok_urodzenia", nullable = false)
	private String rokUrodzenia;

	@Column(name = "ulica", nullable = false)
	private String ulica;

	@Column(name = "numer_domu_mieszkania", nullable = false)
	private String numerDomuMieszkania;

	@Column(name = "kod_pocztowy", nullable = false)
	private String kodPocztowy;

	@Column(name = "numer_telefonu", nullable = false)
	private String numerTelefonu;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "uprawnienia_w_aplikacji", joinColumns = {
			@JoinColumn(name = "identyfikator_uzytkownika") }, inverseJoinColumns = {
					@JoinColumn(name = "identyfikator_uprawnien") })
	private Set<Uprawnienia> uprawnienia = new HashSet<Uprawnienia>();

	public Integer getIdentyfikator() {
		return identyfikator;
	}

	public void setIdentyfikator(Integer identyfikator) {
		this.identyfikator = identyfikator;
	}

	
	public UbezpieczenieSamochodu getUbezpieczenieSamochodu() {
		return ubezpieczenieSamochodu;
	}

	public void setUbezpieczenieSamochodu(UbezpieczenieSamochodu ubezpieczenieSamochodu) {
		this.ubezpieczenieSamochodu = ubezpieczenieSamochodu;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

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

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getDzienUrodzenia() {
		return dzienUrodzenia;
	}

	public void setDzienUrodzenia(String dzienUrodzenia) {
		this.dzienUrodzenia = dzienUrodzenia;
	}

	public String getMiesiacUrodzenia() {
		return miesiacUrodzenia;
	}

	public void setMiesiacUrodzenia(String miesiacUrodzenia) {
		this.miesiacUrodzenia = miesiacUrodzenia;
	}

	public String getRokUrodzenia() {
		return rokUrodzenia;
	}

	public void setRokUrodzenia(String rokUrodzenia) {
		this.rokUrodzenia = rokUrodzenia;
	}

	public String getNumerDomuMieszkania() {
		return numerDomuMieszkania;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public void setNumerDomuMieszkania(String numerDomuMieszkania) {
		this.numerDomuMieszkania = numerDomuMieszkania;
	}

	public String getKodPocztowy() {
		return kodPocztowy;
	}

	public void setKodPocztowy(String kodPocztowy) {
		this.kodPocztowy = kodPocztowy;
	}

	public String getNumerTelefonu() {
		return numerTelefonu;
	}

	public void setNumerTelefonu(String numerTelefonu) {
		this.numerTelefonu = numerTelefonu;
	}

	public Set<Uprawnienia> getUprawnienia() {
		return uprawnienia;
	}

	public void setUprawnienia(Set<Uprawnienia> uprawnienia) {
		this.uprawnienia = uprawnienia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identyfikator == null) ? 0 : identyfikator.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Uzytkownik other = (Uzytkownik) obj;
		if (identyfikator == null) {
			if (other.identyfikator != null)
				return false;
		} else if (!identyfikator.equals(other.identyfikator))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Uzytkownik [identyfikator=" + identyfikator + ", ubezpieczenieSamochodu=" + ubezpieczenieSamochodu
				+ ", login=" + login + ", haslo=" + haslo + ", powtorzHaslo=" + powtorzHaslo + ", imie=" + imie
				+ ", nazwisko=" + nazwisko + ", dzienUrodzenia=" + dzienUrodzenia + ", miesiacUrodzenia="
				+ miesiacUrodzenia + ", rokUrodzenia=" + rokUrodzenia + ", ulica=" + ulica + ", numerDomuMieszkania="
				+ numerDomuMieszkania + ", kodPocztowy=" + kodPocztowy + ", numerTelefonu=" + numerTelefonu
				+ ", uprawnienia=" + uprawnienia + "]";
	}
	
}
