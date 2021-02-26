package com.test.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/testController")
public class testController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public testController() {
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
		
		
		if (command.equals("update")) {
			
			int bid = Integer.parseInt(request.getParameter("bId"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			Board b = new Board();
			b.setTitle(title);
			b.setContent(content);
			b.setBid(bid);
			
			int res = biz.updateBoard(b);
			
			if (res > 0) {
				
				request.setAttribute("b", b);
				
				RequestDispatcher dispatch = request.getRequestDispatcher(request.getContextPath() + "/bdetail");
				dispatch.forward(request, response);
				
			} else {
				PrintWriter out = response.getWriter();
				String html =
						" <h1>게시글 수정 실패</h1> ";
				
				out.println(html);
				
				RequestDispatcher dispatch = request.getRequestDispatcher("views/common/errorPage.jsp");
				dispatch.forward(request, response);
			}
			
		}
		
		
		
	}

}
