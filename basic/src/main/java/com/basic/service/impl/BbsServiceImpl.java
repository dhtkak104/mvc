package com.basic.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.mapper.BbsMapper;
import com.basic.service.BbsService;
import com.basic.util.PagingUtil;

@Service
public class BbsServiceImpl implements BbsService{

	@Autowired
	private BbsMapper bbsMapper;
	
	@Override
	public Map<String, Object> selectBbsList(Map<String, Object> param) {
		Map<String, Object> result = new HashMap<>();
		int currentPage = 1;
		if (param.containsKey("currentPage")) {
			currentPage = Integer.parseInt(param.get("currentPage").toString());
		}
			
//		Oracle
//		int start = PagingUtil.selectStartRowrum(currentPage);
//		int end = PagingUtil.selectEndRowrum(currentPage);
		
		param.put("offset", PagingUtil.selectOffset(currentPage));
		List<Map<String, Object>> bbsList = bbsMapper.selectBbsList(param);
		long bbsListCnt = bbsMapper.selectBbsListCnt(param);
		int startPage = PagingUtil.selectStartPage(currentPage);
		int endPage = PagingUtil.selectEndPage(startPage);
		int pageTotalCnt = PagingUtil.selectPageTotalCnt(bbsListCnt);
		
		result.put("bbsList", bbsList);
		result.put("currentPage", currentPage);
		result.put("startPage", startPage);
		result.put("endPage", endPage);
		result.put("pageTotalCnt", pageTotalCnt);
		result.put("keyword", param.get("keyword"));
		return result;
	}
	
	@Override
	public Map<String, Object> selectBbs(Map<String, Object> param) {
		int cnt = bbsMapper.updateBbsView(param);
		Map<String, Object> bbs = bbsMapper.selectBbs(param);
		return bbs;
	}

	@Override
	public boolean insertBbs(Map<String, Object> param) {
		int cnt = bbsMapper.insertBbs(param);
		if(cnt > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateBbs(Map<String, Object> param) {
		int cnt = bbsMapper.updateBbs(param);
		if(cnt > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteBbs(Map<String, Object> param) {
		int cnt = bbsMapper.deleteBbs(param);
		if(cnt > 0) {
			return true;
		}
		return false;
	}

}
