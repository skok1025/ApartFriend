package com.twoplus.apartfriend.vo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TestVo {

	@Pattern(regexp = "^[0-9]*$",message = "숫자만 입력")
	private Integer testFieldName;
	
	@NotEmpty
	@Length(max = 20)
	private String testString;
	

}
