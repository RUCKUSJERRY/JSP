package com.answer.controller;

import java.io.IOException;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String command = request.getParameter("command");
		System.out.println(" [ " + command + " ] ");

		AnswerBiz biz = new AnswerBizImpl();

		if (command.equals("list")) {
			// 1. 가져올거 - 없음

			// 2. 넣어줄거 - 리스트
			List<AnswerDto> list = biz.selectList();

			// 3. 어트리뷰트에 넣어주기
			request.setAttribute("list", list);

			// 4. 전달해주기
			dispatch(request, response, "boardlist.jsp");

		} else if (command.equals("detail")) {

			// 1. 가져올거 - 번호
			int boardno = Integer.parseInt(request.getParameter("boardno"));

			// 2. 넣어줄거 - 셀렉트 원
			AnswerDto dto = biz.selectOne(boardno);

			// 3. 세팅
			request.setAttribute("dto", dto);

			// 4. 전달
			dispatch(request, response, "boardselect.jsp");

		} else if (command.equals("insertform")) {

			response.sendRedirect("boardinsert.jsp");

		} else if (command.equals("boardinsert")) {

			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");

			AnswerDto dto = new AnswerDto();
			dto.setTitle(title);
			dto.setWriter(writer);
			dto.setContent(content);

			boolean res = biz.boardInsert(dto);

			if (res) {
				jsResponse(response, "answer.do?command=list", "작성 완료");
			} else {
				jsResponse(response, "history.go(-1)", "작성 실패");
			}

		} else if (command.equals("answerform")) {

			// 1. 가져올거 - 번호
			int boardno = Integer.parseInt(request.getParameter("boardno"));

			// 2. 넣어줄거 - 셀렉트 원
			AnswerDto dto = biz.selectOne(boardno);

			// 3. 세팅
			request.setAttribute("dto", dto);

			// 4. 전달
			dispatch(request, response, "answerboard.jsp");

		} else if (command.equals("answerres")) {

			// 1. 가져올거
			int parentBoardNo = Integer.parseInt(request.getParameter("parentBoardNo"));
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");

			// 2. 넣어줄거
			AnswerDto dto = new AnswerDto();
			dto.setTitle(title);
			dto.setWriter(writer);
			dto.setContent(content);
			dto.setBoardno(parentBoardNo);

			int res = biz.answerProc(dto);

			if (res > 0) {
				jsResponse(response, "answer.do?command=list", "답변 작성 완료");
			} else {
				jsResponse(response, "history.go(-1)", "답변 작성 실패");
			}

		} else if (command.equals("updateform")) {
			
			// 1. 가져올거 - 번호
			int boardno = Integer.parseInt(request.getParameter("boardno"));

			// 2. 넣어줄거 - 셀렉트 원
			AnswerDto dto = biz.selectOne(boardno);

			// 3. 세팅
			request.setAttribute("dto", dto);

			// 4. 전달
			dispatch(request, response, "boardupdate.jsp");
			
		} else if (command.equals("boardupdate")) {
			
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			AnswerDto dto = new AnswerDto();
			dto.setTitle(title);
			dto.setContent(content);
			dto.setBoardno(boardno);
			
			boolean res = biz.boardUpdate(dto);
			
			if(res) {
				jsResponse(response, "answer.do?command=detail&boardno="+boardno, "수정 성공");
			} else {
				jsResponse(response, "history.go(-1)", "수정 실패");
			}
			
		} else if (command.equals("boarddelete")) {
			
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			
			boolean res = biz.boardDelete(boardno);
			
			if(res) {
				jsResponse(response, "answer.do?command=list", "삭제 성공");
			} else {
				jsResponse(response, "answer.do?command=detail&boardno="+boardno, "삭제 실패");
			}
			
		}

		response.getWriter().append("<a href='index.jsp'><h1>잘못왔다.</h1></a>");
	}

	private void dispatch(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {

		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);

	}

	private void jsResponse(HttpServletResponse response, String url, String msg) throws IOException {

		String s = "<script type='text/javascript'>" + "alert('" + msg + "');" + "location.href='" + url + "';"
				+ "</script>";
		response.getWriter().print(s);

	}

}
