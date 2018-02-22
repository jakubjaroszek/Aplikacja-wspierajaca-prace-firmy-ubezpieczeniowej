package pl.jakubjaroszek.pracadyplomowa.konfiguracja;

import javax.servlet.http.HttpServletRequest;

public class KonfiguracjaAdresowPaypal {
	
	public static String znajdzAdresBazowy(HttpServletRequest zapytanie) {
		String schemat = zapytanie.getScheme();
		String nazwaSerwera = zapytanie.getServerName();
		int portSerwera = zapytanie.getServerPort();
		String sciezkaInformacji = zapytanie.getContextPath();
		StringBuffer adres = new StringBuffer();
		adres.append(schemat).append("://").append(nazwaSerwera);
		if ((portSerwera != 80) && (portSerwera != 443)) {
			adres.append(":").append(portSerwera);
		}
		adres.append(sciezkaInformacji);
		if(adres.toString().endsWith("/")) {
			adres.append("/");
		}
		return adres.toString();
	} 

}
