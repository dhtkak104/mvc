package com.basic.service;

import java.util.List;
import java.util.Map;

public interface BbsService {

	public List<Map<String, Object>> selectBbsList(Map<String, Object> param);
	
	public Map<String, Object> selectBbs(Map<String, Object> param);
}
