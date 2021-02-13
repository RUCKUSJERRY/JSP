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
<%



%>

	
	<h1>게시글</h1>
	
	<table border="1">
		<col width="100px">
		<col width="100px">
		<col width="200px">
		<col width="100px">
	<tr>
		<td>글번호</td><td>들어갈번호</td>
	</tr>
	<tr>
		<td>작성자</td><td>작성자이름</td>
	</tr>
	<tr>
		<td>제목</td><td>들어갈제목</td>
	</tr>
	<tr>
		<td>내용</td><td><textarea rows="10" cols="60">드갈내용</textarea></td>
	</tr>
	<tr>
		<td colspan="2" align="right">
		<input type="button" value="작성" onclick="location.href='myinsert_res.jsp'">
		<input type="button" value="취소" onclick="location.href='mylist.jsp'">
		</td>
	</tr>
	</table>
	
</body>
</html>