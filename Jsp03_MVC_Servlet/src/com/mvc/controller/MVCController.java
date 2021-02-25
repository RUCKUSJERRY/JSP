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
	
	public void dispatch(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}
	
	private static final long serialVersionUID = 1L;
	MVCBiz biz = new MVCBizImpl();
    public MVCController() {
        super();
    }
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("command : " + command);
		
		if (command.equals("list")) {
			
			
			
			List<MVCDto> list = biz.selectList();
			
			request.setAttribute("list", list);
			
			dispatch(request, response, "list.jsp");
			
		} else if (command.equals("select")) {
			
			int seq = Integer.parseInt(request.getParameter("seq"));
			
			MVCDto dto = biz.selectOne(seq);
			
			request.setAttribute("dto", dto);
			
			dispatch(request, response, "select.jsp");
			
		} else if (command.equals("insertform")) {
			
			response.sendRedirect("insert.jsp");
			
		} else if (command.equals("insertres")) {
			
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			MVCDto dto = new MVCDto();
			dto.setWriter(writer);
			dto.setTitle(title);
			dto.setContent(content);
			
			int res = biz.insert(dto);
			
			PrintWriter out = response.getWriter();

			if (res > 0) {
				
				String html = 
						" <script type='text/javascript'> "
						+ "		alert('작성 완료')\n "
						+ "		location.href='controller.do?command=list' "
						+ "</script> ";
				
				out.println(html);			
				
			} else {
				
				String html = 
						" <script type='text/javascript'> "
						+ "		alert('작성 실패')\n "
						+ "		location.href='controller.do?command=insertform'; "
						+ "	</script>";
				
				out.println(html);
			}
			
		} else if (command.equals("updateform")) {
			
			int seq = Integer.parseInt(request.getParameter("seq"));
			
			MVCDto dto = biz.selectOne(seq);
			
			request.setAttribute("dto", dto);
			
			dispatch(request, response, "update.jsp");

		} else if (command.equals("updateres")) {
			
			int seq = Integer.parseInt(request.getParameter("seq"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			MVCDto dto = new MVCDto();
			dto.setSeq(seq);
			dto.setTitle(title);
			dto.setContent(content);
			
			int res = biz.update(dto);
			PrintWriter out = response.getWriter();

			if (res > 0) {
				
				String html = 
						" <script type='text/javascript'> "
						+ "		alert('수정 완료')\n"
						+ "		location.href='controller.do?command=select&seq=" + seq + "';"
						+ " </script> ";
				out.println(html);
				
				
			} else {
				
				String html = 
						" <script type='text/javascript'> "
						+ "		alert('수정 실패')\n "
						+ "		location.href='controller.do?command=updateform&seq=" + seq + "';"
						+ "	</script> " ;
				out.println(html);

			} 
			
		} else if (command.equals("deleteform")) {
			
			int seq = Integer.parseInt(request.getParameter("seq"));
			
			int res = biz.delete(seq);
			
			PrintWriter out = response.getWriter();
			if (res > 0) {
				
				String html = 
						  " <script type='text/javascript'> "
						+ "	alert('삭제 완료')\n "
						+ "	location.href='controller.do?command=list' "
						+ "	</script> ";
				
				out.println(html);
				
				
			} else {
				
				String html = 
						" <script type='text/javascript'> "
						+ "	alert('삭제 실패')\n "
						+ "	location.href='controller.do?command=select&seq=" + seq + "';"
						+ "	</script>";
				out.println(html);

			} 
			
		}
		
	}

}
