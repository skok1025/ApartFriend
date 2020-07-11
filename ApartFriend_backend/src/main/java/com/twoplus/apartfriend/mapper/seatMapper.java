package com.twoplus.apartfriend.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.twoplus.apartfriend.dto.UserStudyRoomSeat;

@Mapper
public interface seatMapper {

	public int updateSeat(UserStudyRoomSeat userStudyRoomSeat);
}
