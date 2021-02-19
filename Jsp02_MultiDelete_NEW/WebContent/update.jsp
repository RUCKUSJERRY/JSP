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

<%
	
	int seq = Integer.parseInt(request.getParameter("seq"));
	YJBiz biz = new YJBizImpl();
	YJDto dto = new YJDto();
	
	dto = biz.selectOne(seq);

%>

<body>

	<h1>수정하기</h1>
	
	<form action="./update_res.jsp" method="post">
		<table border="1">
			<col width="100px">
			<col width="200px">
			<tr>
				<td>번호</td>
				<td><input type="text" name="seq" value="<%=dto.getSeq()%>" readonly="readonly"/></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer" value="<%=dto.getWriter()%>" readonly="readonly"/></td>
			</tr>
			<tr>
				<td>글제목</td>
				<td><input type="text" name="title" value="<%=dto.getTitle()%>"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea cols="60" rows="10" name="content"><%=dto.getContent()%></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="수정하기">
					<input type="button" value="취소하기" onclick="location.href='./select.jsp?seq=<%=dto.getSeq()%>'">
				</td>
			</tr>
		</table>
	
	
	</form>

</body>
</html>