<%@page import="java.util.List"%>
<%@page import="com.login.dto.MYMemberDto"%>
<%@page import="com.login.biz.MYMemberBiz"%>
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
	System.out.println("[" + command + "]");
	
	MYMemberBiz biz = new MYMemberBiz();
	
	if (command.equals("login")) {
		
		String myid = request.getParameter("myid");
		String mypw = request.getParameter("mypw");
		
		MYMemberDto dto = biz.login(myid, mypw);
		
		if (dto != null) {
			// session scope에 객체 담기
			session.setAttribute("dto", dto);
			// 만료되는 시간 설정 (default: 30분)
			session.setMaxInactiveInterval(10 * 60);
			
			if (dto.getMyrole().equals("ADMIN")) {
				response.sendRedirect("adminmain.jsp");
			} else if (dto.getMyrole().equals("USER")) {
				response.sendRedirect("usermain.jsp");
			}
			
		} else {
%>		
		<script type="text/javascript">
			alert("로그인 실패")
			location.href="index.html"
		</script>

<%
		}
		
		
	} else if (command.equals("logout")) {
	
		// session scope에서 값 삭제 (만료)
		session.invalidate();
		response.sendRedirect("index.html");
		
	} else if (command.equals("listall")) {
		
		List<MYMemberDto> list = biz.selectAllUser();
		
		request.setAttribute("list", list);
		
		pageContext.forward("userlistall.jsp");
		
	}	else if (command.equals("listenabled")) {
		
		List<MYMemberDto> list = biz.selectEnabledUser();
		
		request.setAttribute("list", list);
		
		pageContext.forward("userlisten.jsp");
		
	}	else if (command.equals("updateroleform")) {
		
		int myno = Integer.parseInt(request.getParameter("myno"));
		
		MYMemberDto dto = biz.selectUser(myno);
		
		request.setAttribute("dto", dto);
		
		pageContext.forward("updaterole.jsp");
		
	}	else if (command.equals("updaterole")) {
		
		int myno = Integer.parseInt(request.getParameter("myno"));
		String myrole = request.getParameter("myrole");
		
		int res = biz.updateRole(myno, myrole);
		
		if (res > 0) {
%>
	
	<script type="text/javascript">
	
		alert("등급 변경 성공");
		location.href="logincontroller.jsp?command=listenabled";
	
	</script>

<%			
		} else {		
%>
		<script type="text/javascript">
	
		alert("등급 변경 실패");
		location.href="logincontroller.jsp?command=updateroleform&myno=<%=myno%>";
	
	</script>
<%

		}
		
	} else if (command.equals("registform")) {
		
		response.sendRedirect("regist.jsp");
		
	} else if (command.equals("idchk")) {
		
		String myid = request.getParameter("myid");
		
		MYMemberDto dto = biz.idCheck(myid);
		
		boolean idnotused = true;
		
		if (dto.getMyid() != null) {
			idnotused = false;
		}
		
		response.sendRedirect("idchk.jsp?idnotused="+idnotused);
		
	} else if (command.equals("insertuser")) {
		
		String myid = request.getParameter("myid");
		String mypw = request.getParameter("mypw");
		String myname = request.getParameter("myname");
		String myaddr = request.getParameter("myaddr");
		String myphone = request.getParameter("myphone");
		String myemail = request.getParameter("myemail");
		
		MYMemberDto dto = new MYMemberDto();
		dto.setMyid(myid);
		dto.setMypw(mypw);
		dto.setMyname(myname);
		dto.setMyaddr(myaddr);
		dto.setMyphone(myphone);
		dto.setMyemail(myemail);
		
		int res = biz.insertUser(dto);
		
		if (res > 0) {
			
		
%>
		<script type="text/javascript">
		
			alert("회원가입이 완료되었습니다.");
			location.href="index.html";
		
		</script>	
<%

		} else {

%>	
		<script type="text/javascript">
		
			alert("회원가입이 실패하였습니다.");
			location.href="logincontroller.jsp?command=registform";
			
		</script>	
<%

		}
		
	} else if (command.equals("updateuserform")) {
		
		int myno = Integer.parseInt(request.getParameter("myno"));
		
		MYMemberDto dto = biz.selectUser(myno);
		
		request.setAttribute("dto", dto);
		pageContext.forward("updateuser.jsp");
		
	} else if (command.equals("enablednuserform")) {
		
		int myno = Integer.parseInt(request.getParameter("myno"));

		int res = biz.deleteUser(myno);
		
		if (res > 0) {
%>
		<script type="text/javascript">
		
			alert("잘가세요.");
			location.href="index.html";
		
		</script>	
<%
		} else {
%>
		<script type="text/javascript">
		
			alert("못갑니다.");
			location.href="logincontroller.jsp?command=usermain&myno=<%=myno %>";
		
		</script>	
<%
		}
		
	} else if (command.equals("usermain")) {
		
		int myno = Integer.parseInt(request.getParameter("myno"));
		
		MYMemberDto dto = biz.selectUser(myno);
		
		request.setAttribute("dto", dto);
		pageContext.forward("usermain.jsp");
	
	} else if (command.equals("updateuser")) {
		
		int myno = Integer.parseInt(request.getParameter("myno"));
		String mypw = request.getParameter("mypw");
		String myname = request.getParameter("myname");
		String myaddr = request.getParameter("myaddr");
		String myphone = request.getParameter("myphone");
		String myemail = request.getParameter("myemail");

		MYMemberDto dto = new MYMemberDto();
		dto.setMyno(myno);
		dto.setMypw(mypw);
		dto.setMyname(myname);
		dto.setMyaddr(myaddr);
		dto.setMyphone(myphone);
		dto.setMyemail(myemail);
		
		int res = biz.updateUser(dto);
		
		if (res > 0) {	
%>

		<script type="text/javascript">
		
			alert("수정이 완료되었습니다.")
			location.href="logincontroller.jsp?command=usermain&myno=<%=dto.getMyno() %>"
		
		</script>	
		
<%
		} else {
%>
		<script type="text/javascript">
		
			alert("수정이 실패하였습니다.")
			location.href="logincontroller.jsp?command=updateuserform&myno=<%=dto.getMyno() %>"
		
		</script>	

<%
		}
		
	}
%>		
	
	
	
	
			
	
	

			
		
		
	
	
		



































































<h1 style="color:red;">잘못왔다...</h1>

</body>
</html>

