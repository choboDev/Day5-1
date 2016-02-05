package com.multicampus.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.multicampus.view.controller.Controller;

public class LogoutController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request,
			                    HttpServletResponse response) {
		System.out.println("로그아웃 기능 처리");
		
		// 로그아웃 요청한 브라우저와 매핑된 세션을 강제 종료하고 메인 화면으로 이동
		HttpSession session = request.getSession();
		session.invalidate();

		return "login.html";
	}

}
