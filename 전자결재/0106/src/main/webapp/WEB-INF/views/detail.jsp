<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>writeView</title>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>
$(function(){
	//컨트롤러에서  model addattribute (string name) 
	var ChkCond ='${ChkCond}';
	
	//write 
	var addSeq = '${seq}';
	var addWriter = '${memInfo.memName}';
	var addWriterId =  '${memInfo.memId}';
	var memRank ='${memInfo.memRank}';
	
	//detail 
	var mofySeq ='${map.seq}';
	var mofyWriter = '${map.memName}';
	var mofyWriterId = '${map.writeId}';
	var mofyStatus = '${map.apprStatus}';
	
	
	
	if(mofyStatus == 'wat'){
		
		$("#signWait").prop("checked",true);
		
		if(addWriterId != mofyWriterId){
			$("#tmpBtn").hide();
		}else{
			$("#tmpBtn, #retBtn, #appBtn").hide();
		}
	
	}else if(mofyStatus == 'ing'){
		$("#signWait").prop("checked",true);
		$("#signIng").prop("checked",true);
		
		if(memRank == 'ba'){
			$("#tmpBtn").hide();
		}else{
			$("#tmpBtn, #retBtn, #appBtn").hide();
		}
	
	}else if(mofyStatus == 'end'){
		$("input[name=sign]").prop("checked",true);
		$("#tmpBtn, #retBtn, #appBtn").hide();
	
	}else if(mofyStatus == 'tmp'){
		if(addWriterId == mofyWriterId){
			$("#retBtn").hide();
		}
	}else if(mofyStatus == 'ret'){
		if(addWriterId == mofyWriterId){
			$("#retBtn").hide();
		}else{
			$("#tmpBtn, #retBtn, #appBtn").hide();
		}
	}	
	
	if(ChkCond == 'add'){
		$("#seq").val(addSeq);
		$("#writer").val(addWriter);
		$("#writerId").val(addWriterId);
		$("#retBtn").hide();
		$("#subj").removeAttr("readonly");
		$("#content").removeAttr("readonly");
	}else{
		$("#seq").val(mofySeq);
		$("#writer").val(mofyWriter);
		$("#writerId").val(mofyWriterId);
		
	}
	
	if((addWriterId == mofyWriterId) &&  ( mofyStatus == 'tmp' || mofyStatus == 'ret')){
		$("#subj").removeAttr("readonly");
		$("#content").removeAttr("readonly");
	}
	
	
})
		
function fncSave(stat){
			
			var ivChk = initVal();
			if(ivChk != 1 ){
				$("#appStatus").val(stat);
				var grade = '${memInfo.memRank}';
				if(stat == 'app'){
					if(grade == 'sa'){
						$("#appStatus").val('wat');
					}else if(grade == 'da'){
						$("#appStatus").val('wat');
					}else if(grade == 'ga'){
						$("#appStatus").val('ing');
					}else if(grade == 'ba'){
						$("#appStatus").val('end');
					}
				}
				
				
				$("#writeFrm").attr("action","detailInsert").attr("method","post").submit();	
			}
			
		}
		
		function initVal(){
			var temp;
			if($("#subj").val() == ''){
				alert("제목을 입력하세요");
				temp = 1;
			}else if($("#content").val() == ''){
				alert("내용을 입력하세요");
				temp = 1;
			}
			return temp;
		}
		
		

	
		
	

</script>

</head>
<body>
   <div>
		<table border = "1">
			<tr>
				<th>결재요청</th>
				<th>과장</th>
				<th>부장</th>
			</tr>
			<tr>
				<td><input type = "checkbox" name = "sign" id = "signWait" disabled="disabled"></td>
				<td><input type = "checkbox" name = "sign" id = "signIng" disabled="disabled"></td>
				<td><input type = "checkbox" name = "sign" id = "signEnd" disabled="disabled"></td>
			</tr>
		</table>
	</div>
	<form name = "writeFrm" id = "writeFrm">
		<input type = "hidden" name = "appStatus" id = "appStatus">
		<input type = "hidden" name = "logId" id = "logId" value = "${memInfo.memId }"> 
		<div>
			<table>
				<tr>
					<th>글번호</th>
					<td><input type = "text" name = "seq" id = "seq" value="${map.seq}" readonly="readonly" ></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>
						<input type = "text" name = "writer" id = "writer" value="${map.memName }" readonly="readonly">
						<input type = "hidden" name = "writerId" id = "writerId" value="${map.writeId }" >
					</td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type = "text" name = "subj" id = "subj"  value="${map.apprSubject}" placeholder="제목을 입력하세요" readonly="readonly" ></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="5" cols="25" name = "content" id = "content" placeholder="내용을 입력하세요" readonly="readonly" >${map.apprContent}</textarea></td>
				</tr>
			</table>
		</div>
	</form>
	<div>
	
		<input type = "button" name = "tmpBtn" id = "tmpBtn" value = "임시저장" onclick = "fncSave('tmp')">
		<input type = "button" name = "appBtn" id = "appBtn" value = "결재" onclick = "fncSave('app')">
		<input type="button" name="retBtn" id="retBtn"  value="반려"  onclick="fncSave('ret')">
	</div>
	<div>
		<table border = "1">
			<tr>
				<th>번호</th>
				<th>결재일</th>
				<th>결재자</th>
				<th>결재상태</th>
			</tr>
			<c:forEach items="${hisList}" var = "his">
				<tr> 
					<td>${his.hisSeq }</td>
					<td>${his.hisAppDate}</td>
					<td>${his.memName }</td>
					<td>${his.histStatusKor }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>