package com.algalopez.happyday.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algalopez.happyday.core.dao.QuoteDao;
import com.algalopez.happyday.core.dto.QuoteDto;
import com.algalopez.happyday.core.model.QuoteEntity;


/**
 * Implementation of {@link QuoteService}
 *
 */
@Service
public class QuoteServiceImpl implements QuoteService {

	private final static Logger log = LoggerFactory.getLogger(QuoteServiceImpl.class);

	@Autowired
	private QuoteDao quoteDao;
	
	/**
	 * @inheritDoc
	 */
	@Override
	public QuoteDto getQuote(Long id) {
		log.debug("getQuote({})", id);
		
		// Get data from datasource
		QuoteEntity entity = quoteDao.getQuote(id);
		
		// Apply logic
		
		// Map data to Dto
		QuoteDto dto = new QuoteDto();
		dto.setId(entity.getId());
		dto.setQuote(entity.getQuote());
		
		// Log and return result
		log.debug("getQuote.Dto: {}", dto);
		return dto;
	}

	
	/**
	 * @inheritDoc
	 */
	@Override
	public QuoteDto getRandomQuote() {
		log.debug("getRandomQuote()");
		
		// Get data from datasource
		QuoteEntity entity = quoteDao.getRandomQuote();
		
		// Apply logic
		
		// Map data to Dto
		QuoteDto dto = new QuoteDto();
		dto.setId(entity.getId());
		dto.setQuote(entity.getQuote());
		
		// Log and return result
		log.debug("getRandomQuote.Dto: {}", dto);
		return dto;
	}

}
