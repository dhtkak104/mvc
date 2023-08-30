package com.basic.service;

import java.util.List;
import java.util.Map;

public interface BbsService {

	public List<Map<String, Object>> selectBbsList(Map<String, Object> param);
	
	public Map<String, Object> selectBbs(Map<String, Object> param);
	
	public boolean insertBbs(Map<String, Object> param);
	
	public boolean updateBbs(Map<String, Object> param);
	
	public boolean deleteBbs(Map<String, Object> param);
}
