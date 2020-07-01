package com.twoplus.apartfriend.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString	
public class NaverProfileDTO {
	private String resultcode;
	private String message;
	private String email;
	private String nickname;
	private String profile_image;
	private String age;
	private String gender;
	private String id;
	private String name;
	private String birthday;

}
