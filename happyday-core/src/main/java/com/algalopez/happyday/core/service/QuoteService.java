package com.algalopez.happyday.core.service;

import com.algalopez.happyday.core.dto.QuoteDto;

/**
 * Quotes service 
 * 
 * Service layer provides the entry point for this module.
 * Implements all the necessary logic
 * Connects with necessary datasources
 */
public interface QuoteService {

	
	/**
	 * Get quote specified by id
	 * @param id quote identifier
	 * @return {@link QuoteDto} object
	 */
	public QuoteDto getQuote(Long id);
	
	
	/**
	 * Get a random quote
	 * @return {@link QuoteDto} object
	 */
	public QuoteDto getRandomQuote();
}
