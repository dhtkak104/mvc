package com.basic.interceptor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.basic.mapper.UserMapper;

/* Interceptor: 요청을 가로채서 비즈니스 로직과 무관한 부가적인 작업을 수행할 때 사용. ex) 로그인 확인, 권한체크  
 * 순서: (filter ->) preHandle -> controller -> postHandle
 */ 
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private UserMapper userMapper;
	
	// Controller 실행되기 전에 호출. 반환값이 true일 경우 Controller로 넘어가며, false일 경우 Controller로 넘어가지 않고 요청이 끝남.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		if(session.getAttribute("user") != null) return true; 
		
		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
		if(loginCookie != null) 
		{
			String sessionId = loginCookie.getValue();
			
			Map<String, Object> param = new HashMap<>();
			param.put("sessionId", sessionId);
			Map<String, Object> user = userMapper.selectUserBySessionId(param);
			if(user != null) {
				session.setAttribute("user", user);
				return true;
			}
		}
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath+"/login-view");
		return false;
	}

	// Controller 실행이 끝난 후, 뷰(View)를 렌더링하기 전에 호출.
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
}
