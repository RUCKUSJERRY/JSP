package com.bike.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import com.bike.dao.BikeDao;
import com.bike.dto.BikeDto;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@WebServlet("/BikeController")
public class BikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BikeController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println(" [ " + command + " ] ");
		
		if (command.equals("view")) {
			response.sendRedirect("view.html");
		} else if (command.equals("getdata")) {
			BikeDao dao = new BikeDao();
			
			if (dao.delete()) {
				System.out.println("db 초기화 성공");
			} else {
				System.out.println("db 초기화 실패");
			}
			
			String data = request.getParameter("mydata");
			
			JsonElement element = JsonParser.parseString(data);
			// mydata
			JsonObject jsonData = element.getAsJsonObject();
			
			JsonElement records = jsonData.get("records");
			// 
			JsonArray recordsArray = records.getAsJsonArray();
			
			List<BikeDto> list = new ArrayList<BikeDto>();
			JsonArray resultArray = new JsonArray();
			
			for (int i = 0; i < recordsArray.size(); i++) {
				String name = recordsArray.get(i).getAsJsonObject().get("자전거대여소명").getAsString();
				String addr = null;
				 
				if (recordsArray.get(i).getAsJsonObject().get("소재지도로명주소") != null) {
					addr = recordsArray.get(i).getAsJsonObject().get("소재지도로명주소").getAsString();
				} else {
					addr = recordsArray.get(i).getAsJsonObject().get("소재지지번주소").getAsString();
				}
				
				double latitude = recordsArray.get(i).getAsJsonObject().get("위도").getAsDouble();
				double longitude = recordsArray.get(i).getAsJsonObject().get("경도").getAsDouble();
				
				int bike_count = recordsArray.get(i).getAsJsonObject().get("자전거보유대수").getAsInt();
				
				BikeDto dto = new BikeDto(name, addr, latitude, longitude, bike_count);
				list.add(dto);
				
				Gson gson = new Gson();
				
				String jsonString = gson.toJson(dto);
				resultArray.add(JsonParser.parseString(jsonString));
				 //json객체를 object >>  jsonString으로 형변환 
				
			}
			
			if (dao.insert(list)) {
				System.out.println("db 저장 성공");
				
			} else {
				System.out.println("db 저장 실패");
			}
			
			JsonObject result = new JsonObject(); //제이슨 객체 만들어서 
			result.add("result", resultArray); // String 값을 result에 넣어줌 
			
			response.getWriter().append(result+""); //html 로 보냄 js 로 보낸다.
			
			
			
		}
		
	}

}
