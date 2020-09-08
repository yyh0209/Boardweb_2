<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세페이지</title>
</head>
<body>
	<!-- EL표현식
	는 내장객체중에 담겨있는것만 쓸수있다.
	 한개만 있을때 제일먼저 만나는게 페이지다.
	페이지 컨텍스트에 있다면 
	쓰는 방법{내장객체 명.맴버값 } -->
	<div><button onclick="doDel(${data.i_board})">삭제</button></div>
	<a href="/boardMod?i_board=${data.i_board}"><button>수정</button></a>
	<div>상세페이지</div>
	<div>${data.i_board}</div>
	<div>${data.title}</div>
	<div>${data.ctnt}</div>
	<div>${data.i_student}</div>
<!-- 상세페이지를 화면에 띄어라. -->
<script>
//삭제할려면 컬럼값이 필요함
//객체 밖에 있으면 함수
//객체내에 있다면 메소드
	function doDel(i_board){
		if(confirm('삭제하시겠습니까?')){
			location.href='/boardDel?i_board='+i_board
					//1.dodel함수를 호출해야되고 호출됬다면 yes를 눌렸을때 저 주소로 이동한다. 주소값을 받는 서블릿을 만들어야된다.
					//찾을수 없습니다라고 안떠야한다.
					//프로세스를 처리해야된다. location으로 이동하면 get방식으로 프로세스를 처리하다.
					//삭제가 완료되면 boardList로 이동한다.
		}
	}
</script>
</body>
</html>