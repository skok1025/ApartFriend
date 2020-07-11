package com.twoplus.apartfriend.dto;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.ToString;
import lombok.Setter;

@Getter
@Setter
@ToString
@Alias("userStudyRoomSeat")
public class UserStudyRoomSeat {
	
	private String userId;
	private int seatNo;
	private int studyRoomNo;
	private int applyStatus;
	private String applyName;
	private int useCount;

}
