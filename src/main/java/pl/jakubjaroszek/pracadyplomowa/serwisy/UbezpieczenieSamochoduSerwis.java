package pl.jakubjaroszek.pracadyplomowa.serwisy;

import pl.jakubjaroszek.pracadyplomowa.model.UbezpieczenieSamochodu;

public interface UbezpieczenieSamochoduSerwis {

	UbezpieczenieSamochodu znajdzPoIdentyfikatorze(int identyfikator);

	void zapiszUbezpieczenieSamochodu(UbezpieczenieSamochodu ubezpieczenieSamochodu);

	void usunUbezpieczenieSamochoduPoIdentyfikatorze(int identyfikator);

	void obliczSkladkeUbezpieczeniaSamochodu(UbezpieczenieSamochodu ubezpieczenieSamochodu);

	void zapiszDanePojazdu(UbezpieczenieSamochodu ubezpieczenieSamochodu);

	void zapiszWarunek(UbezpieczenieSamochodu ubezpieczenieSamochodu);
}
