package com.answer.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.answer.biz.AnswerBiz;
import com.answer.biz.AnswerBizImpl;
import com.answer.dto.AnswerDto;

@WebServlet("/AnswerController")
public class AnswerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AnswerController() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		AnswerBiz biz = new AnswerBizImpl();
		
		String command = request.getParameter("command");
				
		if (command.equals("list")) {
			List<AnswerDto> list = biz.selectList();
			
			request.setAttribute("list", list);
			
			dispatch(request, response, "boardlist.jsp");
			
			
		} else if (command.equals("detail")) {
			
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			
			AnswerDto dto = biz.selectOne(boardno);
			
			request.setAttribute("dto", dto);
			
			dispatch(request, response, "boardselect.jsp");
		} else if (command.equals("boardinsertform")) {
			
			response.sendRedirect("boardinsert.jsp");
			
		} else if (command.equals("boardinsert")) {
			
			
			
		} else if (command.equals("answerform")) {
			
			
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			
			AnswerDto dto = biz.selectOne(boardno);
			
			request.setAttribute("dto", dto);
			
			dispatch(request, response, "answerinsert.jsp");
	
			
		} else if (command.equals("answerwrite")) {
			
			int parentBoardNo = Integer.parseInt(request.getParameter("parentBoardNo"));
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			AnswerDto dto = new AnswerDto();
			dto.setBoardno(parentBoardNo);
			dto.setWriter(writer);
			dto.setTitle(title);
			dto.setContent(content);
			
			int res = biz.answerProc(dto);
			
			if (res > 0) {
				jsResponse(response, "answer.do?command=list", "답변 작성 완료");
			} else {
				jsResponse(response, "answer.do?command=answerform&boardno="+parentBoardNo, "답변 작성 실패");
			}
			
		}
		
		
		
		response.getWriter().append("<a href='index.jsp'><h1>잘못왔다.</h1></a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void dispatch(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
		
	}
	
	private void jsResponse(HttpServletResponse response, String url, String msg) throws IOException {
		
		String s = "<script type='text/javascript'>"
				 + "alert('" + msg + "');"
				 + "location.href='" + url + "';"
		         + "</script>";
			response.getWriter().print(s);

	}
	
}
