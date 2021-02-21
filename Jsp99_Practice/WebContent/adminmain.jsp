<%@page import="com.test.dto.TDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>    
<% response.setContentType("text/html; charset=UTF-8"); %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	
	nav {
		
		border: 1px solid black;
		witdh: 1000px;
		height: 50px;
		display: inline-block;
		background-color: aqua;
		vertical-align: middle;
		text-align: center;
	}
	
	nav span {
		top: 15px;
		padding-left: 15px;
		padding-right: 15px;
		padding-top:5px;
		padding-bottom:5px;
		
		margin-left: 15px;
		margin-right: 15px;
		
		position: relative;
		witdh: 100px;
		height: 30px;
		border: 1px solid black;
		vertical-align: middle;
		text-align: center;
		background-color: black;
		color: white;
		cursor: pointer;
	
	}
	
	nav span:hover {
		text-decoration: underline;
		cursor: pointer;
	}
	
</style>

<script type="text/javascript">

	

</script>

</head>
<body>
	
	<%
		TDto dto = (TDto) session.getAttribute("dto");	
	%>
	
	<h1>TEST WORLD 관리자 페이지</h1>
	
	<h2><%=dto.getName() %> (<%=dto.getId() %>) 님 어서오세요</h2>
	
	<nav>
		<span><input type="button" value ="게시판" onclick="location.href='boardcon.jsp?command=board'"></span>
		<span><input type="button" value ="회원관리" onclick="location.href='boardcon.jsp?command=userboard'"></span>
		<span><input type="button" value ="마이페이지" onclick="location.href='boardcon.jsp?command=mypage'"></span>
		<span><input type="button" value ="로그아웃" onclick="location.href='boardcon.jsp?command=logout'"></span>
	</nav>
	
	
	
</body>
</html>