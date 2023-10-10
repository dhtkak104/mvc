package com.basic.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.util.WebUtils;

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
	public boolean loginUser(@RequestBody Map<String, Object> param, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> user = userService.loginUser(param);
		if (user == null) return false;
		
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		if((boolean) param.get("autoLogin")) {
			String sessionId = session.getId();
			int expiry = 60*60*24*7;
			Date expiredAt = new Date(System.currentTimeMillis()+(expiry*1000));
			
			Map<String, Object> inParam = new HashMap<>();
	    	inParam.put("isKeepLogin", true);
	    	inParam.put("sessionId", sessionId);
	    	inParam.put("expiredAt", expiredAt);
	    	inParam.put("email", user.get("email"));
	    	userService.isKeepLogin(inParam);
			
			Cookie loginCookie = new Cookie("loginCookie", sessionId);
	    	loginCookie.setPath("/");
	    	loginCookie.setMaxAge(expiry); //7일
	    	response.addCookie(loginCookie);
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@PostMapping("logout")
	public boolean loginoutUser(@RequestBody Map<String, Object> param, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> user = (Map<String, Object>) session.getAttribute("user");
		session.removeAttribute("user");
		session.invalidate();
		
		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
		if(loginCookie != null) 
		{
			Map<String, Object> inParam = new HashMap<>();
	    	inParam.put("isKeepLogin", false);
	    	inParam.put("email", user.get("email"));
	    	userService.isKeepLogin(inParam);
	    	
			loginCookie.setMaxAge(0);
            response.addCookie(loginCookie);
		}
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
