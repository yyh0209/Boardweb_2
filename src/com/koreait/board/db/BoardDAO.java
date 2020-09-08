package com.koreait.board.db;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import com.koreait.board.vo.BoardVO;

public class BoardDAO {
	//리스트타입
	public static int insBoard(BoardVO param) {
		int result=0;
		Connection con=null;//연결
		PreparedStatement ps=null;//실
		//한줄 레코드가 아닌 한값을 가져온다 정수값만 받아온다.
		String sql=" INSERT INTO t_board "
		+" (i_board,title,ctnt,i_student) "
		+" VALUES "
		+" (seq_board.nextval,?,?,?) ";
		
		try {
			con=DbCon.getCon();
			ps=con.prepareStatement(sql);
			ps.setNString(1, param.getTitle());
			ps.setNString(2, param.getCtnt());
			ps.setInt(3, param.getI_student());
			result=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbCon.close(con, ps);
		}
		return result;
		//1이 리턴되야만 
	}
	public static List<BoardVO>selBoardList(){
		List<BoardVO> list=new ArrayList();//BoardVO의 리스트만 담은 상태
		
		Connection con=null;//연결
		PreparedStatement ps=null;//실행
		ResultSet rs=null;//조회
		
		//rs.next():
		
		//게시판 리스트를 가져오자
		//1.
		String sql="SELECT i_board,title,i_student FROM t_board "+
		"ORDER BY i_board DESC";
		
		
		try {
			con=DbCon.getCon();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();//쿼리문 조회 여러줄을 가져온다.
			//rs는 항상 while문과 같이 쓴다
			
			//next():는 줄 가리키기
			while(rs.next()) {
				int i_board=rs.getInt("i_board");//컬럼명을 가져온다. 항상 이름으로 가져오는게 안전
				String title=rs.getNString("title");//
				int i_student=rs.getInt("i_student");
				BoardVO vo=new BoardVO();
				vo.setI_board(i_board);
				vo.setTitle(title);
				vo.setI_student(i_student);
				//
				list.add(vo);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DbCon.close(con, ps, rs);
		}
		return list;//리스트를 반환한다.
		
	}
	//수정을 덜할수있는 구조			//넘어오는 값은고객이 보고싶은것
	//boardvo타입 레코드 하나만 해서 리스트타입이 아님.
	//db로 부터 특정 레코드 값이 필요함.
	public static BoardVO selBoard(BoardVO param) {//BoardVO의 리스트만 담은 상태
								//i_board에 값을 넣고 보낸다.
			BoardVO vo = null;
			Connection con = null;//연결
			PreparedStatement ps = null;//실행
			ResultSet rs = null;//조회
			
			//rs.next():
			
			//게시판 리스트를 가져오자
			//1.리스트에 내용을 쓰면 안된다.
			//트래픽만 많이 발생하고 모이면 모일수록 불리하게 만든다. ctnt때문에 detail이 있는것.
			String sql = " SELECT i_board , title , ctnt , i_student FROM t_board "+
			" WHERE i_board = ? ";
//			내가 어떤 리스트를 보고싶은가?
			
			try {
				con=DbCon.getCon();
				ps=con.prepareStatement(sql);
				ps.setInt(1, param.getI_board());
				//내고 보고싶은 글
				
				//rs는 항상 while문과 같이 쓴다
				rs=ps.executeQuery();
				//next():는 줄 가리키기
				if(rs.next()) {
					String title=rs.getNString("title");//
					String ctnt=rs.getNString("ctnt");
					int i_student=rs.getInt("i_student");
					
					//객체화 함.
					vo=new BoardVO();
					vo.setI_board(param.getI_board());
					vo.setTitle(title);
					vo.setI_student(i_student);
					vo.setCtnt(ctnt);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				DbCon.close(con, ps, rs);
			}
			return vo;//리스트를 반환한다.
			
		}
	//글 삭제전용 
	//수정을 덜해도 된다 객체만 수정하고 받는 부분만 바뀌면 된다. 지금 컬럼값을 반은 상태
	public static int delBoard(int i_board) {
		Connection con=null;//연결
		PreparedStatement ps=null;//실행
		int result=0;//
		
		String sql="DELETE"+" FROM t_board "+
				"WHERE i_board=?";
		//기본값은 "삭제가 안됨"으로 설정= 1이 넘어오면 삭제가 잘됐다는것.
		try{
			con=DbCon.getCon();
			ps=con.prepareStatement(sql);
			ps.setInt(1,i_board);
			
			result=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbCon.close(con, ps);
		}
		return result;
	}
	public static int UpdateBoard(BoardVO param) {
		String sql="UPDATE t_board"
	+" set title=? "
	+" ctnt=? "
	+" WHERE i_board = ?";
		Connection con=null;//연결
		PreparedStatement ps=null;//실행
		int result=0;//
		
		try{
			con=DbCon.getCon();
			ps=con.prepareStatement(sql);
			ps.setNString(1,param.getTitle());
			ps.setNString(2,param.getCtnt());
			ps.setInt(3,param.getI_board());
			result=ps.executeUpdate();
			System.out.println("수정!");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbCon.close(con, ps);
		}
		return result;
	}
}
