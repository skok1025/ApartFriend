package com.twoplus.apartfriend.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ManagementExpensesVO {
	private Integer no; 
	private String title;
	private String due_date;
	private Integer before_due_expenses;
	private Integer after_due_expenses;
	private String detail_data;
	private String ins_timestamp;
	private String upd_timestamp;
	private String del_timestamp;
	private String user_id;
}
