function check(){
	
	//아이디체크
	// 영문 대문 소문 숫자로 시작하는 아이디 끝날때 제한없음
	var uid = document.getElementById("id").value;
	var idReg=  /^[A-za-z0-9]+$/;  
	
	
	if(uid=="test"){
		alert("아이디 중복 ");
	}
	else if(uid==""){
		alert("아이디를 입력하세요");
	}
	
	else if(!idReg.test(uid)){
		alert("영어나 숫자만 입력가능");	
	}
	
	else{
		alert("올바른 아이디입니다");
	}
}

//비번체크&이메일 체크 
//var pw = document.getElementById("pw").value;   "pw" 는 아이디 명 
//return false 는 submit 을 못넘어가게함 
function pwCheck(){
	//비번
	var pw = document.getElementById("pw").value;
	var pw2 = document.getElementById("pw2").value;

	//이름 
	var nm = document.getElementById("nm").value;
   var nmChk =  /^[가-힣a-zA-Z]{2,5}$/;


	
	
	//이메일  
	var em1 = document.getElementById("em1").value;
	var em2 = document.getElementById("em2").value;
	var em3 =  /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;

	//  var email= 
	//.focus(); 커서 옆칸으로 이동됨 
	// 라디오버튼 라벨로 묶으면 텍스트 눌러도 선택됨 
	//주민번호에 input type = "hidden"
	
	
	
	
	//조건문시작
	
	//비번 확인
	if(pw==""){
		alert("비밀번호를 입력하세요");
		return false;
	}
	else if(pw!=pw2){
		alert("비밀번호가 일치하지않습니다");
		return false;
	}

	
	//이름 확인
	 if(nm==""){
		alert("이름을 입력하세요");
		return false;
	}
	
	
	else if(!nmChk.test(nm)){
		alert("이름 5글자 초과");
		return false;
	}
	
	
	
	//이메일 확인
	 if(em1==""){
		alert("이메일을 입력하세요");
		return false;
	}
	else if(em2==""){
		alert("이메일을 입력하세요  ex) @naver.com");
		return false;
	}
	 
	else if(!em3.test(em2)){
		alert("올바른 입력형식이 아닙니다");
		return false;
	}
	
	else{
		alert("정상이메일 확인");
	}
	
	 // var a= regType1.match("123")  // 비교값을 그대로 사용  true 비교값 사용 false면 널값 들어옴  그값을 그대로 사용할경우 
	//this 는 내가 입력하고있는것만 선택   , .slice .substr 차이  짜르는방식 차이있음 slice 3~5 까지 substr 3번째 이후에 5개  

	
	 
	 
}





	
