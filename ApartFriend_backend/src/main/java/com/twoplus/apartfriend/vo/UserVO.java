package com.twoplus.apartfriend.vo;

import javax.validation.constraints.Pattern;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("user")
public class UserVO {

	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z0-9]{4,18}$")
	private String userId;
	private String unitNo;
	private String name;
	private String pwd;
	private String gender;
	private String phoneNum;
	private String regDate;
	private String email;
	private String addr;
	private Integer roll;
	private Integer headHouse;
	private String useFlag;
	private String ssn;
	
	
}
