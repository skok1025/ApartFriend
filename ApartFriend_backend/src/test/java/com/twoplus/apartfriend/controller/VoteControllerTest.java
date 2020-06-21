package com.twoplus.apartfriend.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

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
import com.twoplus.apartfriend.vo.VoteVO;
import com.twoplus.apartfriend.vo.VoteValueVO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class VoteControllerTest {
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
	 * 투표 등록 테스트
	 * @throws Exception 예외
	 */
	@Test
	public void voteAdd() throws Exception {
		VoteVO vo = new VoteVO();
		vo.setTitle("test title");
		vo.setUser_id("skok1025");
		vo.setStart_timestamp("2020-06-21");
		vo.setEnd_timestamp("2020-06-25");
		
		VoteValueVO valueVo1 = new VoteValueVO();
		valueVo1.setOption("option name");
		valueVo1.setOption_count(0);
		
		List<VoteValueVO> voteValueList = new ArrayList<VoteValueVO>();
		voteValueList.add(valueVo1);
		vo.setVotevalueList(voteValueList);
		
		ResultActions resultActions = 
				mockMvc
				.perform(
						post("/api/vote/").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
				
		resultActions
		.andExpect(status().isCreated())
		.andExpect(jsonPath("$.result", is("success")));
	}
	
	/**
	 * 투표 리스트 조회 테스트
	 * @throws Exception 예외
	 */
	@Test
	public void voteList() throws Exception {
		ResultActions resultActions =
				mockMvc
				.perform(
						get("/api/vote/0").contentType(MediaType.APPLICATION_JSON));
		
		resultActions
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.message", is("투표조회 성공")));
						
	}

}
