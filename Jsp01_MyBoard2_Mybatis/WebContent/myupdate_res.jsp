<%@page import="com.myboard.dto.MyBoardDto"%>
<%@page import="com.myboard.biz.MyBoardBizImpl"%>
<%@page import="com.myboard.biz.MyBoardBiz"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html;charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

	int seq = Integer.parseInt(request.getParameter("seq"));
	String writer = request.getParameter("writer");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	MyBoardBiz biz = new MyBoardBizImpl();
	MyBoardDto dto = new MyBoardDto();
	
	dto.setSeq(seq);
	dto.setWriter(writer);
	dto.setTitle(title);
	dto.setContent(content);
	
	int res = biz.update(dto);
	
	if (res > 0) {
%>	
	<script type="text/javascript">
	
		alert("수정 성공")
		location.href='myselect.jsp?seq=<%=dto.getSeq() %>';
	</script>
<%
	} else {
	
%>
	<script type="text/javascript">
	
		alert("수정 실패")
		location.href='myupdate.jsp?seq=<%=dto.getSeq() %>';
	</script>
<%
	}
%>


</body>
</html>