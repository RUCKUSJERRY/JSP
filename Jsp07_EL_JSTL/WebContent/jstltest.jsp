<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- The JSTL tag library can be imported into your pages with the following directives:
	core 라이브러리 쓸려면 위에 태그를 사용해야한다. 톰캣에서 복사해오거나 어디 따로 저장해두거나.
 -->

<% request.setCharacterEncoding("UTF-8"); %>    
<% response.setContentType("text/html; charset=UTF-8"); %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>JSTL : Jsp Standard Tag Library</h1>
	
	<table border="1">
		<tr>
			<th>이름</th>
			<th>국어</th>
			<th>영어</th>
			<th>수학</th>
			<th>총점</th>
			<th>평균</th>
			<th>등급</th>
		</tr>

		<!-- eq: == / ne: != / empty: null -->
		<c:forEach items="${list }" var="score">
			<tr>
				<td>
				<c:if test="${score.name eq '이름10' }">
					<c:out value="홍길동"></c:out>
				</c:if>
				<c:choose>
					<c:when test="${score.name eq '이름20' }">
						<c:out value="${score.name }님!"></c:out>
					</c:when>
					<c:when test="${score.name eq '이름30' }">
						<c:out value="${score.name }님!"></c:out>
					</c:when>
					<c:otherwise>
						<c:out value="누구지?!"></c:out>
					</c:otherwise>
				</c:choose>
				</td>
				<td>${score.kor }</td>
				<td>${score.eng }</td>
				<td>${score.math }</td>
				<td>${score.sum}</td>
				<td>${score.avg }</td>
				<td>
					<c:choose>
						<c:when test="${score.grade eq 'A' || score.grade eq 'B' }">
							<c:out value="PASS"></c:out>
						</c:when>
						<c:otherwise>
							<c:out value="FALE"></c:out>
						</c:otherwise>
					</c:choose>
					
				</td>
			</tr>
		
		
		</c:forEach>
	</table>

	<c:forEach var="i" begin="1" end="10" step="1">
	
		${i }<br/>
	
	
	</c:forEach>

</body>
</html>