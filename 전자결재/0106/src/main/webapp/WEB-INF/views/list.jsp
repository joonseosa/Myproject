<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


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
		
function enterkey(){
	if(window.event.keyCode == 13){
		$("#searchFrm").attr("action","list").attr("method","post").submit();
	}
	
}
	
	

	
	$(function(){
		
	

		
		//   searchOpt의 값을 컨트롤러 searchList map에 담는다 
		$("#searchOpt").val('${searchList.searchOpt}');
		
		$("#searchType").val('${searchList.searchType}');
		
		$("#stDate").val('${searchList.stDate}');
		$("#edDate").val('${searchList.edDate}');
		
		
		

// 		$("#stDate").val('${stDate}');
// 		$("#edDate").val('${edDate}');
		
		$("#stDate").datepicker();
		$("#edDate").datepicker();
		
			$("#logOutbtn").click(function(){
			$("#logOut").attr("method","post").attr("action","logOut").submit();
			
		})

		$("#write").click(function() {
					$("#wtr").attr("action", "write").attr("method", "post").submit();
				})
			
		var memRank ='${memInfo.memRank}';
		
		if(memRank == 'ba' || memRank == 'ga'){
			$("#proxyAppr").show();	
		}
	
		//search버튼 누르면 form에 있는 데이터를  list로 보냄 
		$("#searchBtn").click(function(){
			
			$("#searchFrm").attr("action","list").attr("method","post").submit();
		})	
		
		
		
		//ajax 방식으로 검색 리스트 처리
		$("#appOpt").change(function(){
			$.ajax({
				//보낼 url (컨트롤러)
				url : "searchList",	
			
				//form 에 묶어서 serialize로 보내기
				data : $("#searchFrm").serialize(),
			   
				//전송방식
				type : "post",
				
				//성공됐을때 , 완료 메세지 발생 
				success : function(data) {
					alert("완료");
				//searchContent 에 html 태그 안에 내용을  data안에 담는다 
					$("#searchContent").html(data);	
				},
				error : function(data){
					
				}
				
			})
			
		
		})
		
		
		
	})
				
</script>
<style type="text/css">
#Slist:hover tbody tr:hover td {
    background: red;
    color: white;
}
</style>	

</head>
<body>
			<div >
			${sessionScope.memInfo.memName }(${sessionScope.memInfo.memRankKor })님 환영합니다.
			
			</div>
				<input type = "hidden" name = "logId" id = "logId" value = "${memInfo.memId}">
				<input type="button" name="logoutbtn" id="logoutbtn" value="로그아웃" onclick="location.href='logout'"/>
			
				
			
				<input type="button" value="글쓰기" name="writeBtn" id="writeBtn" onclick="location.href='write'">
			
				<input type="button" value="대리결재" name="proxyAppr" id="proxyAppr" style= "display: none">
				
			
				<!-- 검색 -->
			<form id="searchFrm" name="searchFrm">
				<select id="searchOpt" name="searchOpt">

					<option value=selectSearch>선택</option>
					<option value=writer>작성자</option>
					<option value=subjectCn>제목+내용</option>
					<option value=apprName>결재자</option>
				</select> 

			<input type="button" id="searchBtn" class="searchBtn" value="검색">
			<input type="search" id="searchType" name="searchType" placeholder="검색어를 입력하세요" autocomplete="off" onkeyup="enterkey()"> 
				<input type="text" id="stDate" name="stDate" placeholder="시작날짜" autocomplete="off"> ~
				<input type="text" id="edDate" name="edDate" placeholder="종료날짜" autocomplete="off"> 
				
				<input type="hidden" name="pageNo" id="pageNo" value=1 /> 
				<input type="hidden" name="listSize" id="listSize" value=10 />
		
		<select id="appOpt" name="appOpt">
					<option value = "stCon">선택 </option>
					<option value = "tmp" id="tmp">임시저장</option>
					<option value = "wat">결재대기</option>
					<option value = "ing">결재중</option>
					<option value = "end">결재완료</option>
					<option value = "ret">반려</option>
		</select>
		
		
		
		</form>
					
			<table border="1" class="table" id="Slist">
				<tr>
					<td>번호</td>
					<td>작성자</td>
					<td>제목</td>
					<td>작성일</td>
					<td>결재일</td>
					<td>결재자</td>
					<td>결재상태</td>
				</tr>
			<tbody id="searchContent">
				<c:choose>
					<c:when test="${not empty list}">
						<c:forEach items="${list}" var="list">
								<tr onclick ="location.href='detail?seq=${list.seq}'">
							 		<td>${list.seq}</td>
									<td>${list.memName}</td>
									<td>${list.apprSubject}</td>
									<td>${list.apprRegDate}</td>
									<td>${list.apprDate}</td>
									<td>${list.apprName}</td>
									<td>${list.apprStatusKor}</td>
								</tr>
							</c:forEach>
               		</c:when>
					<c:otherwise>
						 <tr>
						 		<td colspan="7">검색된 데이터가 없습니다</td>
						 </tr>
					</c:otherwise>
			</c:choose>
		</tbody>
			
			</table>
		</body>
	</html>
 
               





				
		




