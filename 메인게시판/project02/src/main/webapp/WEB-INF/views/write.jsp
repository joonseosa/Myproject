<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>writeView</title>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>
<script>

  	$(function(){
 		
  	
  		
  		
  		$("#tmpBtn").click(function(){
  				$("#appStatus").val('tmp');
  				$("#writeFrm").attr("action","insert").attr("method","post").submit();
  		})	
  		$("#appBtn").click(function(){
			
  				$("#appStatus").val('wat');
  				$("#writeFrm").attr("action","insert").attr("method","post").submit();
  		})
		
  	})
 		
 
		
		
	

	 
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
		<input type = "hidden" name = "logId" id = "logId" value = "${memInfo.memId}"> 
		
		<div>
			<table>
				<tr>
					<th>글번호</th>
					<td><input type = "text" name = "seq" id = "seq" value="${seq}" readonly="readonly" ></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>
						<input type = "text" name = "writer" id = "writer" value="${sessionScope.memInfo.memName }" readonly="readonly">
						<input type = "hidden" name = "writerId" id = "writerId" value="${sessionScope.memInfo.memId }" >
					</td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type = "text" name = "subj" id = "subj"  placeholder="제목을 입력하세요" ></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="5" cols="25" name = "content" id = "content" placeholder="내용을 입력하세요" ></textarea></td>
				</tr>
			</table>
		</div>
	</form>
	<div>
	
		<input type = "button" name = "tmpBtn" id = "tmpBtn" value = "임시저장" onclick="stSave('tmp')" >
		<input type = "button" name = "appBtn" id = "appBtn" value = "결재" onclick="stSave('app')">
	
	
	
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