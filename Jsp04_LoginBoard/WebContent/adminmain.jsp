<%

	response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-control", "no-store");
	response.setHeader("Expires", "0");

	/*
		
	뒤로가기 했을 때, 이전 화면이 보이는 이유
	-> 서버에서 문서를 받아오는 것이 아니라, 캐시에 저장된 값을 화면에 뿌려줌
	
	브라우저가 캐시에 응답결과(response)를 저장하지 않도록 설정
	
	response.setHeader("Pragma", "no-cache");			// http 1.0
	response.setHeader("Cache-control", "no-store");	// http 1.1
	response.setHeader("Expires", "0");					// proxy server
	
	우리는 : http 1.1
	
	*/

%>


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
			<a href="logincontroller.jsp?command=listall">회원 전체 조회(탈퇴한 회원 포함)</a>
		</div>
		<div>
			<a href="logincontroller.jsp?command=listenabled">회원 전체 조회(MYENABLED=Y)</a>
		</div>
	</div>
	

</body>
</html>