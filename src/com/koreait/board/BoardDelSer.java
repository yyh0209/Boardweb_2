package com.koreait.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board.common.Utils;
import com.koreait.board.db.BoardDAO;

@WebServlet("/boardDel")
public class BoardDelSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strI_board=request.getParameter("i_board");
		int i_board=Utils.parseStringToInt(strI_board);
		
		
		if(i_board==0) {//잘못된 값을 보낼때 잘못된 접근입니다를 보냄.
			response.sendRedirect("");//response.sendRedirect 는 문자열을 받아서
			return;
		}
		//성공하면 쿼리문을 실행하면서 글 삭제가 이뤄지고 리스트로 이동하게 된다.
	}
}
