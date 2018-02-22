package pl.jakubjaroszek.pracadyplomowa.konfiguracja;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "pl.jakubjaroszek.pracadyplomowa.konfiguracja" })
@PropertySource(value = { "classpath:polaczenieZbazaDanych.properties" })
public class KonfiguracjaHibernate {

	@Autowired
	private Environment srodowisko;

	@Bean
	public DataSource zrodloDanych() {
		DriverManagerDataSource zrodloDanych = new DriverManagerDataSource();
		zrodloDanych.setDriverClassName(srodowisko.getRequiredProperty("jdbc.driverClassName"));
		zrodloDanych.setUrl(srodowisko.getRequiredProperty("jdbc.url"));
		zrodloDanych.setUsername(srodowisko.getRequiredProperty("jdbc.username"));
		zrodloDanych.setPassword(srodowisko.getRequiredProperty("jdbc.password"));
		return zrodloDanych;
	}

	public Properties wlasciwosciHibernate() {
		Properties wlasciwosciHibernate = new Properties();
		wlasciwosciHibernate.put("hibernate.dialect", srodowisko.getRequiredProperty("hibernate.dialect"));
		wlasciwosciHibernate.put("hibernate.show_sql", srodowisko.getRequiredProperty("hibernate.show_sql"));
		wlasciwosciHibernate.put("hibernate.format_sql", srodowisko.getRequiredProperty("hibernate.format_sql"));
		return wlasciwosciHibernate;
	}
	
	@Bean
	public LocalSessionFactoryBean lokalnaSesja() {
		LocalSessionFactoryBean lokalnaSesja = new LocalSessionFactoryBean();
		lokalnaSesja.setDataSource(zrodloDanych());
		lokalnaSesja.setPackagesToScan(new String[] { "pl.jakubjaroszek.pracadyplomowa.model" });
		lokalnaSesja.setHibernateProperties(wlasciwosciHibernate());
		return lokalnaSesja;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager menadzerTransakcjiHibernate(SessionFactory fabrykaSesji) {
		HibernateTransactionManager menadzerTransakcjiHibernate = new HibernateTransactionManager();
		menadzerTransakcjiHibernate.setSessionFactory(fabrykaSesji);
		return menadzerTransakcjiHibernate;
	}
}
