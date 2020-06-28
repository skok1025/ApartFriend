package com.twoplus.apartfriend.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerProvider {
	

	@Autowired
	RestTemplateBuilder restTemplateBuilder;

}
