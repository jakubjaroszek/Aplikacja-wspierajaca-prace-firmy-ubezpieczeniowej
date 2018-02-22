package pl.jakubjaroszek.pracadyplomowa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "uprawnienia")
public class Uprawnienia implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer identyfikator;

	@Column(name = "rodzaj_uprawnien", length = 15, unique = true, nullable = false)
	private String rodzajUprawnien = UprawnieniaProfiluUzytkownika.KONSULTANT.getUprawnieniaProfiluUzytkownika();

	public Integer getIdentyfikator() {
		return identyfikator;
	}

	public void setIdentyfikator(Integer identyfikator) {
		this.identyfikator = identyfikator;
	}

	public String getRodzajUprawnien() {
		return rodzajUprawnien;
	}

	public void setRodzajUprawnien(String rodzajUprawnien) {
		this.rodzajUprawnien = rodzajUprawnien;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identyfikator == null) ? 0 : identyfikator.hashCode());
		result = prime * result + ((rodzajUprawnien == null) ? 0 : rodzajUprawnien.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Uprawnienia))
			return false;
		Uprawnienia other = (Uprawnienia) obj;
		if (identyfikator == null) {
			if (other.identyfikator != null)
				return false;
		} else if (!identyfikator.equals(other.identyfikator))
			return false;
		if (rodzajUprawnien == null) {
			if (other.rodzajUprawnien != null)
				return false;
		} else if (!rodzajUprawnien.equals(other.rodzajUprawnien))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Uprawnienia [identyfikator=" + identyfikator + ",rodzajUprawnien=" + rodzajUprawnien + "]";
	}

}
