package com.twoplus.apartfriend.vo;

import java.util.List;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("VoteVO")
public class VoteVO {
	private Integer no;
	@NotEmpty
	@Length(max = 500)
	private String title;
	private String start_timestamp;
	private String end_timestamp;
	private String ins_timestamp;
	private String upd_timestamp;
	private String del_timestamp;
	private String user_id;
	private List<VoteValueVO> votevalueList;
	
	public VoteVO() {}
	
	// construct for builder
	private VoteVO(Integer no, String title, String start_timestamp, 
			String end_timestamp, String ins_timestamp, String upd_timestamp,
			String del_timestamp, String user_id, List<VoteValueVO> votevalueList) {
		this.no = no;
		this.title = title;
		this.start_timestamp = start_timestamp;
		this.end_timestamp = end_timestamp;
		this.ins_timestamp = ins_timestamp;
		this.upd_timestamp = upd_timestamp;
		this.del_timestamp = del_timestamp;
		this.user_id = user_id;
		this.votevalueList = votevalueList;
	}
	
	public static class Builder {
		// required
		private Integer no;
		private String title;
		private String start_timestamp;
		private String end_timestamp;
		private String user_id;
		private List<VoteValueVO> votevalueList;
		
		private String ins_timestamp;
		private String upd_timestamp;
		private String del_timestamp;
		
		public Builder(String title, String start_timestamp, String end_timestamp, 
				String user_id, List<VoteValueVO> votevalueList) {
			this.title = title;
			this.start_timestamp = start_timestamp;
			this.end_timestamp = end_timestamp;
			this.user_id = user_id;
			this.votevalueList = votevalueList;
		}
		
		public Builder setInsTimestamp (String ins_timestamp) {
			this.ins_timestamp = ins_timestamp;
			return this;
		}
		
		public Builder setUpdTimestamp (String upd_timestamp) {
			this.upd_timestamp = upd_timestamp;
			return this;
		}
		
		public Builder setDelTimestamp (String del_timestamp) {
			this.del_timestamp = del_timestamp;
			return this;
		}
		
		public VoteVO build() {
			return new VoteVO(no, title, start_timestamp, 
					end_timestamp, ins_timestamp, upd_timestamp,
					del_timestamp, user_id, votevalueList);
		}
	}
}
