<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="com.koreait.board.vo.BoardVO" %>
<%
	@SuppressWarnings("unchecked")
	List<BoardVO> list = (List<BoardVO>)request.getAttribute("data");
	//빨간줄 뜨는걸 방지하기 위해선.
	//java영역에 list 와 BoardVO가 선언되지 않았다.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
<style type="text/css">
	.itemRow:hover{
	background-color: #ecf0f1;
	cursor: pointer;
	}
</style>
</head>
<body>
	<div>게시판 리스트
	 	<a href="/boardWrite"><button>글쓰기</button></a>
	 </div>
	<table>
	 	<tr>
	 		<th>NO</th>
	 		<th>제목</th>
	 		<th>작성자</th>
	 	</tr>
	 		<% for(BoardVO vo: list){ %>
 		<tr class="itemRow" onclick="moveToDetail(<%= vo.getI_board() %>)">
 		<!-- 줄을 선택하면 이동한다. -->
	 		<td><%= vo.getI_board() %></td>
	 		<td><%= vo.getTitle() %></td> 
	 		<td><%= vo.getI_student() %></td>
	 	</tr>
	 	<% } %>
	 </table>
 	<script>
 	function moveToDetail(i_board){
 		console.log('moveToDetail-i_board:'+i_board)
 		location.href='boardDetail?i_board='+i_board
 	}
 	</script>
</body>
</html>