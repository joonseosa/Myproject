<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<table>
	<c:if test="${adminIdKey == null }">
		<script  type="text/javascript">
			location.href="/login";
		</script>
	</c:if>
	<tr>
		<th><b><a href="/">홈</a></b></th>
		<th><b><a href="/logout">로그아웃</a></b></th>
		<th><b><a href="/MemberMgr">회원관리</a></b></th>
		<c:set var="idKey" value="${idKey}" />

		<th><b><a href="/ProductMgr">상품관리</a></b></th>
		<!-- 상품목록 위치   -->
		<th><b><a href="/ItemInquiry">상품문의관리</a></b></th>
		<th><b><a href="/OrderMgr">주문관리</a></b></th>
		<!--href 에는 admin controller에서 request mapping에 있는 값을 가져온다   -->

	</tr>





</table>
