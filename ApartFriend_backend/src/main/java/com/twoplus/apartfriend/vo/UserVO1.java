package com.twoplus.apartfriend.vo;

import java.security.Timestamp;

import javax.validation.Valid;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserVO1 {
	@Valid
	private String unitNo;
	
	private String name;
	private String pwd;
	private String gender;
	private int phonNum;
	//private  regDate; //timestamp
	private String email;
	private String addr;
	private int roll;
	private int headHouse;
	private String use;
	private String ssn;
	
	
}
