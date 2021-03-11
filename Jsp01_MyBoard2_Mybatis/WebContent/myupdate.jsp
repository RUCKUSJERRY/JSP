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
MyBoardBiz biz = new MyBoardBizImpl();
MyBoardDto dto = new MyBoardDto();
dto = biz.selectOne(seq);

%>


	<form action="myupdate_res.jsp" method="post">
		<h1>수정하기</h1>
	
	<table border="1">
		<col width="100px">
		<col width="100px">
		<col width="200px">
		<col width="100px">
	<tr>
		<td>글번호</td><td><input type="text" name="seq" value="<%=dto.getSeq() %>" readonly="readonly"></td>
	</tr>		
	<tr>
		<td>작성자</td><td><input type="text" name="writer" value="<%=dto.getWriter() %>"></td>
	</tr>
	<tr>
		<td>제목</td><td><input type="text" name="title" value="<%=dto.getTitle() %>"></td>
	</tr>
	<tr>
		<td>내용</td><td><textarea rows="10" cols="60" name="content"><%=dto.getContent() %></textarea></td>
	</tr>
	<tr>
		<td colspan="2" align="right">
		<button>수정</button>
		<input type="button" value="취소" onclick="location.href='myselect.jsp?seq=<%= seq%>'">
		</td>
	</tr>
	</table>
	
	
	</form>

</body>
</html>