package pl.jakubjaroszek.pracadyplomowa.walidator;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pl.jakubjaroszek.pracadyplomowa.model.UbezpieczenieSamochodu;
import pl.jakubjaroszek.pracadyplomowa.serwisy.UbezpieczenieSamochoduSerwis;

@Component
public class UbezpieczenieSamochoduWalidator implements Validator {
	
	Date data = new Date();
	LocalDate dataLokalna = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	
	int dzien= dataLokalna.getDayOfMonth();
	int miesiac = dataLokalna.getMonthValue();

	@Override
	public boolean supports(Class<?> clazz) {
		
		return UbezpieczenieSamochodu.class.equals(clazz);
	}
	
	public void validate(Object cel , Errors bledy) {
		
		UbezpieczenieSamochodu ubezpieczenieSamochodu = (UbezpieczenieSamochodu) cel;
	
		
		ValidationUtils.rejectIfEmptyOrWhitespace(bledy, "rokProdukcjiPojazdu", "NotEmpty.ubezpieczenieSamochodu.rokProdukcjiPojazdu");
		ValidationUtils.rejectIfEmptyOrWhitespace(bledy, "model", "NotEmpty.ubezpieczenieSamochodu.model");
		ValidationUtils.rejectIfEmptyOrWhitespace(bledy, "rokWydaniaPrawaJazdy", "NotEmpty.ubezpieczenieSamochodu.rokWydaniaPrawaJazdy");
		ValidationUtils.rejectIfEmptyOrWhitespace(bledy, "dzienWyboruRozpoczeciaUbezpieczenia", "NotEmpty.ubezpieczenieSamochodu.dzienWyboruRozpoczeciaUbezpieczenia");
		ValidationUtils.rejectIfEmptyOrWhitespace(bledy, "miesiacWyboruRozpoczeciaUbezpieczenia", "NotEmpty.ubezpieczenieSamochodu.miesiacWyboruRozpoczeciaUbezpieczenia");
		if(ubezpieczenieSamochodu.getRokProdukcjiPojazdu().equalsIgnoreCase("NONE")){
			bledy.rejectValue("rokProdukcjiPojazdu", "NotEmpty.ubezpieczenieSamochodu.rokProdukcjiPojazdu");
		}
		
		if(ubezpieczenieSamochodu.getMarka().equalsIgnoreCase("NONE")){
			bledy.rejectValue("marka", "NotEmpty.ubezpieczenieSamochodu.marka");
		}
		
		if(ubezpieczenieSamochodu.getRokWydaniaPrawaJazdy().equalsIgnoreCase("NONE")){
			bledy.rejectValue("rokWydaniaPrawaJazdy", "NotEmpty.ubezpieczenieSamochodu.rokWydaniaPrawaJazdy");
		}
		
		if(ubezpieczenieSamochodu.getPojemnoscSilnika().equalsIgnoreCase("NONE")){
			bledy.rejectValue("pojemnoscSilnika", "NotEmpty.ubezpieczenieSamochodu.pojemnoscSilnika");
		}
		
		if(ubezpieczenieSamochodu.getWersjaNadwozia().equalsIgnoreCase("NONE")){
			bledy.rejectValue("wersjaNadwozia", "NotEmpty.ubezpieczenieSamochodu.wersjaNadwozia");
		}
		
		if(ubezpieczenieSamochodu.getSredniRocznyPrzebieg().equalsIgnoreCase("NONE")){
			bledy.rejectValue("sredniRocznyPrzebieg", "NotEmpty.ubezpieczenieSamochodu.sredniRocznyPrzebieg");
		}
			
		
		if(ubezpieczenieSamochodu.getZakresUbezpieczenia().equalsIgnoreCase("NONE")){
			bledy.rejectValue("zakresUbezpieczenia", "NotEmpty.ubezpieczenieSamochodu.zakresUbezpieczenia");
		}
		
		if(ubezpieczenieSamochodu.getKierowcyPonizej26RokuZycia().equalsIgnoreCase("NONE")){
			bledy.rejectValue("kierowcyPonizej26RokuZycia", "NotEmpty.ubezpieczenieSamochodu.kierowcyPonizej26RokuZycia");
		}
			
		if(ubezpieczenieSamochodu.getLiczbaLatJazdyBezszkodowej().equalsIgnoreCase("NONE")){
			bledy.rejectValue("liczbaLatJazdyBezszkodowej", "NotEmpty.ubezpieczenieSamochodu.liczbaLatJazdyBezszkodowej");
		}
		
		if(ubezpieczenieSamochodu.getMiesiacWyboruRozpoczeciaUbezpieczenia() == (0)){
			bledy.rejectValue("miesiacWyboruRozpoczeciaUbezpieczenia", "NotEmpty.ubezpieczenieSamochodu.miesiacWyboruRozpoczeciaUbezpieczenia");
		}
		
		if(ubezpieczenieSamochodu.getMiesiacWyboruRozpoczeciaUbezpieczenia() < miesiac) {
			bledy.rejectValue("miesiacWyboruRozpoczeciaUbezpieczenia", "Wzorzec.ubezpieczenieSamochodu.miesiacWyboruRozpoczeciaUbezpieczenia");
		}
		
		if(ubezpieczenieSamochodu.getDzienWyboruRozpoczeciaUbezpieczenia() == (0)){
			bledy.rejectValue("dzienWyboruRozpoczeciaUbezpieczenia", "NotEmpty.ubezpieczenieSamochodu.dzienWyboruRozpoczeciaUbezpieczenia");
		}
		
		SimpleDateFormat formatDaty = new SimpleDateFormat("MM-dd");
        Date dataZaplikacji = null;
		try {
			dataZaplikacji = formatDaty.parse(ubezpieczenieSamochodu.getMiesiacWyboruRozpoczeciaUbezpieczenia()+"-"+ubezpieczenieSamochodu.getDzienWyboruRozpoczeciaUbezpieczenia());
		} catch (ParseException wyjatek) {
			
			wyjatek.printStackTrace();
		}
        Date dataLokalna = null;
       
		try {
			dataLokalna = formatDaty.parse(miesiac+"-"+dzien);
		} catch (ParseException wyjatek) {
			
			wyjatek.printStackTrace();
		}
		
		if(dataZaplikacji.before(dataLokalna)) {
			bledy.rejectValue("dzienWyboruRozpoczeciaUbezpieczenia", "Wzorzec.ubezpieczenieSamochodu.dzienWyboruRozpoczeciaUbezpieczenia");
		}
		
	}

	

}
