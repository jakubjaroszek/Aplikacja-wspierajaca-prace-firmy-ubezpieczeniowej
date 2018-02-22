package pl.jakubjaroszek.pracadyplomowa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kontakt")
public class Kontakt implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer identyfikator;

	@Column(name = "rodzaj_ubezpieczenia", nullable = false)
	private String rodzajUbezpieczenia;

	@Column(name = "imie", nullable = false)
	private String imie;

	@Column(name = "nazwisko", nullable = false)
	private String nazwisko;

	@Column(name = "numer_telefonu", nullable = false)
	private String numerTelefonu;

	@Column(name = "adres_email", nullable = false)
	private String adresEmail;

	public Integer getIdentyfikator() {
		return identyfikator;
	}

	public void setIdentyfikator(Integer identyfikator) {
		this.identyfikator = identyfikator;
	}

	public String getRodzajUbezpieczenia() {
		return rodzajUbezpieczenia;
	}

	public void setRodzajUbezpieczenia(String rodzajUbezpieczenia) {
		this.rodzajUbezpieczenia = rodzajUbezpieczenia;
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

	public String getNumerTelefonu() {
		return numerTelefonu;
	}

	public void setNumerTelefonu(String numerTelefonu) {
		this.numerTelefonu = numerTelefonu;
	}

	public String getAdresEmail() {
		return adresEmail;
	}

	public void setAdresEmail(String adresEmail) {
		this.adresEmail = adresEmail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identyfikator == null) ? 0 : identyfikator.hashCode());
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
		Kontakt other = (Kontakt) obj;
		if (identyfikator == null) {
			if (other.identyfikator != null)
				return false;
		} else if (!identyfikator.equals(other.identyfikator))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Kontakt [identyfikator=" + identyfikator + ", rodzajUbezpieczenia=" + rodzajUbezpieczenia + ", imie="
				+ imie + ", nazwisko=" + nazwisko + ", numerTelefonu=" + numerTelefonu + ", adresEmail=" + adresEmail
				+ "]";
	}

}
