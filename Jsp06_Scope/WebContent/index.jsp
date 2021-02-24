<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<% request.setCharacterEncoding("EUC-KR"); %>    
<% response.setContentType("text/html; charset=EUC-KR"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%

	pageContext.setAttribute("pageId", "my pageContext value");
	request.setAttribute("requestId", "my request value");
	session.setAttribute("sessionId", "my session value");
	application.setAttribute("applicationId", "my application value");

%>

	<h1>INDEX</h1>
	
	pageId : <%=pageContext.getAttribute("pageId") %><br/>
	requestId : <%=request.getAttribute("requestId") %><br/>
	sessionId : <%=session.getAttribute("sessionId") %><br/>
	applicationId : <%=application.getAttribute("applicationId") %><br/>

	

	<a href="result.jsp">result</a>
	
	<form action="scope.do" method="post">
	<input type="hidden" name="myrequest" value="my request value 2" >
	<input type="hidden" name="mysession" value="my session value 2" >
	
		<input type="submit" value="controller">
	
	</form>
	
	<% // pageContext.forward("scope.do"); %>
	
	

</body>
</html>