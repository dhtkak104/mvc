package com.basic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.mapper.BbsMapper;
import com.basic.service.BbsService;

@Service
public class BbsServiceImpl implements BbsService{

	@Autowired
	private BbsMapper bbsMapper;
	
	@Override
	public List<Map<String, Object>> selectBbsList(Map<String, Object> param) {
		List<Map<String, Object>> bbsList = bbsMapper.selectBbsList(param);
		return bbsList;
	}
	
	public Map<String, Object> selectBbs(Map<String, Object> param) {
		Map<String, Object> bbs = bbsMapper.selectBbs(param);
		return bbs;
	}

}
