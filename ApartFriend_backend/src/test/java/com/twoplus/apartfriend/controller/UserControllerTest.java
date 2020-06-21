package com.twoplus.apartfriend.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.twoplus.apartfriend.vo.UserVO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class UserControllerTest {
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


	//@Test
	public void voteList() throws Exception {
		ResultActions resultActions =
				mockMvc
				.perform(
						get("/userList").contentType(MediaType.APPLICATION_JSON));

		resultActions
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.message", is("유저리스트정보조회 성공")));

	}

	//@Test
	public void addUser() throws Exception {
		UserVO userVO =new UserVO();

		userVO.setUserId("test14");
		userVO.setUnitNo("test12");
		userVO.setName("test12");
		userVO.setPwd("test12");
		userVO.setPhoneNum(123);
		userVO.setCEmail("test12");
		userVO.setCAddr("test12");
		userVO.setRoll(1);
		userVO.setHeadHouse(1);
		userVO.setUseFlag("12");
		userVO.setSsn("1232");

		ResultActions resultActions =
				mockMvc
				.perform(
						post("/addUser").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVO)));

		resultActions
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.message", is("회원가입 성공")));
	}

	//@Test
	public void updateUser() throws Exception {

		UserVO userVO = new UserVO();

		userVO.setUserId("test14 update2");
		userVO.setUnitNo("test12");
		userVO.setName("test12");
		userVO.setPwd("test12");
		userVO.setPhoneNum(123);
		userVO.setCEmail("test12");
		userVO.setCAddr("test12");
		userVO.setRoll(1);
		userVO.setHeadHouse(1);
		userVO.setUseFlag("12");
		userVO.setSsn("1232");

		ResultActions resultActions =
				mockMvc
				.perform(
						post("/updateUser").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVO)));

		resultActions
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.message", is("회원수정 성공")));

	}

	@Test
	public void deleteUser() throws Exception {

		UserVO userVO = new UserVO();

		userVO.setUserId("test14 update2");

		ResultActions resultActions =
				mockMvc
				.perform(
						post("/updateUser").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVO)));

		resultActions
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.message", is("회원수정 성공")));

	}


}
