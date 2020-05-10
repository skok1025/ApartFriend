package com.twoplus.apartfriend.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VoteVO {
	private Integer no;
	private String title;
	private String start_timestamp;
	private String end_timestamp;
	private String ins_timestamp;
	private String upd_timestamp;
	private String del_timestamp;
	private String user_id;

}
