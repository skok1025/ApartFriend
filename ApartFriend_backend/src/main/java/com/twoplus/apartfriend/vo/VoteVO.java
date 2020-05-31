package com.twoplus.apartfriend.vo;

import java.util.List;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.NotEmpty;

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
	
	
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStart_timestamp() {
		return start_timestamp;
	}
	public void setStart_timestamp(String start_timestamp) {
		this.start_timestamp = start_timestamp;
	}
	public String getEnd_timestamp() {
		return end_timestamp;
	}
	public void setEnd_timestamp(String end_timestamp) {
		this.end_timestamp = end_timestamp;
	}
	public String getIns_timestamp() {
		return ins_timestamp;
	}
	public void setIns_timestamp(String ins_timestamp) {
		this.ins_timestamp = ins_timestamp;
	}
	public String getUpd_timestamp() {
		return upd_timestamp;
	}
	public void setUpd_timestamp(String upd_timestamp) {
		this.upd_timestamp = upd_timestamp;
	}
	public String getDel_timestamp() {
		return del_timestamp;
	}
	public void setDel_timestamp(String del_timestamp) {
		this.del_timestamp = del_timestamp;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public List<VoteValueVO> getVotevalueList() {
		return votevalueList;
	}
	public void setVotevalueList(List<VoteValueVO> votevalueList) {
		this.votevalueList = votevalueList;
	}
	
	

}
