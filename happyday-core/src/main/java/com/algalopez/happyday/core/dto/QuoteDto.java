package com.algalopez.happyday.core.dto;

import java.io.Serializable;

/**
 * Data Transfer Quote object
 *
 * DTOs are POJOs created by the service layer containing the only info that can travel outside the module
 */
public class QuoteDto implements Serializable {

	/** Used for fast checking serialization version is the same when deserialization */
	private static final long serialVersionUID = -7130808282852845939L;

	/** Quotes identifier */
	private Long id;
	
	/** Quote */
	private String quote;
	
	/** Defalut constructor */
	public QuoteDto() {	}

	/**
	 * Get value of attribute id
	 * @return value of id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Set value to attribute id
	 * @param id value of id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Get value of attribute quote
	 * @return value of quote
	 */
	public String getQuote() {
		return quote;
	}

	/**
	 * Set value to attribute quote
	 * @param quote value of quote
	 */
	public void setQuote(String quote) {
		this.quote = quote;
	}

	@Override
	public String toString() {
		return "QuoteDto [id=" + id + ", quote=" + quote + "]";
	}
	
}
