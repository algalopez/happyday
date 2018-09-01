package com.algalopez.happyday.core.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(locations = { "classpath:/conf/applicationContext-happyday_core-test.xml" })
public class ExampleServiceTest {

	
	//@ContextConfiguration(locations = { "classpath:/conf/applicationContext-happyday_core-test.xml", 
//	"classpath:/conf/applicationContext-happyday_core_db-test.xml"})
	
	
	private static final Logger log = LoggerFactory.getLogger(ExampleServiceTest.class);

	
	@Autowired(required = true)
	private ExampleServiceImpl service;
	
	
	public ExampleServiceTest() {
//		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void exampleTest() {
		log.debug("TEST: {}", service.example());
	}
}
