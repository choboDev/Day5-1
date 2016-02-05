package com.multicampus.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.multicampus.biz.user.UserDAO;
import com.multicampus.biz.user.UserVO;

public class InsertUserController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
			                    HttpServletResponse response) {
		System.out.println("ȸ�� ���� ��� ó��");
		
		// 1. ����� �Է����� ����
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String role = request.getParameter("role");
		
		// 2. DB ���� ó��
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		vo.setName(name);
		vo.setRole(role);
		
		UserDAO userDAO = new UserDAO();
		userDAO.insertUser(vo);
		
		// 3. ȭ�� �׺���̼�
		ModelAndView mav=new ModelAndView();
		mav.setViewName("login.html");
		return mav;
	}

}
