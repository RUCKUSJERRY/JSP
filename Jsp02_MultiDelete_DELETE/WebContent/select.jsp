<%@page import="com.muldel.dto.MDBoardDto"%>
<%@page import="com.muldel.biz.MDBoardBizImpl"%>
<%@page import="com.muldel.biz.MDBoardBiz"%>
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

	MDBoardDto dto = new MDBoardDto();
	MDBoardBiz biz = new MDBoardBizImpl();
	
	dto = biz.selectOne(seq);
	
%>

<script type="text/javascript">

	function delcon() {
		
	
	var con = confirm("정말 삭제하시겠습니까?")
		
	if (con) {
		location.href="delete.jsp?seq=<%=dto.getSeq()%>";
	} else {
		location.href='select.jsp?seq=<%=dto.getSeq()%>';
	}
		
	}

</script>

<body>
	
	<h1><%=dto.getSeq() %> : <%=dto.getWriter() %></h1>
	
	<table border="1">
		<col width="50px">
		<col width="200px">
		<tr>
			<td>제목</td>
			<td><input type="text" value="<%=dto.getTitle() %>" readonly="readonly"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea rows="10" cols="60" readonly="readonly"><%=dto.getContent() %></textarea></td>
		</tr>
		<tr>	
			<td colspan="3" align="right">
			<input type="button" value="수정" onclick="location.href='update.jsp?seq=<%=dto.getSeq()%>'"/>
			<input type="button" value="삭제" onclick="delcon();"/>
			<input type="button" value="목록" onclick="location.href='boardlist.jsp'"/>
			</td>
		</tr>
		
	</table>
	
</body>
</html>