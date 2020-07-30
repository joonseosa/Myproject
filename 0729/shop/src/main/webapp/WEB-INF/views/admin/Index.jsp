<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- views/admin -->
<html>
<head>
<title>Admin Page </title>
<link href="../resources/css/main.css" rel="stylesheet" type="text/css">
<script  type="text/javascript" src="../resources/js/mainScript.js" charset="utf-8"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>

<body >
<div class="tb_wrap">
  <div class ="tb_box">
   <!--로고 삽입   -->
   <div class="shoplogo2">
    <img src="/img/shoplogo2.jpg" style="width:500px; height:180px; margin-left:95px;">      
        <p style="margin-left:700px; font-size:48px;">Admin Page</p>
   </div>
   
<!--    <div style="float:right; top:120px;"> -->

<!--    </div>   -->
   
   
   
    <c:import url="Top.jsp"/>
	<table class="tb">
	 <c:choose>
	  <c:when test="${idKey!=null}">
	    
	    <!--사이드바 생성   -->
	    
	    <div class="my-account-left-nav" style="">
               <ul>
                  <li><a href="">입고상품</a></li>
                  <li><a href="">출고상품</a></li>
                  <li><a href="">주문취소상품</a></li>
                  <li><a href="">주문내역조회</a></li>
                  <li><a href="">주문등록</a></li>
                  <li><a href="">배송지수정</a></li>
                  <li><a href="">배송완료상품조회</a></li>
                  <li><a href="">Q&amp;A관리</a></li>
                  <li><a href="">Point관리</a></li>
               </ul>
            </div>

	     <tr > 
      	  <td class="tb2">${adminDto.m_name}님 방문해 주셔서 감사합니다.</td>
  	     </tr>
	  </c:when>
	  <c:when test="${idKey==null}">
		   <tr>
		   <td class="tb2"> 로그인 하신 후 이용해 주세요</td>
		  </tr>
	  </c:when>
	 </c:choose>
	</table>
  <c:import url="Bottom.jsp"/>
  </div>
  </div>
</body>
</html>  
  