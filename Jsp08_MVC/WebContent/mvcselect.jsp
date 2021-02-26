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
	
	<jsp:useBean id="dto" class="com.mvc.dto.MVCDto" scope="request"></jsp:useBean>
	
	<h1>SELECT</h1>

	<table border="1">
		<col width="50">
		<col width="200">
		
		<tr>
			<td>번호</td>
			<td><jsp:getProperty property="seq" name="dto"/></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><jsp:getProperty property="writer" name="dto"/></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><jsp:getProperty property="title" name="dto"/></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea rows="10" cols="60" readonly="readonly"><jsp:getProperty property="content" name="dto"/></textarea> </td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="수정" onclick="location.href='mvc.do?command=updateform&seq=<jsp:getProperty property="seq" name="dto"/>'">
				<input type="button" value="삭제" onclick="location.href='mvc.do?command=delete&seq=<jsp:getProperty property="seq" name="dto"/>'">
				<input type="button" value="목록" onclick="location.href='mvc.do?command=list'">
			</td>
		</tr>
	</table>

</body>
</html>