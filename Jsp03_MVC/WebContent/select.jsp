<%@page import="com.mvc.dto.MVCDto"%>
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

	MVCDto dto = (MVCDto) request.getAttribute("dto");
	

%>

<script type="text/javascript">
	
	function delcon() {
		
		var con = confirm("정말로 삭제하시겠습니까?")
		
		if (con) {
			
			location.href='mycontroller.jsp?command=deleteform&seq=<%=dto.getSeq() %>'
			
		}
		
	}
	

</script>

	<table border="1">
		
		<tr>
			<th>번호</th>
			<td><%=dto.getSeq() %></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><%=dto.getWriter() %></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><%=dto.getTitle() %></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="10" cols="60" readonly="readonly"><%=dto.getContent() %></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="수정" onclick="location.href='mycontroller.jsp?command=updateform&seq=<%=dto.getSeq() %>'">
				<input type="button" value="삭제" onclick="delcon();">
				<input type="button" value="목록" onclick="location.href='mycontroller.jsp?command=list'">
			</td>
		</tr>
	
	</table>

</body>
</html>