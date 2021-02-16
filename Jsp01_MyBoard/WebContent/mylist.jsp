<%@page import="com.myboard.biz.MyBoardBizImpl"%>
<%@page import="com.myboard.biz.MyBoardBiz"%>
<%@page import="com.myboard.dao.MyBoardDao"%>
<%@page import="com.myboard.dao.MyBoardDaoImpl"%>
<%@page import="com.myboard.dto.MyBoardDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html;charset=UTF-8"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	
	table {
		text-align:center;
	}

</style>

</head>
<body>

<%
	//interface biz = new 얘의 자식();
	MyBoardBiz biz = new MyBoardBizImpl();
	List<MyBoardDto> list = biz.selectList();
	
%>
	
	<h1>게시판</h1>
	
	<table border="1">
		<col width="50px">
		<col width="100px">
		<col width="200px">
		<col width="100px">
		<tr>
			<td>번호</td>	
			<td>작성자</td>
			<td>제목</td>
			<td>날짜</td>
		</tr>
	<%
		for (int i = 0; i < list.size(); i++) {
	%>	

		<tr>
			<td><%=list.get(i).getSeq() %></td>		
			<td><%=list.get(i).getWriter() %></td>		
			<td><a href="myselect.jsp?seq=<%=list.get(i).getSeq() %>"><%=list.get(i).getTitle() %></a></td>
			<td><%=list.get(i).getRegdate() %></td>
		</tr>
	
	<%	
		}
	%>

	
		<tr>  
			<td colspan="4" align="right">
			<input type="button" value="글쓰기" onclick="location.href='myinsert.jsp'">
			</td>
		</tr>
	
	</table>
	
</body>
</html>