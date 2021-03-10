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
	
	<h1>일정</h1>

	<table border="1">
	
		<tr>
			<th>번호</th>
			<td>${dto.seq }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${dto.title }</td>
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
			<td><textarea cols="60" rows="10">${dto.content }</textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
			<input type="button" value="일정수정" onclick="location.href='cal.do?command=updateform&seq=${dto.seq }'">
			<input type="button" value="일정삭제" onclick="location.href='cal.do?command=delete&seq=${dto.seq }'">
			<input type="button" value="목록" onclick="history.back()">
			</td>
		</tr>	
	
	</table>

</body>
</html>