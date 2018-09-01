package com.algalopez.happyday.core.service;

import org.springframework.stereotype.Service;

@Service
public class ExampleServiceImpl implements ExampleService {

	@Override
	public String example() {
		return "Example phrase";
	}

}
