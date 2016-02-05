package com.multicampus.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LogoutController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			                    HttpServletResponse response) {
		System.out.println("�α׾ƿ� ��� ó��");
		
		// �α׾ƿ� ��û�� �������� ���ε� ������ ���� �����ϰ� ���� ȭ������ �̵�
		HttpSession session = request.getSession();
		session.invalidate();

		ModelAndView mav = new ModelAndView();
		mav.setViewName("login.html");
		return mav;
	}

}
