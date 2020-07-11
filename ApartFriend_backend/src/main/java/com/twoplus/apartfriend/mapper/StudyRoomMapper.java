package com.twoplus.apartfriend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.twoplus.apartfriend.dto.UserStudyRoomSeat;
import com.twoplus.apartfriend.vo.StudyRoomVO;
import com.twoplus.apartfriend.vo.UserVO;

@Mapper
public interface StudyRoomMapper {

	public StudyRoomVO registryCheck(UserStudyRoomSeat userStudyRoomSeat);
	
	public int insertStudyRoom(StudyRoomVO studyRoom);
	
	public int updateStudyRoom(UserStudyRoomSeat userStudyRoomSeat);
	
	public List<StudyRoomVO> getInfoStudyRoom(UserVO user);
}
