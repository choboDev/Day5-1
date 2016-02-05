package com.multicampus.view.common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class TimeCheckFilter implements Filter {

//    public TimeCheckFilter() {    	      
//    	System.out.println("===> TimeCheckFilter 객체 생성");
//    }
    
	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		
		long start = System.currentTimeMillis();		
		chain.doFilter(request, response);		
		long end = System.currentTimeMillis();
//		System.out.println(path + " 요청 처리에 걸린 시간 : " + 
//		(end - start) + "(ms)초");
	}
	
	public void destroy() {
	}

}
