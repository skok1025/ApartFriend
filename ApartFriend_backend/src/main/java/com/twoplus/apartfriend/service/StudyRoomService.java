package com.twoplus.apartfriend.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.twoplus.apartfriend.dto.JSONResult;
import com.twoplus.apartfriend.dto.UserStudyRoomSeat;
import com.twoplus.apartfriend.mapper.StudyRoomMapper;
import com.twoplus.apartfriend.mapper.seatMapper;
import com.twoplus.apartfriend.vo.SeatVO;
import com.twoplus.apartfriend.vo.StudyRoomVO;
import com.twoplus.apartfriend.vo.UserVO;

@Service
public class StudyRoomService {

	@Autowired
	StudyRoomMapper studyRoomMapper;

	@Autowired
	seatMapper seatMapper;

	public String errMsg;

	//이용가능 check
	public StudyRoomVO registryCheck(UserStudyRoomSeat userStudyRoomSeat) throws Exception {
		return studyRoomMapper.registryCheck(userStudyRoomSeat);
	}

	//독서실이용 기록 등록
	public int insertStudyRoom(StudyRoomVO studyRoom) throws Exception {
		return studyRoomMapper.insertStudyRoom(studyRoom);
	}

	//독서살 변경
	public int updateStudyRoom(UserStudyRoomSeat userStudyRoomSeat) throws Exception {
		return studyRoomMapper.updateStudyRoom(userStudyRoomSeat);
	}

	//좌석 상태변경
	public int updateSeat(UserStudyRoomSeat userStudyRoomSeat) throws Exception {
		return seatMapper.updateSeat(userStudyRoomSeat);
	}

	//관리자 or 이용자 기록정보 조회
	public List<StudyRoomVO> getInfoStudyRoom(UserVO userVO) throws Exception {

		List<StudyRoomVO> result = studyRoomMapper.getInfoStudyRoom(userVO);

		return result;
	}

	public int addStudyRoom(UserStudyRoomSeat userStudyRoomSeat, HttpSession session) throws Exception {
		// 2 == 하루이용횟수 초과
		int result = 2;
		//이용가능한지 check
		StudyRoomVO studyRoom = registryCheck(userStudyRoomSeat);
		System.out.println("studyRoom check :: " + studyRoom);
		
		if(studyRoom != null) {
			System.out.println("여기 안올것임");
			//오늘 일 수랑 db일 수 비교
			SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-mm-dd");
			int dbDay = dataFormat.parse(studyRoom.getApplyDate()).getDate();	
			int curDay = new Date().getDay();

			if(studyRoom.getUseCount() >= 3 && dbDay == curDay ) {
				return result;
			}
		} else {		// 첫 등록일때는 당연히 null이 찍힘.
			System.out.println("null이니까 올것임");
			studyRoom = new StudyRoomVO();
//			studyRoom.setUserId((String )session.getAttribute("userId"));
			studyRoom.setUserId("신청id 경주");
//			studyRoom.setApplyName(session.getAttribute("name"));
			studyRoom.setApplyName("신청id 박"); //세션
			studyRoom.setUseCount(0);
			studyRoom.setSeatNo(5); //화면단에서 좌석번호를 받아야함. 테스트 통과시 코드 삭제.
			
		}
		//등록과 함께 좌석상태를 바꾸기 위한 신청상태코드를 가져옴 

		studyRoom.setApplyStatus(1);
		System.out.println("studyRoom check :: " + studyRoom );
		int applyStatus = insertStudyRoom(studyRoom); 
		System.out.println("appltStatus check :: 여기가 안찍힘" + applyStatus);
		
		studyRoom.setApplyStatus(applyStatus);

		System.out.println("studyRoom check :: " + studyRoom);

		return result = updateSeat(userStudyRoomSeat);
	}

	//이용시간 만료되거나 이용취소 시 
	public int endReadingRoom(HttpSession session, UserStudyRoomSeat userStudyRoomSeat) throws Exception {

		int result = updateStudyRoom(userStudyRoomSeat);

		if(result == 0) {
			return result;
		}
		
	//user, studyRoom pk필요
		
		return	result = updateSeat(userStudyRoomSeat);

	}
}
