package com.twoplus.apartfriend.vo;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("board")
public class BoardVO {
	
	private int boardNo;
	private String title;
	private String content;
	private String regDate;
	private String modifyDate;
	private String delDate;
	private String delFlag;
	private String userId;
	
}
