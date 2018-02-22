package pl.jakubjaroszek.pracadyplomowa.model;

import java.util.Map;

public class WiadomoscEmail {

	private String nadawca;

	private String odbiorca;

	private String temat;

	private String poczatekWiadomosci;

	private String adresResetujacyHaslo;

	private String koniecWiadomosci;

	public String getNadawca() {
		return nadawca;
	}

	public void setNadawca(String nadawca) {
		this.nadawca = nadawca;
	}

	public String getOdbiorca() {
		return odbiorca;
	}

	public void setOdbiorca(String odbiorca) {
		this.odbiorca = odbiorca;
	}

	public String getTemat() {
		return temat;
	}

	public void setTemat(String temat) {
		this.temat = temat;
	}

	public String getPoczatekWiadomosci() {
		return poczatekWiadomosci;
	}

	public void setPoczatekWiadomosci(String poczatekWiadomosci) {
		this.poczatekWiadomosci = poczatekWiadomosci;
	}

	public String getAdresResetujacyHaslo() {
		return adresResetujacyHaslo;
	}

	public void setAdresResetujacyHaslo(String adresResetujacyHaslo) {
		this.adresResetujacyHaslo = adresResetujacyHaslo;
	}

	public String getKoniecWiadomosci() {
		return koniecWiadomosci;
	}

	public void setKoniecWiadomosci(String koniecWiadomosci) {
		this.koniecWiadomosci = koniecWiadomosci;
	}

}
