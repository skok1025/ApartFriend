package com.twoplus.apartfriend.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NaverLoginTokenDTO {
	private String access_token;
	private String refresh_token;

}
