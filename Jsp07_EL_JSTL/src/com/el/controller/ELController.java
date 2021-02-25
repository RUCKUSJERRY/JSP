package com.el.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.el.dto.Score;

@WebServlet("/ELController")
public class ELController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ELController() {
        System.out.println("생성!");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
		// 1. 가져올 값
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("command : " + command);
				
		if (command.equals("el")) {
			response.sendRedirect("basic-arithmetic.jsp");
		} else if(command.equals("eltest")) {
			Score score = new Score("홍길동", 70, 80, 90);
			
			request.setAttribute("score", score);
			
			RequestDispatcher dispatch = request.getRequestDispatcher("eltest.jsp");
			dispatch.forward(request, response);
			
		} else if(command.equals("jstl")) {
			// key=command의 value가 hstl이라면~
			
			List<Score> list = new ArrayList<Score>();
			// 스코어 객체의 리스트를 만든다.
			
			for (int i = 10; i < 50; i += 10) {
				Score sc = new Score("이름"+i, 50+i, 50+i, 50+i);
				list.add(sc);
			}
			// 10,20,30,40 4번 반복해서 스코어 객체에 담은 다음 리스트에 추가해준다.
			
			request.setAttribute("list", list);
			// 리퀘스트 속성에 list라는 이름으로 저 리스트들을 담아준다. 이건 오브젝트~
			
			RequestDispatcher dispatch = request.getRequestDispatcher("jstltest.jsp");
			dispatch.forward(request, response);
			// 리퀘스트 디스페쳐로 위의 속성오브젝트를 jstltest.jsp로 위임(forward)해준다.
			
		} else if (command.equals("usebean")) {
			
			response.sendRedirect("usebean.jsp");
			
		}

	}

}
