<%@page import="com.myboard.dao.MyBoardDaoImpl"%>
<%@page import="com.myboard.dto.MyBoardDto"%>
<%@page import="com.myboard.dao.MyBoardDao"%>
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

<style type="text/css">
	
	table {
		text-align:center;
	}

</style>




</head>
<body>
<%

	int seq = Integer.parseInt(request.getParameter("seq"));
	MyBoardBiz biz = new MyBoardBizImpl();
	MyBoardDto dto = new MyBoardDto();
	dto = biz.selectOne(seq);

%>	



	<h1>게시글</h1>
	
	<table border="1">
		<col width="100px">
		<col width="100px">
		<col width="200px">
		<col width="100px">
		
	<tr>
		<td>글번호</td><td><%=seq %></td>
	</tr>
	<tr>
		<td>작성일자</td><td><%=dto.getRegdate() %></td>
	</tr>
	<tr>
		<td>작성자</td><td><%=dto.getWriter() %></td>
	</tr>
	<tr>
		<td>제목</td><td><%=dto.getTitle() %></td>
	</tr>
	<tr>
		<td>내용</td><td><textarea rows="10" cols="60"><%=dto.getContent() %></textarea></td>
	</tr>
	<tr>
		<td colspan="2" align="right">
		<input type="button" value="수정" onclick="location.href='myupdate.jsp?seq=<%= seq%>'">
		<input type="button" value="삭제" onclick="delcon();">
		<input type="button" value="목록" onclick="location.href='mylist.jsp'">
		</td>
	</tr>
	</table>
	
	<script type="text/javascript">

	function delcon() {
		
		var del;
		
		del=confirm("정말로 삭제하시겠습니까?");
		
		if(del) {
			location.href='mydelete.jsp?seq=<%= seq%>';
		} 
		
		
	}

</script>
	
</body>
</html>