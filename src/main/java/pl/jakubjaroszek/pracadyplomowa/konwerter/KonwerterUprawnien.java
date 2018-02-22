package pl.jakubjaroszek.pracadyplomowa.konwerter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pl.jakubjaroszek.pracadyplomowa.model.Uprawnienia;
import pl.jakubjaroszek.pracadyplomowa.serwisy.UprawnieniaSeriws;

@Component
public class KonwerterUprawnien implements Converter<Object, Uprawnienia> {

	static final Logger rejestrator = LoggerFactory.getLogger(KonwerterUprawnien.class);

	@Autowired
	UprawnieniaSeriws uprawnieniaSerwis;

	public Uprawnienia convert(Object element) {
		Integer identyfikator = Integer.parseInt((String) element);
		Uprawnienia uprawnieniaKonta = uprawnieniaSerwis.znajdzPoIdentyfikatorze(identyfikator);
		rejestrator.info("Uprawnienia : {}", uprawnieniaKonta);
		return uprawnieniaKonta;
	}

}
