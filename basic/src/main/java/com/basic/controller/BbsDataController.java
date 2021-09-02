package com.basic.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.basic.service.BbsService;

@RestController
public class BbsDataController {

	@Autowired
	private BbsService bbsService;
	
	@GetMapping("bbs/{bbsNo}")
	public ResponseEntity<?> selectBbs(@RequestParam Map<String, Object> param, @PathVariable Object bbsNo) {
		param.put("bbsNo", bbsNo);
		Map<String, Object> result = bbsService.selectBbs(param);
		return new ResponseEntity<>(result, HttpStatus.valueOf(200));
	}
}
