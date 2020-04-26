package com.twoplus.apartfriend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twoplus.apartfriend.repository.SampleDao;

@Service
public class SampleService {

	@Autowired
	private SampleDao testDao;
	
	public String getTest() {
		return testDao.selectTest();
	}

}
