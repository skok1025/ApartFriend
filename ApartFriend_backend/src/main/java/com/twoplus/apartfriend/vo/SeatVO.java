package com.twoplus.apartfriend.vo;

import lombok.Setter;
import lombok.ToString;

import org.apache.ibatis.type.Alias;

import lombok.Getter;

@Getter
@Setter
@ToString
@Alias("seat")
public class SeatVO {

	private int seatNo;
	private int studyRoomNo;
	private int seatStatus;  //좌석상태 1.사용중 2.사용가능
	
}
