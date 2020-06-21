package com.twoplus.apartfriend.vo;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("voteValueVo")
public class VoteValueVO {
	private Integer no;
	private Integer vote_no;
	private String option;
	private Integer option_count;
}
