package pl.jakubjaroszek.pracadyplomowa.konfiguracja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import pl.jakubjaroszek.pracadyplomowa.konwerter.KonwerterUprawnien;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.jakubjaroszek.pracadyplomowa")
public class KonfiguracjaAplikacji extends WebMvcConfigurerAdapter {

	@Autowired
	KonwerterUprawnien konwerterUprawnien;

	@Override
	public void configureViewResolvers(ViewResolverRegistry rejestr) {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setViewClass(JstlView.class);
		internalResourceViewResolver.setPrefix("/WEB-INF/Widoki/");
		internalResourceViewResolver.setSuffix(".jsp");
		rejestr.viewResolver(internalResourceViewResolver);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry rejestr) {
		rejestr.addResourceHandler("/zrodla/**").addResourceLocations("/zrodla/");
	}

	@Override
	public void addFormatters(FormatterRegistry rejestr) {
		rejestr.addConverter(konwerterUprawnien);
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource komunikat = new ResourceBundleMessageSource();
		komunikat.setBasename("komunikaty");
		return komunikat;
	}

	@Override
	public void configurePathMatch(PathMatchConfigurer matcher) {
		matcher.setUseRegisteredSuffixPatternMatch(true);
	}

}
