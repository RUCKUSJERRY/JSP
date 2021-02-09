<%@page import="com.myboard.dto.MyBoardDto"%>
<%@page import="com.myboard.dao.MyBoardDao"%>
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
	// 	request.getParameter(key) : queryString으로 넘어온 key=value 의 형태에서, 넣어준 key에 맞는 value return
	int myno = Integer.parseInt(request.getParameter("myno"));
	// 클라이언트에서 서버로 요청할때, 서버에서 클라이언트로 응답할때 넘어가는 모든 데이터는 String 문자열이다.

	MyBoardDao dao = new MyBoardDao();
	MyBoardDto dto = dao.selectOne(myno);


%>

<script type="text/javascript">

	function deleteconfirm() {
		if (confirm("정말로 삭제 하시겠습니까?")) {
			location.href='mydelete.jsp?myno=<%=dto.getMyno() %>';
		} else {
			location.href='mylist.jsp';
		}
	}
		 
</script>

<h1>상세 글 보기</h1>

<table border="1">
	<tr>
		<th>작성자</th>
		<td><%=dto.getMyname() %></td>
	</tr>
		<tr>
		<th>제목</th>
		<td><%=dto.getMytitle() %></td>
	</tr>
		<tr>
		<th>내용</th>
		<td>
		<textarea rows="10" cols="60" readonly="readonly"><%=dto.getMycontent() %></textarea>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="right">
			<input type="button" value="수정" onclick="location.href='myupdate.jsp?myno=<%=dto.getMyno() %>'"/>
			<input type="button" value="삭제" onclick="deleteconfirm();"/>
			<input type="button" value="목록" onclick="location.href='mylist.jsp'"/>
		</td>
	
	</tr>
	

</table>


</body>
</html>