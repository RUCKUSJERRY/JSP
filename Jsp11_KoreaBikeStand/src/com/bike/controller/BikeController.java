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
			// JSONParser 제이슨 형태의 문자열을 주면 이것을 JSON객체로 변환해 주겠다.
			// mydata로 가져온 JSON 형태의 문자열의 값을 emlement 제이슨 변수에 담는다. 
			// JsonElement : JsonObject, JsonArray, JsonPrimitive, JsonNull 값들을 모두 포함하는 개념, 
			// 제이슨 형태로 되어져 있는 모든 객체를 받아 줄수 있도록 구글에서 Jsonelement를 만듬.
			JsonObject jsonData = element.getAsJsonObject();
			// JsonObject : key=value pair ({"String" : "Jsonelement"} 형식)
			// JsonObject jsonData = JsonParser.parseString(data).getAsJsonObject(); 로 줄일 수 있다.
			
			JsonElement records = jsonData.get("records");
			// jsonDate에서 name이 records인 곳의 벨류 값들을 records 변수에 담는다.
			JsonArray recordsArray = records.getAsJsonArray();
			// 가져온 값들을 Json 배열로 담아준다.
			
			List<BikeDto> list = new ArrayList<BikeDto>();
			JsonArray resultArray = new JsonArray();
			
			for (int i = 0; i < recordsArray.size(); i++) {
			
				String name = recordsArray.get(i).getAsJsonObject().get("자전거대여소명").getAsString();
				/*
				 * JsonElement tempElement = recordsArray.get(i);
				 * tempObject tempObject = tempElement.getAsJsonObject();
				 * JsonElement nameElement = tempObject.get("자전거대여소명");
				 * String name = nameElement.getAsString();
				 */
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
				// Gson : 자바 객체를 JSON 표현으로 바꿀때, JSON String을 자바 객체로 바꿀때
				
				String jsonString = gson.toJson(dto);
				// dto 자바 오브젝트를 JSON String으로 바꾼다. gson이 가진 toJson이라는 메소드로
				resultArray.add(JsonParser.parseString(jsonString));
				 //jsonString을 Json 오브젝트로 형변환 
				
			}
			
			if (dao.insert(list)) {
				System.out.println("db 저장 성공");
				
			} else {
				System.out.println("db 저장 실패");
			}
			
			JsonObject result = new JsonObject(); //제이슨 객체 만들어서 
			result.add("result", resultArray); // String 값을 result에 넣어줌 
			
			response.getWriter().append(result+""); 
			//html 로 보냄 js 로 보낸다.
			
			
			
		}
		
	}

}
