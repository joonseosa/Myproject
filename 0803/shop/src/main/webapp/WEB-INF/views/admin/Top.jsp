<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
</head>
<table >
  <tr> 
<%--     <c:choose> --%>
<%--     <c:when test="${idKey==null}">   --%>
<!--        <script> -->
//          alert("로그인이 필요합니다.");
//          document.location.href= "/";
<!--        </script> -->
<%--     </c:when> --%>
<%--     <c:otherwise> --%>
    <th><b><a href="/admin/index">홈</a></b></th>
    <th><b><a href="/logout">로그아웃</a></b></th>
    <th><b><a href="/memberMgr">회원관리</a></b></th>
    <th><b><a href="/productMgr">상품관리</a></b></th>
    <th><b><a href="/orderMgr">주문관리</a></b></th>
<%--     </c:otherwise> --%>
<%--     </c:choose> --%>
  </tr>
</table> 

