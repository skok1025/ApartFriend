package com.twoplus.apartfriend.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface seatMapper {

	public int updateSeat(Map<String, Object> map);
}
