package com.twoplus.apartfriend.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDao {

	@Autowired
	private SqlSession sqlSession;
	
	public String selectTest() {
		return sqlSession.selectOne("test.selectTest");
	}

}
