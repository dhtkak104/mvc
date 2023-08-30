package com.basic.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BbsMapper {

	@Autowired
    protected SqlSessionTemplate sqlSession;
	/* SqlSessionTemplate 
	 * C(CREATE) : sqlSession.insert(쿼리경로, 파리미터);
	 * R(READ)	 : sqlSession.selectOne(쿼리경로, 파리미터); / sqlSession.selectList(쿼리경로, 파리미터); 
	 * U(UPDATE) : sqlSession.update(쿼리경로, 파리미터);
	 * D(DELETE) : sqlSession.delete(쿼리경로, 파리미터);
	 */ 
	
	public List<Map<String, Object>> selectBbsList(Map<String, Object> param) {
		return sqlSession.selectList("mapper.bbsMapper.selectBbsList", param);
	}

	public Map<String, Object> selectBbs(Map<String, Object> param) {
		return sqlSession.selectOne("mapper.bbsMapper.selectBbs", param);
	}
	
	public int updateBbsView(Map<String, Object> param) {
		return sqlSession.update("mapper.bbsMapper.updateBbsView", param);
	}
	
	public int insertBbs(Map<String, Object> param) {
		return sqlSession.insert("mapper.bbsMapper.insertBbs", param);
	}
	
	public int updateBbs(Map<String, Object> param) {
		return sqlSession.update("mapper.bbsMapper.updateBbs", param);
	}
	
	public int deleteBbs(Map<String, Object> param) {
		return sqlSession.delete("mapper.bbsMapper.deleteBbs", param);
	}
}
