package com.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

    // 权限拦截
	@Override
	public boolean preHandle( HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		
		if(request.getSession().getAttribute("user")==null) {
			if(uri.endsWith("/totalTypes")||uri.endsWith("/singleTypes")||uri.endsWith("/toProduct")||uri.endsWith("/toProduct2")||uri.endsWith("/searchWord")||uri.endsWith("/findTodayBooks")||uri.endsWith("/toLogin")||uri.endsWith("/doLogin")||uri.endsWith("/vode.png")||uri.endsWith("/toBookList")||uri.endsWith("/bookList")||uri.endsWith("/")||uri.endsWith("/findAllNewBooks"))
			{
				return true;// 让流程继续走
				
			}
			response.sendRedirect("/toLogin");// 打回到登陆页面
			return false;
			
			
		}else {
			
			
			
			return true;// 让流程继续走
		}
		
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
