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
		// 1. ������� ��û path ������ �����Ѵ�.
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		// 2. ��û path�� �ش��ϴ� Controller�� �˻��Ѵ�.
		Controller ctrl = mapping.getController(path);
		
		// 3. �˻��� Controller�� �����Ѵ�.
		String viewPage = ctrl.handleRequest(request, response);
		
		// 4. Controller�� ������ ȭ������ �̵��Ѵ�.
		response.sendRedirect(viewPage);		
	}
}




