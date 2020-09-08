package com.koreait.board.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbCon {
	public static Connection getCon() throws Exception{
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
    	String username="hr";
    	String password="koreait2020";
    	//이 메소드도 try catch로 넘겨진 상태라서 빨간줄뜸.
    	Class.forName("oracle.jdbc.driver.OracleDriver");
    	//현재 throw된 상태에서 빨간줄이 뜬다. 해결하려면 try catch를 해야된다.
    	Connection con = DriverManager.getConnection(url, username, password);
    	System.out.println("접속 성공");
    	return con; 
    	
    	
	}
					//인자값이 세개다.
	public static void close(Connection con,PreparedStatement ps,ResultSet rs) {
		//메소드를 만들어라.
		if(rs!=null) {
			try {
				rs.close();
			}catch(Exception e) {
				
			}
		}
		close(con, ps);
	}
	

	public static void close(Connection con,PreparedStatement ps) {
		
		if(ps!=null) {try {ps.close();}catch(Exception e) {}}
		if(con!=null) {try {con.close();}catch(Exception e) {}}
	}
}
