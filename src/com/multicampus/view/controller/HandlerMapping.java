package com.multicampus.view.controller;

import java.util.HashMap;
import java.util.Map;

import com.multicampus.view.board.DeleteBoardController;
import com.multicampus.view.board.GetBoardController;
import com.multicampus.view.board.GetBoardListController;
import com.multicampus.view.board.InsertBoardController;
import com.multicampus.view.board.UpdateBoardController;
import com.multicampus.view.user.InsertUserController;
import com.multicampus.view.user.LoginController;
import com.multicampus.view.user.LogoutController;

public class HandlerMapping {
	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		System.out.println("### 모든 컨트롤러를 생성하여 Map에 등록 ###");
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do",        new LoginController());
		mappings.put("/logout.do",       new LogoutController());
		mappings.put("/insertUser.do",   new InsertUserController());
		
		mappings.put("/insertBoard.do",  new InsertBoardController());
		mappings.put("/updateBoard.do",  new UpdateBoardController());
		mappings.put("/deleteBoard.do",  new DeleteBoardController());
		mappings.put("/getBoard.do",     new GetBoardController());
		mappings.put("/getBoardList.do", new GetBoardListController());
	}

	public Controller getController(String path) {
		return mappings.get(path);
	}

}
