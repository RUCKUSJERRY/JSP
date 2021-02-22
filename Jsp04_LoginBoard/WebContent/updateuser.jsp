<%@page import="com.login.dto.MYMemberDto"%>
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

	MYMemberDto dto = (MYMemberDto) request.getAttribute("dto");
	
%>
	
	<h1>마이페이지</h1>
	

	
	<form action="logincontroller.jsp" method="post">
		<input type="hidden" name="command" value="updateuser" />
		<input type="hidden" name="myno" value="<%=dto.getMyno() %>" />
		<table border="1">	
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="myid" readonly="readonly" value="<%=dto.getMyid() %>"/>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="mypw"/>
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="myname" required="required" value="<%=dto.getMyname() %>" />
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>
					<input type="text" name="myaddr" required="required" value="<%=dto.getMyaddr() %>"/>
				</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>
					<input type="text" name="myphone" required="required" value="<%=dto.getMyphone() %>"/>
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>
					<input type="text" name="myemail" required="required" value="<%=dto.getMyemail() %>"/>
				</td>
			</tr>
			<tr>
				<th>탈퇴여부</th>
				<td>
					<%=dto.getMyenabled().equals("Y")?"사용중인유저":"탈퇴한유저" %>
				</td>
			</tr>
			<tr>
				<th>등급</th>
				<td>
					<%=dto.getMyrole() %>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="정보수정" />
					<input type="button" value="메인" onclick="location.href='logincontroller.jsp?command=usermain&myno=<%=dto.getMyno() %>'" /> 
				</td>
			</tr>
		</table>
	</form>


</body>
</html>