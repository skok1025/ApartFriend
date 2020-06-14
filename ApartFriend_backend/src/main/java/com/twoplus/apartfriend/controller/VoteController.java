package com.twoplus.apartfriend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.twoplus.apartfriend.dto.JSONResult;
import com.twoplus.apartfriend.service.SampleService;
import com.twoplus.apartfriend.service.VoteService;
import com.twoplus.apartfriend.vo.TestVo;
import com.twoplus.apartfriend.vo.VoteVO;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/vote")
public class VoteController {
	@Autowired
	private VoteService voteService;
	
	@Autowired
	private CacheManager cacheManager;
	
	@ApiOperation(value = "투표등록 API")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "voteVo", value = "투표등록을 위한 vo", required = true, dataType = "VoteVo", defaultValue = "") 
	})
	@PostMapping("/")
	public ResponseEntity<JSONResult> addVote(@Valid VoteVO voteVo, BindingResult bindresult) {
		int result = voteService.addVote(voteVo);
		
		// 유효성 검사 실패시
		if (bindresult.hasErrors()) {
			List<FieldError> list = bindresult.getFieldErrors();
			String errMsg = "";
			for (FieldError err : list) {
				errMsg += err.getField() +"-"+err.getDefaultMessage()+"/";
			}
			errMsg += "오류발생";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(errMsg));
		}
		
		return result == 1 ? ResponseEntity.status(HttpStatus.CREATED).body(JSONResult.success("투표등록 성공", result))
				: ResponseEntity.status(HttpStatus.OK).body(JSONResult.fail("투표등록 실패"));
	}
	

	@ApiOperation(value = "투표조회 API")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "startCol", value = "시작 인덱스", required = true, dataType = "Long", defaultValue = "") })
	@GetMapping("/{startCol}")
	public ResponseEntity<JSONResult> voteList(@PathVariable(value="startCol") Long startCol) {
		List<VoteVO> list = voteService.getVoteList(startCol);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("투표조회 성공", list));
	}
}
