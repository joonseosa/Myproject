$(function(){
	$("#Btn").click(function(){
		var checkData = $("#checkData").val();
		if(checkData == ""){
			$("#msg").text("인증번호를 입력해주세요.");
		}else{
			$.ajax({
	    		type : "POST",
	    		url : "emailCheckData",
	    		data : {checkData : checkData},
	    		success: function(data){
	    				if(data[0] == "같음"){
	    					$("#mem_email", opener.document).text(data[1]);
	    					$("#emailUpdateBtnText", opener.document).text("이메일 변경");
	    					$(".emailChangeForm", opener.document).css("display","none");
	    					self.close();
	    				}else{
	    					$("#msg").text("인증코드가 맞지 않습니다.");
	    				}
	    		}
	    	});
		}
		
	});
	//새로고침 막기
	function doNotReload(){
	    if( (event.ctrlKey == true && (event.keyCode == 78 || event.keyCode == 82)) || (event.keyCode == 116) ) {
	        event.keyCode = 0;
	        event.cancelBubble = true;
	        event.returnValue = false;
	    } 
	}
	document.onkeydown = doNotReload;
});