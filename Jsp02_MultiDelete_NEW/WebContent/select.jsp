<%@page import="com.board.dto.YJDto"%>
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
	YJBiz biz = new YJBizImpl();
	YJDto dto = new YJDto();
	dto = biz.selectOne(seq);

%>


<script type="text/javascript">
	
	function delcon() {
		var con = confirm("정말 삭제하시겠습니까?")
		
		if (con) {
			
			location.href='./delete.jsp?seq=<%=seq %>'		
		} 
		
	}

</script>

	<h1>게시글내용</h1>
	
	<table border="1">
		<col width="100px">
		<col width="200px">
		
		<tr>
			<td>번호</td>
			<td><%=dto.getSeq() %></td>
		</tr>
		
		<tr>
			<td>작성자</td>
			<td><%=dto.getWriter() %></td>
		</tr>
		
		<tr>
			<td>글제목</td>
			<td><%=dto.getTitle() %></td>
		</tr>
		
		<tr>
			<td>내용</td>
			<td> <textarea cols="60" rows="10"><%=dto.getContent() %></textarea></td>
		</tr>
		
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="수정" onclick="location.href='./update.jsp?seq=<%=seq%>'">
				<input type="button" value="삭제" onclick="delcon();">
				<input type="button" value="목록" onclick="location.href='./list.jsp'">
			</td>
		</tr>
	
	</table>


</body>
</html>