<%@page import="com.board.biz.YJBizImpl"%>
<%@page import="com.board.dto.YJDto"%>
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
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int res = 0;
	
		YJBiz biz = new YJBizImpl();
		YJDto dto = new YJDto();
		
		dto.setSeq(seq);
		dto.setTitle(title);
		dto.setContent(content);
		
		res = biz.update(dto);
		
		if (res > 0) {
	
	%>
		<script type="text/javascript">
		
			alert("수정 완료");
			location.href="./list.jsp";
		
		</script>
	<%
		} else {
	%>
		<script type="text/javascript">
		
			alert("수정 실패");
			location.href="./update.jsp";
		
		</script>
	<%
		
		}
		
	%>

</body>
</html>