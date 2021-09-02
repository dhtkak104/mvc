package com.basic.mapper;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BbsMapper {

	@Autowired
    protected SqlSessionTemplate sqlSession;
	
	private static String NAMESPACE = "mapper.bbsMapper.";
	
	public Map<String, Object> selectBbs(Map<String, Object> param) {
		return sqlSession.selectOne(NAMESPACE+"selectBbs", param);
	}
	
}
