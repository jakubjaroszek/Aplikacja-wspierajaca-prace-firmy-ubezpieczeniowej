package pl.jakubjaroszek.pracadyplomowa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "samochod")
public class UbezpieczenieSamochodu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer identyfikator;

	@Column(name = "rok_produkcji_pojazdu", nullable = false)
	private String rokProdukcjiPojazdu;

	@Column(name = "marka", nullable = false)
	private String marka;

	@Column(name = "model", nullable = false)
	private String model;

	@Column(name = "pojemnosc_silnika", nullable = false)
	private String pojemnoscSilnika;

	@Column(name = "wersja_nadwozia", nullable = false)
	private String wersjaNadwozia;

	@Column(name = "sredni_roczny_przebieg", nullable = false)
	private String sredniRocznyPrzebieg;

	@Column(name = "rok_wydania_prawa_jazdy", nullable = false)
	private String rokWydaniaPrawaJazdy;

	@Column(name = "kierowcy_ponizej_26_roku_zycia", nullable = false)
	private String kierowcyPonizej26RokuZycia;

	@Column(name = "liczba_lat_jazdy_bezszkodowej", nullable = false)
	private String liczbaLatJazdyBezszkodowej;

	@Column(name = "zakres_ubezpieczenia", nullable = false)
	private String zakresUbezpieczenia;

	@Column(name = "miesiac_wyboru_rozpoczecia_ubezpieczenia", nullable = false)
	private Integer miesiacWyboruRozpoczeciaUbezpieczenia;

	@Column(name = "dzien_wyboru_rozpoczecia_ubezpieczenia", nullable = false)
	private Integer dzienWyboruRozpoczeciaUbezpieczenia;

	@Column(name = "czas_trwania_ubezpieczenia", nullable = false)
	private String czasTrwaniaUbezpieczenia;

	@Column(name = "rok_zakonczenia_ubezpieczenia", nullable = true)
	private Integer rokZakonczeniaUbezpieczenia;

	@Column(name = "wartosc_skladki_ubezpieczenia", nullable = true)
	private Double wartoscSkladkiUbezpieczenia;

	@Column(name = "numer_rejestracyjny_pojazdu", nullable = true)
	private String numerRejestracyjnyPojazdu;

	@Column(name = "numer_vin_pojazdu", nullable = true)
	private String numerVinPojazdu;

	@Column(name = "akceptacja_zawarcia_ubezpieczenia", nullable = true)
	private String akceptacjaZawarciaUbezpieczenia;

	public Integer getIdentyfikator() {
		return identyfikator;
	}

	public void setIdentyfikator(Integer identyfikator) {
		this.identyfikator = identyfikator;
	}

	public String getRokProdukcjiPojazdu() {
		return rokProdukcjiPojazdu;
	}

	public void setRokProdukcjiPojazdu(String rokProdukcjiPojazdu) {
		this.rokProdukcjiPojazdu = rokProdukcjiPojazdu;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPojemnoscSilnika() {
		return pojemnoscSilnika;
	}

	public void setPojemnoscSilnika(String pojemnoscSilnika) {
		this.pojemnoscSilnika = pojemnoscSilnika;
	}

	public String getWersjaNadwozia() {
		return wersjaNadwozia;
	}

	public void setWersjaNadwozia(String wersjaNadwozia) {
		this.wersjaNadwozia = wersjaNadwozia;
	}

	public String getSredniRocznyPrzebieg() {
		return sredniRocznyPrzebieg;
	}

	public void setSredniRocznyPrzebieg(String sredniRocznyPrzebieg) {
		this.sredniRocznyPrzebieg = sredniRocznyPrzebieg;
	}

	public String getRokWydaniaPrawaJazdy() {
		return rokWydaniaPrawaJazdy;
	}

	public void setRokWydaniaPrawaJazdy(String rokWydaniaPrawaJazdy) {
		this.rokWydaniaPrawaJazdy = rokWydaniaPrawaJazdy;
	}

	public String getKierowcyPonizej26RokuZycia() {
		return kierowcyPonizej26RokuZycia;
	}

	public void setKierowcyPonizej26RokuZycia(String kierowcyPonizej26RokuZycia) {
		this.kierowcyPonizej26RokuZycia = kierowcyPonizej26RokuZycia;
	}

	public String getLiczbaLatJazdyBezszkodowej() {
		return liczbaLatJazdyBezszkodowej;
	}

	public void setLiczbaLatJazdyBezszkodowej(String liczbaLatJazdyBezszkodowej) {
		this.liczbaLatJazdyBezszkodowej = liczbaLatJazdyBezszkodowej;
	}

	public String getZakresUbezpieczenia() {
		return zakresUbezpieczenia;
	}

	public void setZakresUbezpieczenia(String zakresUbezpieczenia) {
		this.zakresUbezpieczenia = zakresUbezpieczenia;
	}

	public String getCzasTrwaniaUbezpieczenia() {
		return czasTrwaniaUbezpieczenia;
	}

	public void setCzasTrwaniaUbezpieczenia(String czasTrwaniaUbezpieczenia) {
		this.czasTrwaniaUbezpieczenia = czasTrwaniaUbezpieczenia;
	}

	public Integer getMiesiacWyboruRozpoczeciaUbezpieczenia() {
		return miesiacWyboruRozpoczeciaUbezpieczenia;
	}

	public void setMiesiacWyboruRozpoczeciaUbezpieczenia(Integer miesiacWyboruRozpoczeciaUbezpieczenia) {
		this.miesiacWyboruRozpoczeciaUbezpieczenia = miesiacWyboruRozpoczeciaUbezpieczenia;
	}

	public Integer getDzienWyboruRozpoczeciaUbezpieczenia() {
		return dzienWyboruRozpoczeciaUbezpieczenia;
	}

	public void setDzienWyboruRozpoczeciaUbezpieczenia(Integer dzienWyboruRozpoczeciaUbezpieczenia) {
		this.dzienWyboruRozpoczeciaUbezpieczenia = dzienWyboruRozpoczeciaUbezpieczenia;
	}

	public Integer getRokZakonczeniaUbezpieczenia() {
		return rokZakonczeniaUbezpieczenia;
	}

	public void setRokZakonczeniaUbezpieczenia(Integer rokZakonczeniaUbezpieczenia) {
		this.rokZakonczeniaUbezpieczenia = rokZakonczeniaUbezpieczenia;
	}

	public Double getWartoscSkladkiUbezpieczenia() {
		return wartoscSkladkiUbezpieczenia;
	}

	public void setWartoscSkladkiUbezpieczenia(Double wartoscSkladkiUbezpieczenia) {
		this.wartoscSkladkiUbezpieczenia = wartoscSkladkiUbezpieczenia;
	}

	public String getNumerRejestracyjnyPojazdu() {
		return numerRejestracyjnyPojazdu;
	}

	public void setNumerRejestracyjnyPojazdu(String numerRejestracyjnyPojazdu) {
		this.numerRejestracyjnyPojazdu = numerRejestracyjnyPojazdu;
	}

	public String getNumerVinPojazdu() {
		return numerVinPojazdu;
	}

	public void setNumerVinPojazdu(String numerVinPojazdu) {
		this.numerVinPojazdu = numerVinPojazdu;
	}

	public String getAkceptacjaZawarciaUbezpieczenia() {
		return akceptacjaZawarciaUbezpieczenia;
	}

	public void setAkceptacjaZawarciaUbezpieczenia(String akceptacjaZawarciaUbezpieczenia) {
		this.akceptacjaZawarciaUbezpieczenia = akceptacjaZawarciaUbezpieczenia;
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
		UbezpieczenieSamochodu other = (UbezpieczenieSamochodu) obj;
		if (identyfikator == null) {
			if (other.identyfikator != null)
				return false;
		} else if (!identyfikator.equals(other.identyfikator))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UbezpieczenieSamochodu [identyfikator=" + identyfikator + ", rokProdukcjiPojazdu=" + rokProdukcjiPojazdu
				+ ", marka=" + marka + ", model=" + model + ", pojemnoscSilnika=" + pojemnoscSilnika
				+ ", wersjaNadwozia=" + wersjaNadwozia + ", sredniRocznyPrzebieg=" + sredniRocznyPrzebieg
				+ ", rokWydaniaPrawaJazdy=" + rokWydaniaPrawaJazdy + ", kierowcyPonizej26RokuZycia="
				+ kierowcyPonizej26RokuZycia + ", liczbaLatJazdyBezszkodowej=" + liczbaLatJazdyBezszkodowej
				+ ", zakresUbezpieczenia=" + zakresUbezpieczenia + ", miesiacWyboruRozpoczeciaUbezpieczenia="
				+ miesiacWyboruRozpoczeciaUbezpieczenia + ", dzienWyboruRozpoczeciaUbezpieczenia="
				+ dzienWyboruRozpoczeciaUbezpieczenia + ", czasTrwaniaUbezpieczenia=" + czasTrwaniaUbezpieczenia
				+ ", rokZakonczeniaUbezpieczenia=" + rokZakonczeniaUbezpieczenia + ", wartoscSkladkiUbezpieczenia="
				+ wartoscSkladkiUbezpieczenia + ", numerRejestracyjnyPojazdu=" + numerRejestracyjnyPojazdu
				+ ", numerVinPojazdu=" + numerVinPojazdu + ", akceptacjaZawarciaUbezpieczenia="
				+ akceptacjaZawarciaUbezpieczenia + "]";
	}

}
