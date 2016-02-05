package com.multicampus.biz.board;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BoardServiceClient {
	public static void main(String[] args) {
		// 1. Spring �����̳ʸ� �����Ѵ�.
		ApplicationContext container = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring �����̳ʷκ��� BoardService Ÿ���� ��ü�� Lookup�Ѵ�.
		BoardService boardService = 
			(BoardService) container.getBean("boardService");
		
		// 3. Lookup�� ��ü�� �޼ҵ� �׽�Ʈ
		BoardVO vo = new BoardVO();
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		System.out.println("<< �Խñ� ��� >>");
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
}


