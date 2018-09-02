package com.algalopez.happyday.core.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.algalopez.happyday.core.model.QuoteEntity;

/**
 * Database implementation of {@link QuoteDao}
 *
 */
@Repository
public class QuoteDBDao implements QuoteDao{

	private final static Logger log = LoggerFactory.getLogger(QuoteDBDao.class);

	
	@Qualifier(value = "happydayEntityManagerFactory")
	@PersistenceContext(unitName="happydayPU")
	@Autowired
	private EntityManager entityManager;

	
	/**
	 * @inheritDoc
	 */
	@Override
	public QuoteEntity getQuote(Long id) {
		log.debug("getQuote({})", id);
		QuoteEntity entity;
		
		// Execute query. Log and re-throw possible exceptions
		try {
			entity = (QuoteEntity) entityManager.find(QuoteEntity.class, 1L);
		} catch (IllegalArgumentException e) {
			log.error("getQuote.Error: id {} is not a valid argument", id);
			throw e;
		}
		
		// Log result and return
		log.debug("getQuote.QuoteEntity: {}", entity);
		return entity;
	}
	
	
	/**
	 * @inheritDoc
	 */
	@Override
	public QuoteEntity getRandomQuote() {
		log.debug("getRandomQuote()");
		
		QuoteEntity entity;
		
		// Build the sql select query
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT * FROM quotes ORDER BY RAND() LIMIT 1;");
		Query query = entityManager.createNativeQuery(builder.toString(), QuoteEntity.class);
		
		// Execute the query. Log and re-throw exceptions
		try {
			entity = (QuoteEntity) query.getSingleResult();
		} catch (NoResultException e){
			log.error("getRandomQuote.Error: No results where found");
			throw e;
		} catch (NonUniqueResultException e) {
			log.error("getRandomQuote.Error: More than one result was found");
			throw e;
		} catch (Exception e) {
			log.error("getRandomQuote.Error: {}", e.getMessage());
			throw e;
		}
		
		// Log result and return
		log.debug("getRandomQuote.QuoteEntity: {}", entity);
		return entity;
	}
}
