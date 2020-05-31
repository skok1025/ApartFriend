package com.twoplus.apartfriend.vo;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Alias("voteValueVo")
public class VoteValueVO {
	private Integer no;
	private Integer vote_no;
	private String option;
	private Integer option_count;
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public Integer getVote_no() {
		return vote_no;
	}
	public void setVote_no(Integer vote_no) {
		this.vote_no = vote_no;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public Integer getOption_count() {
		return option_count;
	}
	public void setOption_count(Integer option_count) {
		this.option_count = option_count;
	}
	public VoteValueVO(Integer no, Integer vote_no, String option, Integer option_count) {
		super();
		this.no = no;
		this.vote_no = vote_no;
		this.option = option;
		this.option_count = option_count;
	}
	
	
	
}
