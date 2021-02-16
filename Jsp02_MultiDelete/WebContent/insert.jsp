<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>작성하기</h1>
	
	<form action="./insert_res.jsp" method="post">
		<table border="1">
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<td>글제목</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" cols="60" name="content"></textarea></td>
			</tr>
		</table>
		<button>작성</button>
		<input type="button" value="취소" onclick="location.href='boardlist.jsp'">
	
	</form>

</body>
</html>