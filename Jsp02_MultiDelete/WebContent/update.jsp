<%@page import="com.muldel.biz.MDBoardBizImpl"%>
<%@page import="com.muldel.biz.MDBoardBiz"%>
<%@page import="com.muldel.dto.MDBoardDto"%>
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

<%
	
	int seq = Integer.parseInt(request.getParameter("seq"));
	
	MDBoardDto dto = new MDBoardDto();
	MDBoardBiz biz = new MDBoardBizImpl();
	dto = biz.selectOne(seq);
	
%>

<body>
	
	<h1>수정하기</h1>
	
	<form action="./update_res.jsp?seq=<%=dto.getSeq()%>" method="post">
		<table border="1">
			<col width="50px">
			<col width="200px">
			<tr>
				<td colspan="2"><%=dto.getSeq() %> : <%=dto.getWriter() %></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value="<%=dto.getTitle() %>"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" name="content" cols="60"><%=dto.getContent() %></textarea></td>
			</tr>
		</table>
		<button>수정</button>
		<input type="button" value="취소" onclick="location.href='select.jsp?seq=<%=dto.getSeq()%>'">
	
	</form>

</body>
</html>