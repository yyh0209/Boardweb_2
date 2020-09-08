package com.koreait.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board.common.Utils;
import com.koreait.board.db.BoardDAO;
import com.koreait.board.vo.BoardVO;

@WebServlet("/boardDetail") //연결되는 주소값매핑이다.
//로직담당은 서블릿
public class BoardDetailSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	//get방식은 주로 form태그로 화면 띄우기
	//view담당을 jsp파일
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVO param=new BoardVO();
		String strI_board=request.getParameter("i_board");
//		"1$1111"문제가 발생했다면 0을 리턴하라.
		
		int i_board=Utils.parseStringToInt(strI_board,0);
		
		if(i_board==0) {
			response.sendRedirect("/boardList");
			return;
			//샌드리다이렉트와 리퀘스트디스페쳐는 동시에 선언하면 갈팡질팡한다.
		}
		param.setI_board(i_board);
		
		BoardVO data=BoardDAO.selBoard(param);//db로 값을 받는다.
		//혹시 다른 값을 도보내야할때 수정과정이 어렵지않다.
		request.setAttribute("data", data);//타입은 boardvo

		String jsp="/WEB-INF/view/boardDetail.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}
}
