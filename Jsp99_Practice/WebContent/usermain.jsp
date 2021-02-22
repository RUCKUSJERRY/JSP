<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.test.biz.TBIzImpl"%>
<%@page import="com.test.biz.TBiz"%>
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
		vertical-align: middle;
		text-align: center;
		color: white;
	
	}
	
	nav span input:hover {
		text-decoration: underline;
		cursor: pointer;
	}
	
	nav span input {
		witdh: 100px;
		background-color: black;
		color: white;
		cursor: pointer;
	}
	
</style>
	
	<%
		TDto dto = (TDto) session.getAttribute("dto");
		
		TBiz biz = new TBIzImpl();
		
		List<TDto> list = new ArrayList<TDto>();
		list = biz.selectList();
		
	
	%>
	
<script type="text/javascript">

	function board() {
		
		location.href='';
		
	}
	
	function user() {
		
		location.href='boardcon.jsp?command=user&seq=<%=dto.getSeq()%>';
		
	}
	
	function mypage() {
		
		location.href='boardcon.jsp?command=mypage&seq=<%=dto.getSeq()%>';
		
	}
	
	function logout() {
		
		location.href='logincon.jsp?command=logout&seq=<%=dto.getSeq()%>';
			
	}
	
</script>

</head>
<body>

	
	
	<h1>TEST WORLD 메인 페이지</h1>
	
	<h2><%=dto.getName() %> (<%=dto.getId() %>) 님 어서오세요</h2>
	
	<nav>
		<span><input type="button" value ="게시판" onclick="location.href='boardcon.jsp?command=board'"></span>
		<span><input type="button" value ="회원관리" onclick="location.href='boardcon.jsp?command=userboard'"></span>
		<span><input type="button" value ="마이페이지" onclick="location.href='boardcon.jsp?command=mypage'"></span>
		<span><input type="button" value ="로그아웃" onclick="location.href='logincon.jsp?command=logout'"></span>
	</nav>
	
	<table border="1">
		
		
		
	</table>
	
	
	
</body>
</html>