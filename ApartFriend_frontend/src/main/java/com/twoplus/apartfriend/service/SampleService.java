package com.twoplus.apartfriend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twoplus.apartfriend.provider.SampleProvider;

@Service
public class SampleService {

	@Autowired
	private SampleProvider provider;
	
	public String getTest() {
		return provider.getTest();
	}

	
}
