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

	<jsp:useBean id="dto" class="com.mvc.dto.MVCDto" scope="request"></jsp:useBean>

	<h1>UPDATE</h1>
	<form action="mvc.do">
	<input type="hidden" name="command" value="updateres">
	<input type="hidden" name="seq" value="<jsp:getProperty property="seq" name="dto"/>">
	<table border="1">
		<col width="50">
		<col width="200">
		<tr>
			<td>작성자</td>
			<td><jsp:getProperty property="writer" name="dto"/></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="title" value="<jsp:getProperty property="title" name="dto"/>"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea rows="10" name="content" cols="60"><jsp:getProperty property="content" name="dto"/></textarea> </td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" value="수정하기">
				<input type="button" value="취소" onclick="location.href='mvc.do?command=select&seq=<jsp:getProperty property="seq" name="dto"/>'">
				<input type="button" value="목록" onclick="location.href='mvc.do?command=list'">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>