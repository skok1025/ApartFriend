package com.twoplus.apartfriend.vo;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("studyRoom")
public class StudyRoomVO {
	
	private String studyRoomNo; //pk
	private int seatNo;		//좌석번호
	private String applyDate;	//신청일
	private int applyStatus; //신청상태 1 신청  2이용시간종료
	private String applyName;  //세션
	private String startTime;	//시작시간
	private String endTime;		//시작시간 기준으로 4시간 이용가능
	private int useCount;	//하루 이용횟수 최대 3
	private String userId;     //세션
	
}
