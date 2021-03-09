package com.weather.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/weatherOpen")
public class WeatherOpenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String code = request.getParameter("code");
		request.setAttribute("code",code);
		RequestDispatcher rd = request.getRequestDispatcher("weatherInfo.jsp");
		rd.forward(request, response);
		// ajax에서 받은 code값을 weatherInfo.jsp로 보내서 그 결과값을 받아 ajax로 양방향 통신?? 리스기릿.
		/* 
		 *  weaterinfo.jsp
		 * c:catch try catch 같은 경우인 듯 예외 처리 
		   c:set 밸류 를 저장
		   c:import set의 경로의 값을 weather 변수로 임포트
		   x:parse weather의 값을 xml로 치환? 변환? 하는거 같음
		   x:out xml의 값을 내보낸다. 그래서 "pubDate같은 변수에 하나하나씩 담아주는 중"
		   c:if 기상청에서 가져온 주소에 대한 값이 null이 아니면 $err 변수에 해당 값들을 담아주겠다?
		*/
		
	}

}
