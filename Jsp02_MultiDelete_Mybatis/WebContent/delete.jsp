<%@page import="com.board.biz.YJBizImpl"%>
<%@page import="com.board.biz.YJBiz"%>
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
	
	int seq = Integer.parseInt(request.getParameter("seq"));
	int res = 0;
	
	YJBiz biz = new YJBizImpl();
	
	res = biz.delete(seq);
	
	if (res > 0) {
	
%>
	<script type="text/javascript">
		alert("삭제 완료")
		location.href="./list.jsp"
	</script>
<%
	} else {
%>
	<script type="text/javascript">
		alert("삭제 실패")
		location.href="select.jsp?seq=<%=seq%>"
	</script>
<%
	}
%>

</body>
</html>