<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>checkStudy</title>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>
<script>
$(function(){
	//전체선택 및 해제
	
	$("#check_all").click(function(){
		if($("#check_all").prop("checked")){
			
			$("input[type=checkbox]").prop("checked",true);
			$("#print")		
		}else {
			$("input[type=checkbox]").prop("checked",false);
			$("#print").empty();
		}
		
			
	
	})
	
	
	//9개 체크시 전체섲택 
	$("[name='chk']").click(function(){
			
		
		
		if($("input[name='chk']:checked").length ==9){

			$("#check_all").prop("checked",true);
		
		}else {
			$("#check_all").prop("checked",false);
			
		}
	})
	
	
	
	$("#checkBtn").click(function(){
			
		
		//4개 선택 이하면 성공  or 9개 선택 성공 
		
		//널 체크가 안되있음 
		if($("input[name='chk']:checked").length ==0){
			
		
			alert("체크값을 입력하세요");
		}
		
		else if($("input[name='chk']:checked").length <=4||$("input[name='chk']:checked").length ==9) {
		
			alert("성공");
			
		}
		
		else{
			alert("실패");
		}
			
	
	
	})
	
	
	
	
	
	
	// 국가 선택값 츌력 		
	 $("#usa").click(function(){
		if($("#usa").is(":checked")){
		$("#print").append("<span id='usa1'>"+"미국"+"</span>");
		}
		else{
			$("#usa1").remove();
		}
	})
	
	$("#jpn").click(function(){
		if($("#jpn").is(":checked")){
		$("#print").append("<span id='jpn1'>"+"일본"+"</span>");
		}
		else{
			$("#jpn1").remove();
		}
	})
	
	$("#cn").click(function(){
		if($("#cn").is(":checked")){
		$("#print").append("<span id='cn1'>"+"중국"+"</span>");
		}
		else{
			$("#cn1").remove();
		}
	})
	
	$("#uk").click(function(){
		if($("#uk").is(":checked")){
		$("#print").append("<span id='uk1'>"+"영국"+"</span>");
		}
		else{
			$("#uk1").remove();
		}
	})
	
	$("#tha").click(function(){
		if($("#tha").is(":checked")){
		$("#print").append("<span id='tha1'>"+"태국"+"</span>");
		}
		else{
			$("#tha1").remove();
		}
	})
	
	$("#gmn").click(function(){
		if($("#gmn").is(":checked")){
		$("#print").append("<span id='gmn1'>"+"독일"+"</span>")
		}
		else{
			$("#gmn1").remove();
		}
	})
	
	$("#twn").click(function(){
		if($("#twn").is(":checked")){
		$("#print").append("<span id='twn1'>"+"대만"+"</span>");
		}
		else{
			$("#twn1").remove();
		}
	})
	
	$("#nhk").click(function(){
		if($("#nhk").is(":checked")){
		$("#print").append("<span id='nhk1'>"+"북한"+"</span>");
		}
		else{
			$("#nhk1").remove();
		}
	})
	
	
	$("#aus").click(function(){
		if($("#aus").is(":checked")){
		$("#print").append("<span id='aus1'>"+"호주"+"</span>");
		}
		else{
			$("#aus1").remove();
		}
	})
	 
	
	
	
})



</script>


</head>
<body>
<label><input type="checkbox" id="check_all" value="모두 선택" />모두선택</label>
 <input type="button" id="checkBtn"  value="검사" /></label>
<br />
<label><input type="checkbox" name="chk" value="1" id="usa" />미국</label>
<label><input type="checkbox" name="chk" value="2" id="jpn"/>일본</label>
<label><input type="checkbox" name="chk" value="3" id="cn"/>중국</label>
<label><input type="checkbox" name="chk" value="4" id="uk"/>영국</label>
<label><input type="checkbox" name="chk" value="5" id="tha"/>태국 </label>
<label><input type="checkbox" name="chk" value="6" id="gmn"/>독일 </label>
<label><input type="checkbox" name="chk" value="7" id="twn"/>대만 </label>
<label><input type="checkbox" name="chk" value="8" id="nhk"/>북한 </label>
<label><input type="checkbox" name="chk" value="9" id="aus"/>호주 </label>


<div id="print"></div>
</body>
</html>