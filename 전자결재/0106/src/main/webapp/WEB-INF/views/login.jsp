<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script>
	var loginChk = '${loginChk}';
	if(loginChk == 'errorId'){
		alert("등록된 사용자가 아닙니다");
		$("#memId").focus();
	}else if(loginChk == 'errorPw'){
		alert("암호를 확인해주세요");
		$("#memPw").focus();
	}
	
	function enterkey(){
		if(window.event.keyCode == 13){
			$("#frm").attr("action","loginCheck").attr("method","post").submit();
		}
		
	}
	
	
	$(function(){
		
		$("#btn").click(function(){
			 	
			if($("#memId").val() == ''){
				alert('아이디를 입력하세요');
				$("#memId").focus();
			}else if($("#memPw").val() == ''){
				alert('비밀번호를 입력하세요');
				$("#memPw").focus();
			}else{
				$("#frm").attr("action","loginCheck").attr("method","post").submit();
			}
		})
	})
	
	

</script>


</head>
<body>
	<p>로그인 페이지</p>


	<table>
	
			<form name="frm" id="frm" >
			<div>	
				ID : <input type="text" name="memId" id="memId" placeholder="4글자 입력" autocomplete="off" > <br> 
				PW : <input type="password" name="memPw" id="memPw" placeholder="4글자 입력" onkeyup="enterkey()"> <br> 
				</div>
				<input type="button" value="로그인" name="btn" id="btn"> 
			</form>

	</table>


</body>
</html>