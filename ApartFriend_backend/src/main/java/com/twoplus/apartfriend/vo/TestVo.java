package com.twoplus.apartfriend.vo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class TestVo {

	@Pattern(regexp = "^[0-9]*$",message = "숫자만 입력")
	private Integer testFieldName;
	
	@NotEmpty
	@Length(max = 20)
	private String testString;
	
	

	public String getTestString() {
		return testString;
	}

	public void setTestString(String testString) {
		this.testString = testString;
	}

	public Integer getTestFieldName() {
		return testFieldName;
	}

	public void setTestFieldName(Integer testFieldName) {
		this.testFieldName = testFieldName;
	}

	@Override
	public String toString() {
		return "TestVo [testFieldName=" + testFieldName + ", testString=" + testString + "]";
	}

	

}
