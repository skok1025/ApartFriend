package com.twoplus.apartfriend.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.twoplus.apartfriend.mapper.VoteMapper;
import com.twoplus.apartfriend.vo.VoteVO;
import com.twoplus.apartfriend.vo.VoteValueVO;

@Service
public class VoteService {

	@Autowired
	VoteMapper voteMapper;

	@CacheEvict("voteList") // 캐시 삭제
	public int addVote(@Valid VoteVO voteVo) {
		int result = voteMapper.addVote(voteVo);
		
		int voteNo = voteVo.getNo();
		List<VoteValueVO> voteValueList = voteVo.getVotevalueList();
		
		for (VoteValueVO voteValueVo : voteValueList) {
			voteValueVo.setVote_no(voteNo);
			result *= voteMapper.addVoteValue(voteValueVo);
		}
		return result;
	}

	@Cacheable("voteList") // 캐시
	public List<VoteVO> getVoteList(Long startCol) {
		List<VoteVO> list = voteMapper.getVoteList(startCol);
		return list;
	}
	
	
}
