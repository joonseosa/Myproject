<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Admin Page </title>
<link href="/resources/css/main.css" rel="stylesheet" type="text/css">
<script  type="text/javascript" src="./resources/js/mainScript.js" charset="utf-8"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>


<body >
<div class="tb_wrap">
  <div class ="tb_box">
    <c:import url="Top.jsp"/>
	<table class="tb">
	 <c:choose>
	  <c:when test="${adminIdKey!=null}">
	     <tr > 
      	  <td class ="tb2">관리자님 방문해 주셔서 감사합니다.</td>
  	     </tr>
	  </c:when>
	  <c:when test="${adminIdKey==null}">
	  <tr >
	   <td class ="tb2"> 로그인 하신 후 이용해 주세요</td>
	  </tr>
	  </c:when>
	 </c:choose>
	
	</table>
	<form name ="postF" action="" method="post">
	<!--shoplogo 추가  (가운데 부분)  -->
	<div>
	<img src="/img/shoplogo.jpg" >
	</div>
	</form>
	<form name ="postForm" >
	  <input type="hidden" name="cpass">
	  <input type="hidden" name="passwd" value="${mdto.m_passwd}">
	</form>
	
		    <div class="my-account-left-nav" style="position:absolute; top:100px; wdth:148px; height:415px;">
               <ul>
                
                  <li><a href="">매출조회</a></li>
                  <li><a href="">MD추천상품등록</a></li>
               </ul>
            </div>
	
	
	
	
	
  <c:import url="Bottom.jsp"/>
  </div>
</div>
</body>
</html>  
  
  