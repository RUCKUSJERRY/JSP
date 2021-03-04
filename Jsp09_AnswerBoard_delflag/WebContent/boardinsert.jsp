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

	<h1>INSERT</h1>

	<form action="answer.do" method="post">
		<input type="hidden" name="command" value="boardinsert">
		<table border="1">
			
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" /></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" /></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><textarea cols="60" rows="10" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="작성">
					<input type="button" value="취소" onclick="location.href='answer.do?command=list'">
				</td>
			</tr>
		</table>
	
		
	</form>

</body>
</html>