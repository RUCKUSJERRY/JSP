<%@page import="com.mvc.dto.MVCDto"%>
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

<%

	MVCDto dto = (MVCDto) request.getAttribute("dto");
		

%>
	
	<h1>UPDATE</h1>
	
	<form action="controller.do" method="post">
		<input type="hidden" name="command" value="updateres">
		<table border="1">
			
			<tr>
				<th>번호</th>
				<td><input type="text" name="seq" value="<%=dto.getSeq() %>" readonly="readonly" /></td>
			</tr>
			
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" value="<%=dto.getWriter() %>" readonly="readonly" /></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="<%=dto.getTitle() %>" /></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" cols="60" rows="10"><%=dto.getContent() %></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="글작성" name="writer"/>
				<input type="button" value="취소" onclick="location.href='controller.do?command=select&seq=<%=dto.getSeq() %>'"/>
				</td>
			</tr>
		
		</table>
		</form>
	

</body>
</html>