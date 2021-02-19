<%@page import="com.mvc.dto.MVCDto"%>
<%@page import="java.util.List"%>
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
	
	List<MVCDto> list = (List<MVCDto>) request.getAttribute("list");

%>

	<h1>list</h1>
	
	<table border="1">
		<col width="30px">
		<col width="50px">
		<col width="100px">
		<col width="200px">
		<col width="100px">
	
		<tr>
			<th><input type="checkbox" name="all" onclick="this.checked"></th>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>
		</tr>
		
<%
	
	for (MVCDto dto : list) {

%>
	<tr>
		<th><input type="checkbox" name="chk"></th>
		<td><%=dto.getSeq() %></td>
		<td><%=dto.getWriter() %></td>
		<td><a href="mycontroller.jsp?command=select&seq=<%=dto.getSeq() %>"><%=dto.getTitle() %></a></td>
		<td><%=dto.getRegdate() %></td>
	</tr>
<%

	}

%>
	<tr>
		<td colspan="5" align="right">
			<input type="button" value="선택삭제" onclick="" />
			<input type="button" value="글작성" onclick="location.href='mycontroller.jsp?command=insertform'" />
		</td>
	</tr>
	</table>

</body>
</html>