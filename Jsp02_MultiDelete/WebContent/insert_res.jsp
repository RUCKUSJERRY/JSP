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


<body>

<%
	MDBoardDto dto = new MDBoardDto();
	MDBoardBiz biz = new MDBoardBizImpl();
	
	String writer = request.getParameter("writer");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	dto.setTitle(title);
	dto.setWriter(writer);
	dto.setContent(content);
	
	int res = 0;
	
	res = biz.insert(dto);
	
	if (res > 0) {

%>
	<script type="text/javascript">
		alert("작성 완료")
		location.href="boardlist.jsp"
	</script>
<%
	} else {
%>
	<script type="text/javascript">
		alert("작성 실패")
		location.href="insert.jsp"
	</script>
<%
	}
%>

</body>
</html>