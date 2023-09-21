package com.basic.mapper;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserMapper {

	@Autowired
    protected SqlSessionTemplate sqlSession;
	
	public Map<String, Object> selectUser(Map<String, Object> param) {
		return sqlSession.selectOne("mapper.userMapper.selectUser", param);
	}
	
	public int insertUser(Map<String, Object> param) {
		return sqlSession.insert("mapper.userMapper.insertUser", param);
	}
}
