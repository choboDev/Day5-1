package com.multicampus.view.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HandlerMapping mapping;

	public void init() throws ServletException {
		mapping = new HandlerMapping();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. 사용자의 요청 path 정보를 추출한다.
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		// 2. 요청 path에 해당하는 Controller를 검색한다.
		Controller ctrl = mapping.getController(path);
		
		// 3. 검색된 Controller를 실행한다.
		String viewPage = ctrl.handleRequest(request, response);
		
		// 4. Controller가 리턴한 화면으로 이동한다.
		response.sendRedirect(viewPage);		
	}
}





