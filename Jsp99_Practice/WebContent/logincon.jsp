<%@page import="com.test.dto.TDto"%>
<%@page import="com.test.biz.TBIzImpl"%>
<%@page import="com.test.biz.TBiz"%>
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
		System.out.println("[" + command + "]" );
	
		TBiz biz = new TBIzImpl();
		
		if(command.equals("login")) {
			
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			System.out.println(id + " : "+ pw);
			
			TDto dto = biz.loginUser(id, pw);
			
			if (dto != null) {
				// session scope에 객체 담기
				session.setAttribute("dto", dto);
				// 만료되는 시간 설정 (default: 30분)
				session.setMaxInactiveInterval(10 * 60);
				
				if (dto.getRole().equals("ADMIN")) {
					response.sendRedirect("adminmain.jsp");
				} else if (dto.getRole().equals("USER")) {
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
		
		

	
</body>
</html>