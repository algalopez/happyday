package com.algalopez.happyday.core.dao;

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

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(locations = {
		"classpath:/conf/applicationContext-happyday_core_db-test.xml",
		"classpath:/conf/applicationContext-happyday_core-test.xml"
})
public class QuoteDaoIT {
	
	private final Logger log = LoggerFactory.getLogger(QuoteDaoIT.class);
	
	@Autowired
	private QuoteDao dao;
	
	@Before
	public void setUp() {
		log.debug("Setting up test");
	}
	
	
	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:data.sql")
	public void getRandomQuoteTest_1() {
		log.debug("getRandomQuoteTest_1()");
		
		log.debug("getRandomQuoteTest_1.Quote: {}", dao.getRandomQuote());
	}
	
}
