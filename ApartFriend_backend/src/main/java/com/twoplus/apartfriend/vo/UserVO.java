package com.twoplus.apartfriend.vo;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("user")
public class UserVO {

	private String userId;
	private String unitNo;
	private String name;
	private String pwd;
	private String gender;
	private Integer phoneNum;
	private String regDate;
	private String email;
	private String addr;
	private Integer roll;
	private Integer headHouse;
	private String useFlag;
	private String ssn;
	
	
}
