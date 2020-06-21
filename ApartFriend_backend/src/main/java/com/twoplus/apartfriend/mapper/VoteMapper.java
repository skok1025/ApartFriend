package com.twoplus.apartfriend.mapper;

import java.util.List;

import javax.validation.Valid;

import com.twoplus.apartfriend.vo.VoteVO;
import com.twoplus.apartfriend.vo.VoteValueVO;

public interface VoteMapper {

	int addVote(VoteVO voteVo);

	int addVoteValue(VoteValueVO voteValueVo);

	List<VoteVO> getVoteList(Long startCol);

	int updateVote(@Valid VoteVO voteVo);

	int deleteVote(VoteVO voteVo);

}
