<%@page import="com.mvc.dto.MVCDto"%>
<%@page import="java.util.List"%>
<%@page import="com.mvc.biz.MVCBizImpl"%>
<%@page import="com.mvc.biz.MVCBiz"%>
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
	
	String command = request.getParameter("command");
	System.out.printf("[%s]\n", command);
	
	MVCBiz biz = new MVCBizImpl();
	
	// 요청한 명령을 확인한다.
	if (command.equals("list")) {
		// 1. 보내준 값이 있으면, 받는다.
		// 2. DB에 전달할 값이 있으면 전달하고
		// 	  없으면 없는대로 호출해서 리턴 받는다.
		List<MVCDto> list = biz.selectList();
		
		// 3. 화면에 전달할 값이 있으면, request 객체에 담아준다.
		request.setAttribute("list", list);
		
		// 4. 보낸다.
		pageContext.forward("list.jsp");
		
	} else if (command.equals("insertform")) {
		// 1.
		// 2.
		// 3.
		// 4.
			response.sendRedirect("insert.jsp");
		
		/*
			pageContext.forward() : 페이지 위임 (request, reponse 객체가 그대로 전달)
			response.sendRedirect() : 페이지 이동 (새로운 request, response 객체)
		*/
		
	} else if (command.equals("insertres")) {
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		MVCDto dto = new MVCDto();
		dto.setWriter(writer);
		dto.setTitle(title);
		dto.setContent(content);
		
		int res = 0;
		
		res = biz.insert(dto);
		
		if (res > 0) {
	%>
	<script type="text/javascript">
			alert("작성 완료")
			location.href="mycontroller.jsp?command=list";
		</script>
	<% 
		} else {	
	%>
	<script type="text/javascript">
			alert("작성 실패")
			
			location.href="mycontroller.jsp?command=insertform";
		</script>

	<%
			}
		
		} else if (command.equals("select")) {
			// 1. 보내준 값이 있으면, 받는다.
			int seq = Integer.parseInt(request.getParameter("seq"));	
			
			// 2. DB에 전달할 값이 있으면 전달하고
			// 	  없으면 없는대로 호출해서 리턴 받는다.
			MVCDto dto = new MVCDto();
			dto = biz.selectOne(seq);

			// 3. 화면에 전달할 값이 있으면, request 객체에 담아준다.
			request.setAttribute("dto", dto);
			
			// 4. 보낸다.
			pageContext.forward("select.jsp");

		} else if (command.equals("updateform")) {
			
			int seq = Integer.parseInt(request.getParameter("seq"));
			
			MVCDto dto = new MVCDto();
			dto = biz.selectOne(seq);
			
			request.setAttribute("dto", dto);
			
			pageContext.forward("update.jsp");
			
		} else if (command.equals("updateres")) {
			
			int seq = Integer.parseInt(request.getParameter("seq"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			MVCDto dto = new MVCDto();
			dto.setSeq(seq);
			dto.setTitle(title);
			dto.setContent(content);
			
			int res = 0;
			
			res = biz.update(dto);
			
			if (res > 0) {
				
	%>
	<script type="text/javascript">
			alert("수정 완료")
			location.href="mycontroller.jsp?command=select&seq=<%=dto.getSeq() %>";
		</script>
	<%
			} else {
	%>
	<script type="text/javascript">
			alert("수정 실패")
			location.href="mycontroller.jsp?command=updateform&seq=<%=dto.getSeq() %>";
		</script>
	<%
			}
		} else if (command.equals("deleteform")) {
			
			int seq = Integer.parseInt(request.getParameter("seq"));
			
			int res = 0;
			
			res = biz.delete(seq);
			
			if (res > 0) {
	%>
	<script type="text/javascript">
				alert("삭제 완료")
				location.href="mycontroller.jsp?command=list";
			</script>
	<% 
			} else {	
	%>
	<script type="text/javascript">
				alert("삭제 실패")
				location.href="mycontroller.jsp?command=deleteform";
			</script>

	<%
			}	
			
		}
	%>









</body>
</html>