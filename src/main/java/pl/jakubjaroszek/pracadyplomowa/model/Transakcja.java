package pl.jakubjaroszek.pracadyplomowa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "transakcja")
public class Transakcja implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer identyfikator;

	@OneToOne
	@JoinColumn(name = "identyfikator_samochodu")
	private UbezpieczenieSamochodu ubezpieczenieSamochodu;

	@Column(name = "wartosc_skladki_ubezpieczenia_samochodu", nullable = false)
	private Double wartoscSkladkiUbezpieczeniaSamochodu;

	@Column(name = "data_wplaty", nullable = true)
	private String dataWplaty;

	@Column(name = "status_transakcji", nullable = true)
	private String statusTransakcji;

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

	public Double getWartoscSkladkiUbezpieczeniaSamochodu() {
		return wartoscSkladkiUbezpieczeniaSamochodu;
	}

	public void setWartoscSkladkiUbezpieczeniaSamochodu(Double wartoscSkladkiUbezpieczeniaSamochodu) {
		this.wartoscSkladkiUbezpieczeniaSamochodu = wartoscSkladkiUbezpieczeniaSamochodu;
	}

	public String getDataWplaty() {
		return dataWplaty;
	}

	public void setDataWplaty(String dataWplaty) {
		this.dataWplaty = dataWplaty;
	}

	public String getStatusTransakcji() {
		return statusTransakcji;
	}

	public void setStatusTransakcji(String statusTransakcji) {
		this.statusTransakcji = statusTransakcji;
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
		Transakcja other = (Transakcja) obj;
		if (identyfikator == null) {
			if (other.identyfikator != null)
				return false;
		} else if (!identyfikator.equals(other.identyfikator))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transakcja [identyfikator=" + identyfikator + ", ubezpieczenieSamochodu=" + ubezpieczenieSamochodu
				+ ", wartoscSkladkiUbezpieczeniaSamochodu=" + wartoscSkladkiUbezpieczeniaSamochodu + ", dataWplaty="
				+ dataWplaty + ", statusTransakcji=" + statusTransakcji + "]";
	}

}
