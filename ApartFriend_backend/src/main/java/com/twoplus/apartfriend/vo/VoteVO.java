package com.twoplus.apartfriend.vo;

import java.util.List;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("voteVo")
public class VoteVO {
	private Integer no;
	@NotEmpty
	private String title;
	private String start_timestamp;
	private String end_timestamp;
	private String ins_timestamp;
	private String upd_timestamp;
	private String del_timestamp;
	private String user_id;
	private List<VoteValueVO> votevalueList;
}
