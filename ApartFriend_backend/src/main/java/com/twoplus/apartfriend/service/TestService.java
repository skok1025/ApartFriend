package com.twoplus.apartfriend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twoplus.apartfriend.repository.TestDao;

@Service
public class TestService {

	@Autowired
	private TestDao testDao;
	
	public String getTest() {
		return testDao.selectTest();
	}

}
