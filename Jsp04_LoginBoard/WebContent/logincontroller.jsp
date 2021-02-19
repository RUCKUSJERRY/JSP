<%@page import="com.login.dto.MYMemberDto"%>
<%@page import="com.login.biz.MYMemberBiz"%>
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

	String command = request.getParameter("command");
	System.out.println("[" + command + "]");
	
	MYMemberBiz biz = new MYMemberBiz();
	
	if (command.equals("login")) {
		
		String myid = request.getParameter("myid");
		String mypw = request.getParameter("mypw");
		
		MYMemberDto dto = biz.login(myid, mypw);
		
		if (dto != null) {
			// session scope에 객체 담기
			session.setAttribute("dto", dto);
			// 만료되는 시간 설정 (default: 30분)
			session.setMaxInactiveInterval(10 * 60);
			
			if (dto.getMyrole().equals("ADMIN")) {
				response.sendRedirect("adminmain.jsp");
			} else if (dto.getMyrole().equals("USER")) {
				response.sendRedirect("usermain.jsp");
			}
			
		} else {
%>		
		<script type="text/javascript">
			alert("로그인 실패")
			location.href="index.html"
		</script>

<%
		}
		
		
	} 

%>	
		



































































<h1 style="color:red;">잘못왔다...</h1>

</body>
</html>

