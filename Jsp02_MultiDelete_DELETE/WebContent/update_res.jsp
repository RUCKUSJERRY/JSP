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
	MDBoardDto dto = new MDBoardDto();
	MDBoardBiz biz = new MDBoardBizImpl();
	
	int seq = Integer.parseInt(request.getParameter("seq"));
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	dto.setSeq(seq);
	dto.setTitle(title);
	dto.setContent(content);
	
	int res = 0;
	
	res = biz.update(dto);
	
	if (res > 0) {

%>
	<script type="text/javascript">
		alert("수정 완료")
		location.href="boardlist.jsp"
	</script>
<%
	} else {
%>
	<script type="text/javascript">
		alert("수정 실패")
		location.href="insert.jsp"
	</script>
<%
	}
%>
</html>