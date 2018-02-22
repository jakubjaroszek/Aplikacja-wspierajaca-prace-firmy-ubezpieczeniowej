package pl.jakubjaroszek.pracadyplomowa.konfiguracja;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class UruchamianieAplikacji extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class [] {KonfiguracjaAplikacji.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	@Override
	protected Filter[] getServletFilters() {
	    Filter[] filters;

	    CharacterEncodingFilter encFilter;
	    HiddenHttpMethodFilter httpMethodFilter = new HiddenHttpMethodFilter();

	    encFilter = new CharacterEncodingFilter();

	    encFilter.setEncoding("UTF-8");
	    encFilter.setForceEncoding(true);

	    filters = new Filter[] {httpMethodFilter, encFilter};
	    return filters;
	}

}
