package com.twoplus.apartfriend.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.twoplus.apartfriend.vo.SeatVO;
import com.twoplus.apartfriend.vo.StudyRoomVO;
import com.twoplus.apartfriend.vo.UserVO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class StudyRoomControllerTest {
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

	}

	@After
	@Rollback(true)
	public void cleanup() {
	}

	/**
	 * 회원 독서실 이용 정보 조회
	 */
	//@Test
	public void getInfoStudyRoom1() throws Exception {

		UserVO user = new UserVO();
		user.setUserId("test14");
		user.setRoll(0); //일반회원

		ResultActions resultActions =
				mockMvc.perform(
						post("/api/studyRoom/getInfoStudyRoom").content(new Gson().toJson(user)));

		resultActions
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$message", is("이용정보 조회 성공")));

	}

	/**
	 * 관리자 독서실 이용 정보 조회
	 */
	//@Test
	public void getInfoStudyRoom2() throws Exception {

		UserVO user = new UserVO();
		user.setUserId("test13");
		user.setRoll(1); //관리자

		ResultActions resultActions =
				mockMvc.perform(
						post("/api/studyRoom/getInfoStudyRoom").content(new Gson().toJson(user)));

		resultActions
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$message", is("이용정보 조회 성공")));

	}

	/**
	 * 좌석 이용 (등록)
	 * @throws Exception 객체 2개를 넘겨야 하는데 / 컨트롤러에서는 map으로 넘겨받는것이 아닌데
	 */
	//@Test 
	public void applyStudyRoom() throws Exception {

		UserVO user = new UserVO();
		user.setUserId("test13");

		SeatVO seat = new SeatVO();
		seat.setSeatNo(1);

		ResultActions resultActions =
				mockMvc.perform(
						post("/api/studyRoom/applyStudyRoom").content(new Gson().toJson(user)));

		resultActions
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$message", is("독서실 등록 성공")));

	}

	/**
	 * 자동만료 구현못해서 취소 클릭 시 이용시간 끝으로 일단 테스트
	 * @throws Exception
	 */
	//@Test
	public void endStudyRoom() throws Exception {

		UserVO user = new UserVO();
		user.setUserId("test13");

		StudyRoomVO studyRoom = new StudyRoomVO();
		studyRoom.setStudyRoomNo("1");

		SeatVO seat = new SeatVO();
		seat.setSeatNo(1);

		ResultActions resultActions =
				mockMvc.perform(
						post("/api/studyRoom/endStudyRoom").content(new Gson().toJson(user)));

		resultActions
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$message", is("독서실 이용 취소 성공")));

	}

}
