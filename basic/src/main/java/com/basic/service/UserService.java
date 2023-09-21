package com.basic.service;

import java.util.Map;

public interface UserService {

	public Map<String, Object> loginUser(Map<String, Object> param);
	
	public boolean joinUser(Map<String, Object> param);
}
