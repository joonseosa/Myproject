<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" 
     uri="http://java.sun.com/jsp/jstl/functions" %>
<table>
  <tr>
  <c:choose>
    <c:when test="${idKey==null}">
     <th> <b><a href="/login">로그인</a></b></th>
     <th> <b><a href="/register">회원관리</a></b></th>
    <!--회원가입 위치    -->	
    </c:when>
     <c:when test="${idKey!=null and fn:length(idKey)>0 }">
     <th><b><a href="/logout">로그아웃</a></b></th>
     <th> <b><a href="javascript:pwCheck('U')">회원수정</a></b></th>
     <c:set var="idKey" value="${idKey}"/>
     </c:when>
  </c:choose>
    <th><b><a href="/productList">상품관리</a></b></th>
    <!-- 상품목록 위치   -->
    <th><b><a href="/cartList">Q&A관리</a></b></th>
    <th><b><a href="/orderList">주문/배송관리</a></b></th>
  </tr>
</table>
