
$(function(){

	getJsonDate();
	
});

function getJsonDate(){
	// resources/json/bike.json 경로로 들어가서 function(mydata) 실행
	$.getJSON("resources/json/bike.json", function(mydata){
		$.ajax({
			// bike.do?command=getdata&my
			url: "bike.do",
			method: "post",
			data: {"command":"getdata", "mydata": JSON.stringify(mydata)},
			//JSON.stringify() 메서드는 JavaScript 값이나 객체를 JSON 문자열로 변환합니다
			// mydata:[{k:v},{k:v}...] 으로 JSON객체 문자열로 바꿈
			dataType: "json",
			success: function(msg){
				var $tbody = $("tbody");
				
				var list = msg.result;
				for (var i = 0; i < list.length; i++) {
					var $tr = $("<tr>");
					
					$tr.append($("<td>").append(list[i].name));
					$tr.append($("<td>").append(list[i].addr));
					$tr.append($("<td>").append(list[i].latitude));
					$tr.append($("<td>").append(list[i].longitude));
					$tr.append($("<td>").append(list[i].bike_count));
					
					$tbody.append($tr);
				}
			},
			error: function(){
				alert("통신 실패");
			}
			
		});
			
	});
	
};