package com.koreait.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board.common.Utils;
import com.koreait.board.db.BoardDAO;
import com.koreait.board.vo.BoardVO;

@WebServlet("/boardMod")
public class BoardMod extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVO param=new BoardVO();
		String strI_board=request.getParameter("i_board");
		int i_board=Utils.parseStringToInt(strI_board);
		if(i_board==0) {//잘못된 값을 보낼때 잘못된 접근입니다를 보냄.
			response.sendRedirect("/boardList");
			return;
		}
		
		param.setI_board(i_board);
		request.setAttribute("data",BoardDAO.selBoard(param));
		//널이 아니면 글수정
		
		String jsp="/WEB-INF/view/boardRegmod.jsp";
		//열리는 파일만 다를뿐 똑같다.
		request.getRequestDispatcher(jsp).forward(request, response);
		
		//boardMod에서 필요한것 글수정  null이 아니면 boardMod로 날아가게 만들자.
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//최종적으로 post 로 날아간다.
		//update를 구현하라//히든타입으로 숨겨놓은 상태 실재론 있다.
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		String strI_board = request.getParameter("i_board");
		int i_board=Utils.parseStringToInt("strI_board");
		//글수정을 위한 sql문
		
		BoardVO param=new BoardVO();
		param.setI_board(i_board);
		param.setTitle(title);
		param.setCtnt(ctnt);
		
		int result = BoardDAO.UpdateBoard(param);
		
		response.sendRedirect("/boardDetail?i_board="+strI_board);
	}
}
