package com.multicampus.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.multicampus.biz.user.UserDAO;
import com.multicampus.biz.user.UserVO;
import com.multicampus.view.controller.Controller;

public class InsertUserController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, 
			                    HttpServletResponse response) {
		System.out.println("회원 가입 기능 처리");
		
		// 1. 사용자 입력정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String role = request.getParameter("role");
		
		// 2. DB 연동 처리
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		vo.setName(name);
		vo.setRole(role);
		
		UserDAO userDAO = new UserDAO();
		userDAO.insertUser(vo);
		
		// 3. 화면 네비게이션
		return "login.html";
	}

}
