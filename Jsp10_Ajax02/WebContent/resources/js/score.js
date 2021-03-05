
function getParameterValues() {
	
	var name = "name=" + encodeURIComponent(document.getElementById("name").value);
	var kor = "kor=" + document.getElementById("kor").value;
	var eng = "eng=" + document.getElementById("eng").value;
	var math = "math=" + document.getElementById("math").value;
	
	return "?" + name + "&" + kor + "&" + eng + "&" + math;
	
}

function load(){
	
	var url = "score.do"+getParameterValues();
	//alert(url);
	
	httpRequest = new XMLHttpRequest();					// server와 통신하는 것을 도와주는 객체
	httpRequest.onreadystatechange=callback;			// 처리할 함수
	httpRequest.open("GET", url, true); 				// true : 비동기 / false : 동기
	httpRequest.send();									// get : send() / post : send("data")
}

function callback() {
	
	alert("readystate : " + httpRequest.readyState);
	// readystate == 4 : 통신이 완료되었다면.
	if (httpRequest.readyState == 4) {
		alert("status : " + httpRequest.status);
		// 통신이 성공적으로 완료되었다면.
		if(httpRequest.status == 200) {
											// responseText : 요청후 응답받은 문자열
			var obj = JSON.parse(httpRequest.responseText);
			document.getElementById("result").innerHTML = decodeURIComponent(obj.name) + "의 총점 : " + obj.sum +
			"\n평균 : " + obj.avg;
		} else {
			alert("통신 실패");
		}
	}
	
}



/*
	XMLHttpRequest : javascript object, http를 통한 데이터 송수신 지원하는 자스오브젝트 객체
	
	<onreadystatechange>
	- readystate
		0: uninitialized - 실행(load)되지 않음
		1: loading - 로드 중
		2: loaded - 로드 됨
		3: interactive - 통신됨
		4: complete - 통신 완료
		
	- status
		200 : 성공
		400 : bad request
		401 : unauthorized
		403 : forbidden
		404 : not found
		415 : unsupported media type
		500 : internal server error
	
	**
	encodeURIComponent    : string, 인코딩된 문자열을 반환 ,URI의 특정한 문자를 UTF-8로 인코딩해 하나, 둘, 셋, 혹은 네 개의 연속된 이스케이프 문자로 나타냅니다
	encodeURIComponent()함수는 영 대문자와 소문자, 숫자, 그리고 *-_.을 제외한 모든 문자를 유니코드 형식으로 변환한다.
	decodeURIComponent    : string, 디코딩된 문자열 , (URI) 컴포넌트를 해독합니다
	encodeURI : 주소줄에서 사용되는 특수문자는 제외하고 인코딩
	
    JSON.parse            : string으로 응답받은 것을 json객체로 생성 (String -> json object)
    JSON.stringify        : JavaScript 값이나 객체를 JSON 문자열로 변환합니다 (object -> json string)
	
	- 동기 비동기
	동기방식은 설계가 매우 간단하고 직관적이지만 결과가 주어질 때까지 아무것도 못하고 대기해야 하는 단점이 있고, 

 	비동기방식은 동기보다 복잡하지만 결과가 주어지는데 시간이 걸리더라도 그 시간 동안 다른 작업을 할 수 있으므로 자원을 효율적으로 사용할 수 있는 장점이 있습니다.


*/
