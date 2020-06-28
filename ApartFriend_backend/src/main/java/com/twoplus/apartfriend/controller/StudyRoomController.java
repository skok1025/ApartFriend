package com.twoplus.apartfriend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.twoplus.apartfriend.dto.JSONResult;
import com.twoplus.apartfriend.service.StudyRoomService;
import com.twoplus.apartfriend.vo.SeatVO;
import com.twoplus.apartfriend.vo.StudyRoomVO;
import com.twoplus.apartfriend.vo.UserVO;

import io.swagger.annotations.ApiOperation;


/**
 * @author 박경주
 *	독서실  controller
 *
 */
@Controller
@RequestMapping("/api/studyRoom")
public class StudyRoomController {

	String errMsg = "";

	@Autowired
	StudyRoomService studyRoomService;

	/**
	 *  관리자,회원이 독서실 이용 정보 조회
	 */
	@ApiOperation(value="관리자,회원 독서실 이용정보 조회 API")
	@PostMapping("/getInfoStudyRoom")
	public ResponseEntity<JSONResult> getInfoStudyRoom(HttpSession session, UserVO user) throws Exception {

		try {
			user.setUserId((String) session.getAttribute("userId"));
			user.setRoll((Integer) session.getAttribute("roll")); 

			List<StudyRoomVO> result = studyRoomService.getInfoStudyRoom(user);

			return result != null ? ResponseEntity.status(HttpStatus.CREATED).body(JSONResult.success("이용정보 조회 성공", result))
					: ResponseEntity.status(HttpStatus.OK).body(JSONResult.fail("이용정보 조회 실패"));

		} catch (Exception e) {
			errMsg += "오류발생";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(errMsg));
		}
	}

	/**
	 *  좌석 이용 시작 시(신청 클릭)
	 */
	@ApiOperation(value="독서실 신청 API")
	@PostMapping("/applyStudyRoom")
	public ResponseEntity<JSONResult> applyStudyRoom(HttpSession session,SeatVO seat) throws Exception {

		try {
			UserVO user = (UserVO) session.getAttribute("userId");

			int result = studyRoomService.addStudyRoom(seat, user);
			if(result == 2) {
				return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("하루이용 횟수 초과", result));
			}

			return result == 1 ? ResponseEntity.status(HttpStatus.CREATED).body(JSONResult.success("독서실 등록 성공", result))
					: ResponseEntity.status(HttpStatus.OK).body(JSONResult.fail("독서실 등록 실패"));

		} catch (Exception e) {
			errMsg += "오류발생";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(errMsg));
		}

	}

	/**
	 * 이용시간 만료 시, 취소 시
	 */
	@ApiOperation(value="독서실 이용시간 만료 API")
	@GetMapping("/endStudyRoom")
	public ResponseEntity<JSONResult> endStudyRoom(HttpSession session, StudyRoomVO studyRoom, SeatVO seat) throws Exception {

		try {

			UserVO user = (UserVO) session.getAttribute("userId");
			studyRoom.setUserId(user.getUserId());

			int result = studyRoomService.endReadingRoom(session, studyRoom, seat);

			return result == 1 ? ResponseEntity.status(HttpStatus.CREATED).body(JSONResult.success("독서실 이용시간 만료 성공", result))
					: ResponseEntity.status(HttpStatus.OK).body(JSONResult.fail("독서실 이용시간 만료 실패"));

		} catch (Exception e) {
			errMsg += "오류발생";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(errMsg));
		}
	}
}
