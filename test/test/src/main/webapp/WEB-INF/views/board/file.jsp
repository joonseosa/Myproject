<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<script>
$(function(){
	//change 이벤트는 요소(element)의 값이 변경될 때 발생

	$("input[name=file]").change(function(){
    var fileInput = $(this);
	
    //this는 내가 선택한것  , input type 에 name 이 file 인것 
   	// ext 가 확장자 
    
   	//확장자 추출하는 부분임 
   	// .val(); 값을 가져온다  , .split 나눠서 배열로 갖고온다 .pop는 추출 , tolowerCase 는 소문자 변환
    var ext = $(this).val().split(".").pop().toLowerCase();
    
    // ==-1 이면 없다는 뜻. 
    //확장자가  이미지 가 아닐때 라는뜻 
    if($.inArray(ext,["gif","jpg","jpeg","png","bmp"]) == -1) {
        alert("gif, jpg, jpeg, png, bmp 파일만 업로드 해주세요.");
        $("input[id=file1]").val("");
        return;
    }
    
   
    //1개만 첨부해도 0번째 
    var file  = this.files[0];
    
    //임시 url 읽어오기 
    var _URL = window.URL || window.webkitURL;
    
    
    var img = new Image();
    
   //임의 url을 file에 낳어준다
    img.src = _URL.createObjectURL(file);
    
   //로드가 되면 function 발생 
   img.onload = function() {
        
        if(img.width > 300 || img.height > 300) {
            alert("이미지 가로 300px, 세로 300px로 맞춰서 올려주세요.");
            fileInput.val("");
       		 } 
   	 	}
	});


})	




</script>

</head>
<body>
		<!--내가 한거   -->
<!--     <form name="fileForm" action="requestupload2" method="post" enctype="multipart/form-data">
        <input multiple="multiple" type="file" name="file1" id="file1" accept="image/*" />
        <input multiple="multiple" type="file" name="file2" id="file2" accept="image/*" />
        <input multiple="multiple" type="file" name="file3" id="file3" accept="image/*"/>
        <input type="text" name="src" />
    </form>
 -->        
        
        
        
        <!-- 팀장님 설명  -->
<!--          enctype ="multipart/form-data" 설정은 필수	 -->
        <form action="fileUp" method="post" enctype="multipart/form-data">
        
        <input type="submit" name="btn" id ="btn" value="전송"/>
        <input type="file" name="file1" id="file1" multiple="multiple"/>
        <input type="file" name="file2" id="file2" multiple="multiple"/>
        <input type="file" name="file3" id="file3" multiple="multiple" />
		
		</form>
		
		<!-- 다운로드 부분 -->
		<a href = "fileDown?saveFile=160732345797712.jpg&realFile=12.jpg">12.jpg 다운로드</a>
</body>
</html>


