package com.twoplus.apartfriend.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import com.twoplus.apartfriend.dto.JSONResult;

@Repository
public class SampleProvider {

	// @org.springframework.beans.factory.annotation.Autowired(required=true)
	// private RestTemplate restTemplate;

	@Autowired
	RestTemplateBuilder restTemplateBuilder;

	public String getTest() {

		RestTemplate restTemplate = restTemplateBuilder.build();

		JSONResultString jsonresult = restTemplate.getForObject("http://localhost:8080/api/test/test",
				JSONResultString.class);
		return jsonresult.getData();
	}

	private static class JSONResultString extends JSONResult<String> {
	}

}
