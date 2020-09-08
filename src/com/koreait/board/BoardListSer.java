package com.koreait.board;

import java.io.IOException;
import java.sql.*;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board.db.BoardDAO;
import com.koreait.board.vo.BoardVO;
import com.koreait.board.db.DbCon;
@WebServlet("/boardList")//주소값 매핑 일종의 약속
//안할거면 xml에다 상당히 긴글로 적어야한다.
public class BoardListSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//세션
 
	public BoardListSer() {
		super();
	}
    //둘중에 필요한것만.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BoardVO> list=BoardDAO.selBoardList();
		request.setAttribute("data", list);
		
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/boardList.jsp");
		rd.forward(request, response);
		
		//객체한테 일시켜서 가져온다.
			//메소드옆에 throws가 있으면 무조건 trycatch로 감싸줘야한다.
		//오브젝트로 들어갔으면 오브젝트로 나온다.`
		
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
