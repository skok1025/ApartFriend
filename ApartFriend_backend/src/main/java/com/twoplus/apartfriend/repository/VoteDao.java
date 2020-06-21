package com.twoplus.apartfriend.repository;

import java.util.List;

import javax.validation.Valid;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.twoplus.apartfriend.vo.VoteVO;
import com.twoplus.apartfriend.vo.VoteValueVO;

@Repository
public class VoteDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<VoteVO> getVoteList(Long startCol) {
		return sqlSession.selectList("vote.getVoteList", startCol);
	}

	public int addVote(VoteVO voteVo) {
		return sqlSession.insert("vote.addVote", voteVo);
	}

	public int addVoteValue(VoteValueVO voteValueVo) {
		return sqlSession.insert("vote.addVoteValue",voteValueVo);
	}

}
