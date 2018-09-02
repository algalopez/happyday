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

	/** Used for fast checking serialization version is the same when deserialization */
	private static final long serialVersionUID = -2075179750460383596L;
	
	/** Class logger */
	private final static Logger log = LoggerFactory.getLogger(WelcomeBean.class);
	
	@Autowired
	private QuoteService quoteService;
	
	
	// -----------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------
	// STATE
	// -----------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------
	
	
	// Quote Class
	private QuoteDto quoteDto;
	
	// App
	private String name;
	private String author;
	private String environment;
	private String sourcecode;
	private String version;

	
	// -----------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------
	// INITIALIZATION
	// -----------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------
	
	
	@PostConstruct
	public void postConstruct() {

		FacesContextUtils.getRequiredWebApplicationContext(FacesContext.getCurrentInstance())
				.getAutowireCapableBeanFactory().autowireBean(this);
		
        try {
        	ResourceBundle bundle = ResourceBundle.getBundle("application");
        	name = bundle.getString("webapp.name");
        	author = bundle.getString("webapp.author");
        	environment = bundle.getString("webapp.environment");
        	sourcecode = bundle.getString("webapp.sourcecode");
        	version = bundle.getString("webapp.version");

        } catch (MissingResourceException e) {
        	log.error("postConstruct.Error: Missing properties file");
        } catch (java.lang.NullPointerException e) {
        	log.error("postConstruct.Error: Error opening properties file");
        }
		
        quoteDto = quoteService.getRandomQuote();
        
		log.debug("Debugging {} v{} in {} environment", name, version, environment);		
	}

	
	
	// -----------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------
	// FUNCTIONS
	// -----------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------
	
	public String buildAppInfo() {
		// HappyDay v1.0.0 (dev) by algalopez
		StringBuilder builder = new StringBuilder();
		builder.append(name).append(" v").append(version);
		builder.append(" (").append(environment).append(") by ").append(author);
		
		return builder.toString();
	}
	
	
	
	// -----------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------
	// GETTERS AND SETTERS
	// -----------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------
	
	
	public QuoteDto getQuoteDto() { return quoteDto; }
	public void setQuoteDto(QuoteDto quoteDto) { this.quoteDto = quoteDto; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getAuthor() { return author; }
	public void setAuthor(String author) { this.author = author; }

	public String getEnvironment() { return environment; }
	public void setEnvironment(String environment) { this.environment = environment; }

	public String getSourcecode() { return sourcecode; }
	public void setSourcecode(String sourcecode) { this.sourcecode = sourcecode; }

	public String getVersion() { return version; }
	public void setVersion(String version) { this.version = version; }

	public QuoteService getQuoteService() { return quoteService; }
	public void setQuoteService(QuoteService quoteService) { this.quoteService = quoteService; }

}
