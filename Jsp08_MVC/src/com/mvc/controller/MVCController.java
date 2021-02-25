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
						+ "		location.href='mvc.do?command=list' "
						+ " </script> ";
						
				out.println(html);	
				
			} else {
				
				String html = 
						" <script type='text/javascript'> "
						+ "		alert('작성 실패')\n "
						+ "		location.href='mvc.do?command=insertform'; "
						+ "	</script>";
				
				out.println(html);	
			}
			
		} else if (command.equals("updateform")) {
			
			
			
		}
		
	}
	
	public static void dispatch(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
		
	}

}
