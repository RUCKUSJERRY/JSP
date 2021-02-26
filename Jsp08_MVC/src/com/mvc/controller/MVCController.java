package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.biz.MVCBiz;
import com.mvc.biz.MVCBizImpl;
import com.mvc.dto.MVCDto;

@WebServlet("/MVCController")
public class MVCController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MVCBiz biz = new MVCBizImpl();
	
	public static void dispatch(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
		
	}
    public MVCController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("html/text; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println(" command : " + command);
		PrintWriter out = response.getWriter();
		if (command.equals("list")) {
			// 1. 받을거 X
			// 2. 가져올거 X
			// 3. 전달해줄거
			List<MVCDto> list = biz.selectList();
			
			request.setAttribute("list", list);
			
			// 4. 전달할곳
			dispatch(request, response, "mvclist.jsp");

		} else if (command.equals("select")) {
			
			int seq = Integer.parseInt(request.getParameter("seq"));
			MVCDto dto = biz.selectOne(seq);
			
			request.setAttribute("dto", dto);
			dispatch(request, response, "mvcselect.jsp");
			
		} else if (command.equals("insertform")) {
			
			response.sendRedirect("mvcinsert.jsp");
			
		} else if (command.equals("insertres")) {
			
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			MVCDto dto = new MVCDto();
			dto.setWriter(writer);
			dto.setTitle(title);
			dto.setContent(content);
			int res = biz.insert(dto);	
			
			if (res > 0) {
				response.sendRedirect("mvc.do?command=list");
//				String html = 
//						" <script type='text/javascript'> "
//						+ "		alert('작성 완료')\n "
//						+ "		location.href='mvc.do?command=list' "
//						+ " </script> ";
//						
//				out.println(html);	
				
			} else {
				response.sendRedirect("mvc.do?command=insertform");
//				String html = 
//						" <script type='text/javascript'> "
//						+ "		alert('작성 실패')\n "
//						+ "		location.href='mvc.do?command=insertform' "
//						+ "	</script>";
//				
//				out.println(html);	
			}
			
		} else if (command.equals("updateform")) {
			
			int seq = Integer.parseInt(request.getParameter("seq"));
			MVCDto dto = biz.selectOne(seq);
			
			request.setAttribute("dto", dto);
			dispatch(request, response, "mvcupdate.jsp");
			
		} else if (command.equals("updateres")) {
			
			int seq = Integer.parseInt(request.getParameter("seq"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			MVCDto dto = new MVCDto();
			dto.setSeq(seq);
			dto.setTitle(title);
			dto.setContent(content);
			
			int res = biz.update(dto);
			
			if (res > 0) {
				// forward를 하면 request가 계속 연결되어 있기 때문에 새로고침시 값이 계속 전달된다.
				response.sendRedirect("mvc.do?command=select&seq=" + seq);
				
//				String html = 
//						" <script type='text/javascript'> "
//						+ "		alert('수정 완료')\n "
//						+ "		location.href='mvc.do?command=select&seq"+seq+"'; "
//						+ " </script> ";
//						
//				out.println(html);	
				
			} else {
				
				response.sendRedirect("mvc.do?command=updateform.do&seq=" + seq);
//				String html = 
//						" <script type='text/javascript'> "
//								+ "		alert('수정 실패')\n "
//								+ "		location.href='mvc.do?command=updateform&seq=" + seq + "'; "
//								+ " </script> ";
//						
//				out.println(html);	
			}
			
		} else if (command.equals("delete")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			
			
			int res = biz.delete(seq);
			
			if (res > 0) {
				dispatch(request, response, "mvc.do?command=list");
			} else {
				dispatch(request, response, "mvc.do?command=select&seq=" + seq);
			}
			
		}
		
	}


}
