<%@page import="com.board.dto.YJDto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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

<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	
	function allCheck(bool) {
		var chks = document.getElementsByName("chk");
		for (var i = 0; i < chks.length; i++) {
			chks[i].checked = bool;
		}
	}
	
$(function() {
	//muldelform이라는 아이디를 가진 태그에서 submit이벤트가 발생시 실행해주세요.
	$("#muldel").submit(function(){
		// 유효성 검사
		if ($("#muldel input:checked").length == 0) {
			alert("하나 이상 체크해 주세요");
			return false;
		}
	});
});

</script>

</head>




<%

	YJBiz biz = new YJBizImpl();
	List<YJDto> list = new ArrayList<YJDto>();
	list = biz.selectList();

%>

<body>

	<%@ include file="./form/header.jsp" %>
	
	<h1>list</h1>
	<form action="./muldel.jsp" method="get" id="muldel">
	<table border="1">
		<col width="30px">
		<col width="50px">
		<col width="150px">
		<col width="300px">
		<col width="100px">
		<tr>
			<td><input type="checkbox" name="all" onclick="allCheck(this.checked);"></td>	
			<td>번호</td>	
			<td>작성자</td>	
			<td>글제목</td>	
			<td>작성날짜</td>	
		</tr>
	
	<%
		if (list.size() == 0) {
	
	%>
		
		<tr>
			<td colspan="5">----------------------작성된 글이 없습니다.----------------------</td>	
		</tr>
	
		
	<%
		
		} else { 
			for(YJDto dto : list) {
							
	%>
		<tr>
			<td><input type="checkbox" name="chk" value="<%=dto.getSeq() %>"></td>	
			<td><%=dto.getSeq() %></td>
			<td><%=dto.getWriter() %></td>
			<td><a href="./select.jsp?seq=<%=dto.getSeq() %>"><%=dto.getTitle() %></a></td>
			<td><%=dto.getRegdate() %></td>
		</tr>
	<%
		
		}
			
		}
	%>
		<tr>
			<td colspan="5" align="right">
				<input type="submit" value="선택삭제">
				<input type="button" value="글작성" onclick="location.href='./insert.jsp'">
			
			</td>
		
		</tr>
		
		
		
	</table>
	</form>
		
	<%@ include file="./form/footer.jsp" %>
	

</body>
</html>