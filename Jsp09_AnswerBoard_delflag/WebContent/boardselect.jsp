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

	<h1>SELECT</h1>
	
	<table border="1">
		
		<tr>
			<th>제목</th>
			<td>
				<input type="text" readonly="readonly" value="${dto.title }" />
			</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>
				<input type="text" readonly="readonly" value="${dto.writer }" />
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea cols="60" rows="10" readonly="readonly">${dto.content }</textarea>
			</td>
		</tr>
		<tr>	
			<td colspan="2" align="right">
			<input type="button" value="답변" onclick="location.href='answer.do?command=answerform&boardno=${dto.boardno}'">
			<input type="button" value="수정" onclick="location.href='answer.do?command=updateform&boardno=${dto.boardno}'">
			<input type="button" value="삭제" onclick="location.href='answer.do?command=boarddelete&boardno=${dto.boardno}'">
			<input type="button" value="목록" onclick="location.href='answer.do?command=list'">
			</td>
		</tr>
		
	</table>
	

</body>
</html>