package com.algalopez.happyday.core.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.algalopez.happyday.core.dao.QuoteDao;
import com.algalopez.happyday.core.dto.QuoteDto;
import com.algalopez.happyday.core.model.QuoteEntity;

/**
 * Unit tests for QuoteService class
 * 
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(locations = { 
		"classpath:/conf/applicationContext-happyday_core-test.xml",
		"classpath:/conf/applicationContext-happyday_core_db-test.xml"
})
public class QuoteServiceTest {

	private static final Logger log = LoggerFactory.getLogger(QuoteServiceTest.class);

	
	@InjectMocks
	private QuoteServiceImpl service;
	
	@Mock
	private QuoteDao quoteDao;
	
	private QuoteEntity mockedQuoteEntity;
	
	public QuoteServiceTest() {
		MockitoAnnotations.initMocks(this);
		
		mockedQuoteEntity = new QuoteEntity();
		mockedQuoteEntity.setId(23L);
		mockedQuoteEntity.setQuote("Testing quote");
		
	}
	
	@Test
	public void getQuote_OkTest_Ok() {
		log.debug("getQuote_OkTest_Ok()");
		
		// method parameters
		Long id = 23L;
		
		// Mock the dao method
		when(quoteDao.getQuote(Mockito.any(Long.class))).thenReturn(mockedQuoteEntity);
		
		// Call the service method
		QuoteDto dto = service.getQuote(id);
		
		// Check results
		Assert.assertEquals(id, dto.getId());
		verify(quoteDao, times(1)).getQuote(Mockito.eq(id));
		
		// Log results
		log.debug("getQuote_OkTest_Ok.Dto: {}", dto);
	}
	
	
	@Test
	public void getRandomQuote_OkTest_Ok() {
		log.debug("getRandomQuote_OkTest_Ok()");
		
		// Mock the dao method
		when(quoteDao.getRandomQuote()).thenReturn(mockedQuoteEntity);
		
		// Call the service method
		QuoteDto dto = service.getRandomQuote();
		
		// Check results
		Assert.assertEquals((Long)23L, dto.getId());
		verify(quoteDao, times(1)).getRandomQuote();
		
		// Log results
		log.debug("getQuote_OkTest_Ok.Dto: {}", dto);
	}
}
