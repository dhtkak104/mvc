package com.basic.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.mapper.UserMapper;
import com.basic.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public Map<String, Object> loginUser(Map<String, Object> param) {
		Map<String, Object> user = userMapper.selectUser(param);
		return user;
	}
	
	@Override
	public boolean joinUser(Map<String, Object> param) {
		Map<String, Object> inParam = new HashMap<>();
		inParam.put("email", param.get("email"));
		Map<String, Object> user = userMapper.selectUser(inParam);
		if(user != null) {
			return false;
		}
		
		int cnt = userMapper.insertUser(param);
		if(cnt > 0) {
			return true;
		}
		return false;
	}
}
