package com.algalopez.happyday.core.dao;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;

import com.algalopez.happyday.core.model.QuoteEntity;

/**
 * Integration tests for QuoteDao class
 * 
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(locations = {
		"classpath:/conf/applicationContext-happyday_core_db-test.xml",
		"classpath:/conf/applicationContext-happyday_core-test.xml"
})
public class QuoteDaoIT {
	
	private final Logger log = LoggerFactory.getLogger(QuoteDaoIT.class);
	
	@Autowired
	private QuoteDBDao dao;
	
	@Before
	public void setUp() {
		log.debug("Setting up test");
	}
	
	
	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:data.sql")
	public void getQuote_OkTest_Ok() {
		log.debug("getQuote_OkTest_Ok()");
		
		// Call method
		QuoteEntity quoteEntity = dao.getQuote(1L);
		
		// Check results
		Assert.assertEquals((Long)1L, quoteEntity.getId());
		
		// Log results
		log.debug("getQuote_OkTest_Ok.Quote: {}", quoteEntity);
	}
	
	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:data.sql")
	public void getRandomQuote_OkTest_Ok() {
		log.debug("getRandomQuote_OkTest_Ok()");
		
		// Call method
		QuoteEntity quoteEntity = dao.getRandomQuote();
		
		// Check results
		if (quoteEntity.getId() > 10L || quoteEntity.getId() < 1L) {
			fail();
		}
		
		// Log results
		log.debug("getRandomQuote_OkTest_Ok.Quote: {}", quoteEntity);
	}
	
}
