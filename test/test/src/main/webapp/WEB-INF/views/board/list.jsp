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
	function list(num) {
		$("#pageNo").val(num);
		$("#searchBtn").click();
	}

	function goPage(num) {
		$("#pageNo").val(num);
		$("#searchBtn").click();
	}

	$(function() {
		$('#searchType').val('${map.searchTy}');
		$('#searchOpt').val('${map.searchOp}');
		$('#datepicker').val('${map.stDate}');
		$('#datepicker2').val('${map.edDate}');

		$("#subject").click(function() {
			$("#wtr").attr("action", "write").attr("method", "post").submit();
		})

		//전체선택 & 전체해제 
		$("#check_all").click(function() {
			if ($("#check_all").prop("checked")) {
				$("input[type=checkbox]").prop("checked", true);
			} else {
				$("input[type=checkbox]").prop("checked", false);
			}
		})

		$("#cancel").click(
				function() {

					if ($("input:checkbox[name=chk]").is(":checked") == true) {
						$("#listFrm").attr("action", "delete").attr("method",
								"post").submit();

					} else {
						alert("체크 후 삭제해주세요");
						return false;
					}

				})

		//선택 검색
		/* 	$("#searchBtn").click(function() {
						$("#select").attr("action", "list").attr("method", "post").submit();
			
					})*/

		//ajax
		// 넘길 form 값 : select  , 넘기는건 어디에??? 
		//var $form = $("#select");
		$("#searchBtn").click(function() {

			$.ajax({
				url : 'searchList', //action
				type : 'post', //methot (get,post)
				data : $("#select").serialize(),
				//json타입으로 넘겨야함  json{key:value ,key:value} ,또는 직렬화 방식 사용 
				//콜백함수  success or Error 
				//컨트롤러에서 리턴됨 데이터가 들어옴 
				success : function(data) {
					//console.log(data);
					$("table").empty();
					$("table").html(data);
					
					
					//   아래방법은 div id 를 줘서 data 출력방식 
					//  				$('#body').empty();
					// 					$('#body').html(data);

				},
				error : function() {
					alert('fail');
				}
			});

		});
				
		/* 파일업로드  */
		/* var formData = new FormData($('#fileForm')[0]); 
		$.ajax({ 
			type: "POST", 
			enctype:'multipart/form-data', // 필수 
			url: '/multipartUpload', 
			data: formData, // 필수 
			processData: false, // 필수 
			contentType: false, // 필수 
			cache: false, 
			success: function (result) { 
				
			}, error: function (e) {
				
			}  
		});
			*/
	
		
			$("#excelBtn").click(function(){
				$("#select").attr("method","post").attr("action","excelDown").submit();
			})
			
			
			
			
	})
		
		

		
		
	
</script>
</head>
<body>
	<div id="body">
		<!-- 등록, 삭제 -->
		<form action="wtr">
			<input type="submit" value="등록">
		</form>
		<input type="button" value="삭제" id="cancel" />

		<!--  파일첨부   -->
		<form action="fileFrm">
			<input type="submit" value="파일첨부">
		</form>
	
		 
	
		 	




		<!-- 선택   -->
		<form id="select" name="select">
			<select id="searchOpt" name="searchOp">

				<option value=selectSearch>선택</option>
				<option value=writer>작성자</option>
				<option value=subject>제목</option>
				<option value=subjectCn>제목+내용</option>

			</select> 
			<input type="button" id="searchBtn" class="searchBt" value="검색">
			<input type="search" id="searchType" name="searchTy" placeholder="검색어를 입력하세요"> 
				<input type="text" id="datepicker" name=stDate placeholder="시작날짜"> ~<input type="text"
				id="datepicker2" name="edDate" placeholder="종료날짜"> 
				<input type="hidden" name="pageNo" id="pageNo" value=1 /> 
				<input type="hidden" name="listSize" id="listSize" value=10 />
				<input type = "button" name = "excelBtn" id = "excelBtn" value = "엑셀다운로드" onclick="">
		</form>

		<!--검색버튼&검색어 창&날짜선택  -->




		<!-- datepicker 기능  -->
		<script>
			$("#datepicker").datepicker();
			$("#datepicker2").datepicker();
		</script>


		<form id="listFrm" name="listFrm">
			<table border="1">


				<tr>
					<th><input type="checkbox" value="전체선택" id="check_all">전체선택</th>
					<th>글번호</th>
					<th>작성자(ID)</th>
					<th>제목</th>
					<th>작성일</th>
					<th>수정일</th>
					<th>조회수</th>
				</tr>
				<c:forEach items="${list}" var="list" varStatus="num">
					<tr>
						<td id="seq">
						<input type="checkbox" name="chk" id="chk${num.index}" value="${list.seq}">
						<td id="seq">${list.seq}</td>
						<td id="memName">${list.memName}(${list.memId})</td>
						<td><a href="detail?seq=${list.seq}">
								${list.boardSubject}</a></td>
						<td id="regDate">${list.regDate}</td>
						<td id="uptDate">${list.uptDate}</td>
						<td id="viewCnt">${list.viewCnt}</td>

					</tr>

				</c:forEach>

				<tr>

					<td colspan="7">
						<!-- **처음페이지로 이동 : 현재 페이지가 1보다 크면  [처음]하이퍼링크를 화면에 출력--> <c:if
							test="${pageMap.curBlock > 1}">
							<a href="javascript:goPage('1')">[처음]</a>
						</c:if> <!-- **이전페이지 블록으로 이동 : 현재 페이지 블럭이 1보다 크면 [이전]하이퍼링크를 화면에 출력 --> <c:if
							test="${pageMap.curBlock > 1}">
							<a href="javascript:goPage('${pageMap.prevPage}')">[이전]</a>
						</c:if> <!-- **하나의 블럭에서 반복문 수행 시작페이지부터 끝페이지까지 --> <c:forEach var="num"
							begin="${pageMap.blockBegin}" end="${pageMap.blockEnd}">
							<!-- **현재페이지이면 하이퍼링크 제거 -->
							<c:choose>
								<c:when test="${num == pageMap.curPage}">
									<span style="color: red">${num}</span>&nbsp;
                        </c:when>
								<c:otherwise>
									<a href="javascript:goPage('${num}')">${num}</a>&nbsp;
                        </c:otherwise>
							</c:choose>
						</c:forEach> <!-- **다음페이지 블록으로 이동 : 현재 페이지 블럭이 전체 페이지 블럭보다 작거나 같으면 [다음]하이퍼링크를 화면에 출력 -->
						<c:if test="${pageMap.curBlock <= pageMap.totBlock}">
							<a href="javascript:goPage('${pageMap.nextPage}')">[다음]</a>
						</c:if> <!-- **끝페이지로 이동 : 현재 페이지가 전체 페이지보다 작거나 같으면 [끝]하이퍼링크를 화면에 출력 --> <c:if
							test="${pageMap.curPage <= pageMap.totPage}">
							<a href="javascript:goPage('${pageMap.totPage}')">[끝]</a>
						</c:if>
					</td>
				</tr>
			</table>
		</form>




	</div>
</body>
</html>