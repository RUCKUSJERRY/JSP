<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<% request.setCharacterEncoding("UTF-8"); %>    
<% response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

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
		
	<c:forEach items="${list }" var="dto">
	<tr>
		<th><input type="checkbox" name="chk"></th>
		<td><c:out value="${dto.seq }"></c:out></td>
		<td><c:out value="${dto.writer }"></c:out></td>
		<td><a href="controller.do?command=select&seq=${dto.seq }"><c:out value="${dto.title }"></c:out></a></td>
		<td><c:out value="${dto.regdate }"></c:out></td>
	</tr>
	</c:forEach>
	
	<tr>
		<td colspan="5" align="right">
			<input type="button" value="선택삭제" onclick="" />
			<input type="button" value="글작성" onclick="location.href='controller.do?command=insertform'" />
		</td>
	</tr>
	</table>

</body>
</html>