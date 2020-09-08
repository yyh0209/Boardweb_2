package com.koreait.board.common;

public class Utils {
	 public static int parseStringToInt(String str){//정수값으로 파싱한다.
		 return parseStringToInt(str,0);
	 }
	
 public static int parseStringToInt(String strI_board,int n){//정수값으로 파싱한다.
//	 String strI_board=request.getParameter("i_board");
	 //문자가 섞여 있었다면 정수를 바꿀수 없다.0을 리턴해줘야한다.
//	int i_board=Utils.parseStringToInt(strI_board,0);
//	 문제가 발생했다면 0을 리턴하라.
	
	 try {
		int nParam=Integer.parseInt(strI_board);
		//문자열을 정수로 바꿀때
		return nParam;//정수로
	 }catch(NumberFormatException  e) {
		 e.printStackTrace();
		 return n;//숫자에서 문자가 섞일경우. 
	 }
	}
}
