<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<table border="1">


	<tr>
		<td><input type="hidden" name="pageNo" id="pageNo" value=1 /> 
		<input type="hidden" name="listSize" id="listSize" value=10 /></td>


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
			<td id="seq"><input type="checkbox" name="chk"
				id="chk${num.index}" value="${list.seq}">
			<td id="seq">${list.seq}</td>
			<td id="memName">${list.memName}(${list.memId})</td>
			<td><a href="detail?seq=${list.seq}"> ${list.boardSubject}</a></td>
			<td id="regDate">${list.regDate}</td>
			<td id="uptDate">${list.uptDate}</td>
			<td id="viewCnt">${list.viewCnt}</td>

		</tr>

	</c:forEach>

	<tr>
		<td colspan="7">
			<!-- **처음페이지로 이동 : 현재 페이지가 1보다 크면  [처음]하이퍼링크를 화면에 출력--> 
			<c:if test="${pageMap.curBlock > 1}">
				<a href="javascript:goPage('1')">[처음]</a>
			</c:if>
			
			 <!-- **이전페이지 블록으로 이동 : 현재 페이지 블럭이 1보다 크면 [이전]하이퍼링크를 화면에 출력 --> 
			 <c:if test="${pageMap.curBlock > 1}">
				<a href="javascript:goPage('${pageMap.prevPage}')">[이전]</a>
			</c:if> 
			
			<!-- **하나의 블럭에서 반복문 수행 시작페이지부터 끝페이지까지 --> 
			<c:forEach var="num" begin="${pageMap.blockBegin}" end="${pageMap.blockEnd}">
			
				<!-- **현재페이지이면 하이퍼링크 제거 -->
				
				<c:choose>
					<c:when test="${num == pageMap.curPage}">
						<span style="color: red">${num}</span>&nbsp;
                        </c:when>
					<c:otherwise>
						<a href="javascript:goPage('${num}')">${num}</a>&nbsp;
                        </c:otherwise>
				</c:choose>
			</c:forEach>
			
			 <!-- **다음페이지 블록으로 이동 : 현재 페이지 블럭이 전체 페이지 블럭보다 작거나 같으면 [다음]하이퍼링크를 화면에 출력 -->
			<c:if test="${pageMap.curBlock <= pageMap.totBlock}">
				<a href="javascript:goPage('${pageMap.nextPage}')">[다음]</a>
			</c:if>
			
			 <!-- **끝페이지로 이동 : 현재 페이지가 전체 페이지보다 작거나 같으면 [끝]하이퍼링크를 화면에 출력 --> 
			 <c:if test="${pageMap.curPage <= pageMap.totPage}">
				<a href="javascript:goPage('${pageMap.totPage}')">[끝]</a>
			</c:if>
		</td>
	</tr>
</table>

