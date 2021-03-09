$(function() {
	$("#weaView").click(
			function() {
				var url = "weatherOpen";
				var code = $("#address option:selected").val();
				// 주소 선택
				$.ajax({
					type : "GET",
					url : url + "?code=" + code,
					// weatherOpen?code=주소의 value 근데 왜 do를 안쓰지??? 이건 모르겠다. get이라??아닌데...
					dataType : "text",
					// 확장자는 text이다.
					success : function(data) {
						// success : function(data) 통신이 성공하면 weatherInfo.jsp의 결과값을 파라미터로 받는다.
						var temp = $.trim(data);
									// var temp = $.trim(data); 문자열의 처음과 끝에서 공백제거?? 왜 하는지는 모르겠음.
						var obj = JSON.parse(temp);
									// var obj = JSON.parse(temp); obj에 JSON 문자열의 구문을 분석한 javaScript의 값이나 객체를 생성
						
						$("#pubDate").val(obj.pubDate);
						$("#temp").val(obj.temp);
						$("#x").val(obj.x);
						$("#y").val(obj.y);
						$("#reh").val(obj.reh);
						$("#pop").val(obj.pop);
						$("#wfKor").val(obj.wfKor);

						var weather_condition = obj.wfKor;
						// 날씨의 컨디션에 값에 따라 아래 경로에 사진파일을 다르게 설정해준다. 각각.
						if (weather_condition == "맑음"){
							$("#weather_img").attr("src","/Jsp12_Weather/image/sun.png");
						}else if (weather_condition == "비"){
							$("#weather_img").attr("src","/Jsp12_Weather/image/rain.png");
						}else if (weather_condition == "눈"){
							$("#weather_img").attr("src","/Jsp12_Weather/image/snow.png");
						}else if (weather_condition == "흐림"){
							$("#weather_img").attr("src","/Jsp12_Weather/image/cloud.png");
						}else if (weather_condition == "구름 조금"){
							$("#weather_img").attr("src","/Jsp12_Weather/image/cloud_sun.png");
						}else{
							$("#weather_img").attr("src","/Jsp12_Weather/image/etc.png");
						}
					},
					error : function() {
						alert("정보를 불러오는데 실패하였습니다.");
					}
				});
			});
});
