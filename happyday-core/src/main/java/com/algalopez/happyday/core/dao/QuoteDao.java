package com.algalopez.happyday.core.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.algalopez.happyday.core.model.QuoteEntity;

@Repository
public class QuoteDao {

	private final static Logger log = LoggerFactory.getLogger(QuoteDao.class);

	
	@Qualifier(value = "happydayEntityManagerFactory")
	@PersistenceContext(unitName="happydayPU")
	@Autowired
	private EntityManager entityManager;
	
	
	public QuoteEntity getRandomQuote() {
		log.debug("getRandomQuote()");
		

		QuoteEntity entity = (QuoteEntity) entityManager.find(QuoteEntity.class, 1L);
		
		log.debug("getRandomQuote.Entity: {}", entity);
		
		return entity;
	}
}
