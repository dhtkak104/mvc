package com.basic.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.basic.service.UserService;

@Controller
//@RequestMapping("user")
public class UserViewController {

	@Autowired
	private UserService userService;
	
	/*				쿠키(Cookie)			세션(Session) 
	 *  저장위치		클라이언트(=접속자PC)	웹서버		 
	 *  만료시점		쿠키 저장시 설정		브라우저 종료시 삭제
	 *  용량제한		4KB					제한없음
	 * 	속도			세션보다 빠름			쿠키보다 느림
	 * 	보안			세션보다 안좋음			쿠키보다 좋음
	 * */
	
	@GetMapping("login-view")
	public ModelAndView selectLoginView(@RequestParam Map<String, Object> param) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		mv.setStatus(HttpStatus.valueOf(200));
		return mv;
	}
	
	@ResponseBody
	@PostMapping("login")
	public boolean loginUser(@RequestBody Map<String, Object> param, HttpServletRequest request) {
		Map<String, Object> user = userService.loginUser(param);
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		boolean result = false;
		if(user != null) {
			result = true;
		}
		return result;
	}
	
	@ResponseBody
	@PostMapping("logout")
	public boolean loginoutUser(@RequestBody Map<String, Object> param, HttpServletRequest request) {
		HttpSession session = request.getSession();  
		session.invalidate();
		return true;
	}
	
	@GetMapping("join-view")
	public ModelAndView selectJoinView(@RequestParam Map<String, Object> param) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("join");
		mv.setStatus(HttpStatus.valueOf(200));
		return mv;
	}
	
	@ResponseBody
	@PostMapping("join")
	public boolean joinUser(@RequestBody Map<String, Object> param) {
		boolean result = userService.joinUser(param);
		return result;
	}
}
