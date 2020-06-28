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

import com.twoplus.apartfriend.dto.JSONResult;
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

	public int result;
	public String errMsg;

	//이용가능 check
	public StudyRoomVO registryCheck(UserVO user) throws Exception {
		return studyRoomMapper.registryCheck(user);
	}

	//독서실이용 기록 등록
	public int insertStudyRoom(StudyRoomVO studyRoom) throws Exception {
		return studyRoomMapper.insertStudyRoom(studyRoom);
	}

	//독서살 변경
	public int updateStudyRoom(StudyRoomVO studyRoom) throws Exception {
		return studyRoomMapper.updateStudyRoom(studyRoom);
	}

	//좌석 상태변경
	public int updateSeat(Map<String, Object> map) throws Exception {
		return seatMapper.updateSeat(map);
	}

	//관리자 or 이용자 기록정보 조회
	public List<StudyRoomVO> getInfoStudyRoom(UserVO user) throws Exception {

		List<StudyRoomVO> result = studyRoomMapper.getInfoStudyRoom(user);

		return result;
	}

	//독서실 신청 ( 메세지 큐 , 디스패쳐 , 메세지 브로커 , 스프링스케쥴러 , cron  공부해서 적용시켜야함.)
	public ResponseEntity<JSONResult> addStudyRoom(SeatVO seat, UserVO user) throws Exception {

		StudyRoomVO studyRoom = null;

		try {
			//이용가능한지 check
			studyRoom = registryCheck(user);

			//오늘 일 수랑 db일 수 비교
			SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-mm-dd");
			int dbDay = dataFormat.parse(studyRoom.getApplyDate()).getDate();	
			int curDay = new Date().getDay();

			if(studyRoom.getUseCount() >= 3 && dbDay == curDay ) {
				return ResponseEntity.status(HttpStatus.OK).body(JSONResult.fail("하루 이용 횟수 초과"));
			}

			//등록과 함께 좌석상태를 바꾸기 위한 신청상태코드를 가져옴
			studyRoom.setApplyStatus(1);
			int applyStatus = insertStudyRoom(studyRoom); 
			studyRoom.setApplyStatus(applyStatus);

			//등록되면 좌석상태 변경
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("studyRoom", studyRoom);
			map.put("seat", seat); //pk를 화면단에서부터 받아야함. 

			result = updateSeat(map);

			if(result == 0) {
				return ResponseEntity.status(HttpStatus.OK).body(JSONResult.fail("독서실 등록 실패"));
			}

			return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("독서실 등록 성공", result));

		} catch (Exception e) {//통신실패
			errMsg += "오류발생";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(errMsg));
		}
	}

	//이용시간 만료되거나 이용취소 시 
	public ResponseEntity<JSONResult> endReadingRoom(HttpSession session, StudyRoomVO studyRoom, SeatVO seat) throws Exception {

		try {
			UserVO user = (UserVO) session.getAttribute("userId");
			studyRoom.setUserId(user.getUserId());

			result = updateStudyRoom(studyRoom);

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("studyRoom", studyRoom); //pk를 화면단에서부터 받아야함.
			map.put("seat", seat); //pk를 화면단에서부터 받아야함. 

			result = updateSeat(map);

			if(result == 0) {
				return ResponseEntity.status(HttpStatus.OK).body(JSONResult.fail("독서실 이용 취소 실패"));
			}

			return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("독서실 이용 취소 성공", result));

		} catch (Exception e) {
			errMsg += "오류발생";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(errMsg));
		}
	}
}
