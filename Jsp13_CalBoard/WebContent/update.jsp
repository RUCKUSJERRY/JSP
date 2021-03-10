<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>    
<% response.setContentType("text/html; charset=UTF-8"); %>
 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="util" class="com.cal.common.Util"></jsp:useBean>

	<h1>일정 수정</h1>

	<form action="cal.do">
		<input type="hidden" name="command" value="update">
		<table border="1">
		
		<tr>
			<th>번호</th>
			<td><input type="text" name="seq" value="${dto.seq }" readonly="readonly"></td>		
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" value="${dto.title }"></td>
		</tr>
		<tr>
			<th>일정</th>
			<td>
			<jsp:setProperty property="todates" name="util" value="${dto.mdate }"/>
			<jsp:getProperty property="todates" name="util"/>
			</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>
			<fmt:formatDate value="${dto.regdate }" pattern="yyyy.mm.dd"/>
			</td>
		</tr>		
		<tr>
			<th>내용</th>
			<td><textarea cols="60" rows="10" name="content">${dto.content }</textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
			<input type="submit" value="일정수정">
			<input type="button" value="취소" onclick="history.back()">
			</td>
		</tr>	
	
	</table>
	
	</form>

</body>
</html>