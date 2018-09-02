package com.algalopez.happyday.webapp;

import java.io.Serializable;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.jsf.FacesContextUtils;

import com.algalopez.happyday.core.dto.QuoteDto;
import com.algalopez.happyday.core.service.QuoteService;


@Named("welcomeBean")
@ViewScoped
public class WelcomeBean implements Serializable{

	/** Utilizado por java para detectar rapidamente que las versiones de este objeto sean iguales */
	private static final long serialVersionUID = -2075179750460383596L;
	
	/** Class logger */
	private final static Logger log = LoggerFactory.getLogger(WelcomeBean.class);
	
	@Autowired
	private QuoteService quoteService;
	
	
	private String testString = "test string";
	private QuoteDto testService;
	
	private static ResourceBundle bundle;
	private String environment;


	@PostConstruct
	public void postConstruct() {

		FacesContextUtils.getRequiredWebApplicationContext(FacesContext.getCurrentInstance())
				.getAutowireCapableBeanFactory().autowireBean(this);
		
        try {
        	bundle = ResourceBundle.getBundle("application");
        } catch (MissingResourceException e) {
        	System.out.println("ERROR");
        	return;
        } catch (java.lang.NullPointerException e) {
        	System.out.println("ERROR");
        	return;
        }
		
		
		environment = bundle.getString("webapp.environment");
		log.debug("TESTING LOGGER in {} environment", environment);

		testService = quoteService.getRandomQuote();
		log.debug("TESTING CORE: {}", testService);
		
	}
	
	
	public String getTestString() {
		return testString;
	}


	public void setTestString(String testString) {
		this.testString = testString;
	}
}
