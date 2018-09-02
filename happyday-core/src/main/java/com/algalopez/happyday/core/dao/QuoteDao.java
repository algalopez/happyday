package com.algalopez.happyday.core.dao;

import com.algalopez.happyday.core.model.QuoteEntity;

/**
 * Provides access to quotes objects
 *
 */
public interface QuoteDao {
	
	/**
	 * Get quote specified by id
	 * @param id quote identifier
	 * @return {@link QuoteEntity} object
	 */
	public QuoteEntity getQuote(Long id);
	
	/**
	 * Get a random quote
	 * @return {@link QuoteEntity} object
	 */
	public QuoteEntity getRandomQuote();

}
