<%@page import="com.login.dto.MYMemberDto"%>
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
	MYMemberDto dto = (MYMemberDto) session.getAttribute("dto");

	if (dto == null) {
		pageContext.forward("index.html");
	}
	
%>

	<div>
		<h1><%=dto.getMyid() %>님 환영합니다.</h1>
		<a href="logincontroller.jsp?command=logout">logout</a>
	</div>
	
	<div>
		<div>
			<a href="logincontroller.jsp?command=updateuserform&myno=<%=dto.getMyno() %>">마이페이지</a>
		</div>
		<div>
			<a href="logincontroller.jsp?command=enablednuserform&myno=<%=dto.getMyno() %>">탈퇴하기</a>
		</div>
	</div>
	

</body>
</html>