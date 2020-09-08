<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 여기서 수정과 글쓰기를 동시에.
    	주소값을 열었을데 
    	보내는 방식을 포스트로 만든다.
    	글쓰기를 누르면 주소값이 이동함 이 파일이 열려야되는데 제목,내용,작성자를 적을수있어야됨.
    	눌렀을때 여기로 가야되는데 방식이 포스트다. 
    	글등록을 하고 리스트로 보낸다.-->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${data==null ? '글등록':'글수정'}</title>
<style>
	.err{
		color:#e74c3c;
	}
</style>
</head>
<body>
<div>${data==null ? '글등록':'글수정'}</div>
<div class="err">${msg}</div>
	<form id="frm" action="/${data==null ? 'boardWrite':'boardMod'}" method="post" onsubmit="return chk()">
	<input type="hidden" name="i_board" value="${data.i_board}">
		<div> <label>제목:<input type="text" name="title" value="${data.title}"></label></div>
		<div> <label>내용:<textarea name="ctnt">${data.ctnt}</textarea></label></div>
		<div> <label>작성자:<input type="text" name="i_student" value="${data.i_student}" ${data==null ? '':'readonly'}></label></div>
		<div> <input type="submit" value="${data==null ? '글등록':'글수정'}"></div>
	</form>
	
	<script>
	function eleVaild(ele,nm){
		if(ele.value.length==0){
			alert(nm+"을(를) 입력해주세요.");
			ele.focus();
			return true
		}
	}
	function chk(){
		if(eleVaild(frm.title,'제목')){
			return false;
			}
			else if(eleVaild(frm.ctnt,'내용')){
				return false;
			}else if(eleVaild(frm.i_student,'작성자')){
				return false;
			}
			}</script>
</body>
</html>