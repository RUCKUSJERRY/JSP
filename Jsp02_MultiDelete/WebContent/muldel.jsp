<%@page import="com.board.biz.YJBizImpl"%>
<%@page import="com.board.biz.YJBiz"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8");%>    
<% response.setContentType("text/html; charset=UTF-8");%>    
        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	// chk=1&chk=2 ... 같은 이름으로 여러개의 값이 전달되고 있을때 사용
	String[] seqs = request.getParameterValues("chk");

	if (seqs == null || seqs.length == 0) {
		
%>
	<script type="text/javascript">
		alert("삭제할 글을 선택해 주세요!");
		location.href="list.jsp";
	</script>
<%
	} else {
		YJBiz biz = new YJBizImpl();
		int res = 0;
		res = biz.muldel(seqs);
		if (res > 0) {
%>
		<script type="text/javascript">
	 	alert("체크된 글들을 삭제 성공 하였습니다.");
		location.href="list.jsp";
		</script>
<%
	} else {

%>
		<script type="text/javascript">
	 	alert("체크된 글들을 삭제 실패 하였습니다.");
		location.href="list.jsp";
		</script>
<%
	}
		
	}
%>

</body>
</html>