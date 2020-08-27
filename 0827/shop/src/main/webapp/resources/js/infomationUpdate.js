$(function(){
	//새로고침 막기
	function doNotReload(){
	    if( (event.ctrlKey == true && (event.keyCode == 78 || event.keyCode == 82)) || (event.keyCode == 116) ) {
	        event.keyCode = 0;
	        event.cancelBubble = true;
	        event.returnValue = false;
	    }
	}
	document.onkeydown = doNotReload;
	
	$("#emailUpdateBtnText").click(function(){
		var text = $("#emailUpdateBtnText").text();
		if(text == "이메일 변경"){
			$("#emailUpdateBtnText").text("변경 취소");
			$(".emailChangeForm").css("display","block");
		}else{
			$("#emailUpdateBtnText").text("이메일 변경");
			$(".emailChangeForm").css("display","none");
		}
	});
	$("#telUpdateBtnText").click(function(){
		var text = $("#telUpdateBtnText").text();
		if(text == "번호 변경"){
			$("#telUpdateBtnText").text("변경 취소");
			$(".phoneChangeForm").css("display","block");
		}else{
			$("#telUpdateBtnText").text("번호 변경");
			$(".phoneChangeForm").css("display","none");
		}
		
	});
	$(".email").keyup(function(){
		$("#emailMsg").text("");
	});
	$("#emailChange").click(function(){
		if($("#email_id").val() == ''){
			$("#emailMsg").text("이메일을 입력해주세요.");
		}else if($("#email_address").val() == ''){
			$("#emailMsg").text("이메일을 입력해주세요.");
		}else{
			var email = $("#email_id").val()+'@'+$("#email_address").val();
			$.ajax({
	    		type : "POST",
	    		url : "emailCheck",
	    		data : {email : email},
	    		success: function(data){
	    			if(data =="성공"){
	    				alert(data);
	    				window.open("emailCheck", "PopupWin", "width=550,height=170");
	    			}else{
	    				$(".message").html("비밀번호가 다릅니다.");
	    			}
	    		}
	    	});
		}
		return false;
	});
	$(".telUpdateBtnText").click(function(){
		if($("#tel1").val() == ""){
			$("#tel1").focus();
			$("#telMsg").text("번호를 입력하세요.");
		}else if($("#tel2").val() == ""){
			$("#tel2").focus();
			$("#telMsg").text("번호를 입력하세요.");
		}else if($("#tel3").val()==""){
			$("#tel3").focus();
			$("#telMsg").text("번호를 입력하세요.");
		}else{
			var tel = $("#tel1").val()+"-"+$("#tel2").val()+"-"+$("#tel3").val();
			alert(tel);
			$.ajax({
	    		type : "POST",
	    		url : "telUpdate",
	    		data : {tel : tel},
	    		success: function(data){
	    			$("#mobileNum").text(data);
    				$("#telUpdateBtnText").text("번호 변경");
    				$(".phoneChangeForm").css("display","none");
	    		}
	    	});
		}
		
		return false;
	});
	$("#udatePwdBtn").click(function(){
		var currentPwSize =$("#currentPw").val().length;
		var changePw1 =$("#changePw1").val().length;
		var changePw2 =$("#changePw2").val().length;
		var pwCheck = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,20}$/;
		
		var currentPw = $("#currentPw").val();
		var changePw1 =$("#changePw1").val();
		var changePw2 =$("#changePw2").val()

		var password = 'password1';
		console.log(pwCheck .test(password));

//		alert(pwCheck.test(current));
		
		if($("#currentPw").val() == ""){
			$("#pwMsg").css("color","red");
			$("#pwMsg").text("비밀번호를 입력해주세요");
			$("#currentPw").focus();
		}else if($("#changePw1").val() == ""){
			$("#pwMsg").css("color","red");
			$("#pwMsg").text("비밀번호를 입력해주세요");
			$("#changePw1").focus();
		}else if(!pwCheck.test(changePw1)){
			$("#pwMsg").css("color","red");
			$("#pwMsg").text("최소 8 자,20자이하이며 하나의 문자 및 하나의 숫자를 입력해주세요.");
			$("#changePw1").focus();
		}else if($("#changePw2").val() == ""){
			$("#pwMsg").css("color","red");
			$("#pwMsg").text("비밀번호를 입력해주세요");
			$("#changePw2").focus();
		}else if(!pwCheck.test(changePw2)){
			$("#pwMsg").css("color","red");
			$("#pwMsg").text("최소 8 자,20자이하이며 하나의 문자 및 하나의 숫자를 입력해주세요.");
			$("#changePw2").focus();
		}else if($("#changePw2").val() != $("#changePw1").val()){
			$("#pwMsg").css("color","red");
			$("#pwMsg").text("변경할 비밀번호가 일치하지 않습니다.");
			$("#changePw2").focus();
		}else if($("#changePw1").val() == $("#currentPw").val()){
			$("#pwMsg").css("color","red");
			$("#pwMsg").text("현재 비밀번호와 같습니다");
		}else{
			var currentPw = $("#currentPw").val();
			var changePw1 = $("#changePw1").val();
			var changePw2 = $("#changePw2").val();
			$.ajax({
	    		type : "POST",
	    		url : "pwChange",
	    		data : {currentPw : currentPw, changePw1 : changePw1, changePw2:changePw2},
	    		success: function(data){
	    			if(data=="같음"){
	    				$("#pwMsg").css("color","green");
	    				$("#pwMsg").text("비밀번호 변경 성공");
	    			}
	    		}
	    	});
		}
		return false;
	});
	$(".addressUpdateBtnText").click(function(){
		var zipcode = $("#zipcode").val();
		var address1 = $("#address1").val();
		var address2 = $("#address2").val();
		if($("#zipcode").val() == "" && $("#address1").val()){
			$(".addressMsg").css("color","red");
			$(".addressMsg").text("우편번호를 검색해주세요.");
		}else if($("#address2").val() == ""){
			$(".addressMsg").css("color","red");
			$(".addressMsg").text("상세주소를 입력해주세요.");
		}else{
			$.ajax({
				type : "POST",
	    		url : "addressChange",
	    		data : {mem_zipcode : zipcode, mem_address : address1, mem_address_detail : address2},
	    		success: function(data){
	    			if(data=="성공"){
	    				$(".addressMsg").css("color","green");
	    				$(".addressMsg").text("주소가 변경되었습니다.");
	    			}else{
	    				$(".addressMsg").css("color","red");
	    				$(".addressMsg").text("주소변경이 실패되었습니다.");
	    			}
	    		}
			});
		}
	});
	$("#currentPw").keyup(function(){
		$("#pwMsg").text("");
	});
	$("#changePw1").keyup(function(){
		$("#pwMsg").text("");
	});
	$("#changePw2").keyup(function(){
		$("#pwMsg").text("");
	});
	$("#tel1").keyup(function(){
		$(this).val($(this).val().replace(/[^0-9]/gi,""));
		$("#telMsg").text("");
		$(this).val($(this).val().substring(0, 3));
	})
	$("#tel2").keyup(function(){
		$(this).val($(this).val().replace(/[^0-9]/gi,""));
		$("#telMsg").text("");
		$(this).val($(this).val().substring(0, 4));
	})
	$("#tel3").keyup(function(){
		$(this).val($(this).val().replace(/[^0-9]/gi,""));
		$("#telMsg").text("");
		$(this).val($(this).val().substring(0, 4));
	})
});
function zipCheck() {
    new daum.Postcode(
            {
                oncomplete : function(data) {
                    // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
                    // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                    // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                    var fullAddr = ''; // 최종 주소 변수
                    var extraAddr = ''; // 조합형 주소 변수

                    // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                    if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                        fullAddr = data.roadAddress;

                    } else { // 사용자가 지번 주소를 선택했을 경우(J)
                        fullAddr = data.jibunAddress;
                    }

                    // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                    if (data.userSelectedType === 'R') {
                        //법정동명이 있을 경우 추가한다.
                        if (data.bname !== '') {
                            extraAddr += data.bname;
                        }
                        // 건물명이 있을 경우 추가한다.
                        if (data.buildingName !== '') {
                            extraAddr += (extraAddr !== '' ? ', '
                                    + data.buildingName : data.buildingName);
                        }
                        // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                        fullAddr += (extraAddr !== '' ? ' (' + extraAddr
                                + ')' : '');
                    }
                    // 우편번호와 주소 정보를 해당 필드에 넣는다.
                    document.getElementById('zipcode').value = data.zonecode; //5자리 새우편번호 사용
                    document.getElementById('address1').value = fullAddr;
                    // 커서를 상세주소 필드로 이동한다.
                    document.getElementById('address2').focus();
                }
            }).open();
}