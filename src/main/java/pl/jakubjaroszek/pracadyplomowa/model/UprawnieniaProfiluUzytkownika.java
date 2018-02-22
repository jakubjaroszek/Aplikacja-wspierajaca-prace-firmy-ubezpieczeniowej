package pl.jakubjaroszek.pracadyplomowa.model;

import java.io.Serializable;

public enum UprawnieniaProfiluUzytkownika implements Serializable {
	KLIENT("KLIENT"), KONSULTANT("KONSULTANT"), ADMINISTRATOR("ADMINISTRATOR");
	
	String uprawnieniaProfiluUzytkownika;

	private UprawnieniaProfiluUzytkownika(String uprawnieniaProfiluUzytkownika) {
		this.uprawnieniaProfiluUzytkownika = uprawnieniaProfiluUzytkownika;
	}

	public String getUprawnieniaProfiluUzytkownika() {
		return uprawnieniaProfiluUzytkownika;
	}

}
