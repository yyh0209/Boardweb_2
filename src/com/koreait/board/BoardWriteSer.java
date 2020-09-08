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

@WebServlet("/boardWrite")
public class BoardWriteSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp="/WEB-INF/view/boardRegmod.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
		//포스트 처리 
		//삭제를 get으로 하는데  이유는화면이 없어서
	}
	//v포스트방식으로 날아가면 호출  리스트로 보낸다.0
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title=request.getParameter("title");
		String ctnt=request.getParameter("ctnt");
		String strI_student=request.getParameter("i_student");
		
		System.out.println("title:"+title);
		System.out.println("ctnt:"+ctnt);
		System.out.println("strI_student:"+strI_student);
		
		BoardVO param=new BoardVO();
		param.setTitle(title);
		param.setCtnt(ctnt);
		param.setI_student(Utils.parseStringToInt(strI_student));
		
		int result=BoardDAO.insBoard(param);
		System.out.println("result:"+result);
		
		if(result==1) {
			//정상
			response.sendRedirect("/boardList");
		}else {
			request.setAttribute("msg", "에러가 발생했습니다");
			doGet(request,response);
		}
	}

}
