<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html;charset=UTF-8"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="myinsert_res.jsp" method="post">
		<h1>글쓰기</h1>
	
	<table border="1">
		<col width="100px">
		<col width="100px">
		<col width="200px">
		<col width="100px">
	<tr>
		<td>작성자</td><td><input type="text" name="writer"></td>
	</tr>
	<tr>
		<td>제목</td><td><input type="text" name="title"></td>
	</tr>
	<tr>
		<td>내용</td><td><textarea rows="10" cols="60" name="content"></textarea></td>
	</tr>
	<tr>
		<td colspan="2" align="right">
		<button>작성</button>
		<input type="button" value="취소" onclick="location.href='mylist.jsp'">
		</td>
	</tr>
	</table>
	
	
	</form>
	
</body>
</html>