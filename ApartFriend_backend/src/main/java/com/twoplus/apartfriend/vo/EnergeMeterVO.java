package com.twoplus.apartfriend.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EnergeMeterVO {
	private Integer no;
	private String meter_data;
	private String date;
	private String ins_timestamp;
	private String upd_timestamp;
	private String del_timestamp;
	private String user_id;
}
