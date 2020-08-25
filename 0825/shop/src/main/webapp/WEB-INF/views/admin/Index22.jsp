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
   <!--로고 삽입 , 오른쪽 상단에 admin page 텍스트 삽입   -->
   <div class="shoplogo2">
    <img src="/img/shoplogo2.jpg" style="width:400px; height:150px; margin-left:95px;">      
        <p style="margin-left:700px; position:absolute; top:0px; right:120px;  font-size:48px; font-family:sans-serif; font-weight:bold;">Admin Page</p>
   </div>
   
<!--    <div style="float:right; top:120px;"> -->

<!--    </div>   -->
   
   
   
    <c:import url="Top.jsp"/>
	<table class="tb">
	 <c:choose>
	  <c:when test="${idKey!=null}">


	 <!-- 실시간 현황 이미지 삽입  -->   
	    <div>
	    <img src= "/img/img4.png"style="position:absolute; right:870px; bottom:490px; width:50px; height:50px;">
	    </div>
	   
	    <div>
	    <p style="position:absolute; right:650px; bottom:470px; font-size:40px; font-family:sans-serif; font-weight:bold;  ">실시간현황</p>
	    </div>
	    
	    <div>
	    <img src= "/img/img3.jpg"style="position:absolute; right:370px; bottom:430px; width:50px; height:50px;">
	    <p style="position:absolute; right:355px; bottom:390px; font-size:20px; font-family:sans-serif; font-weight:bold; ">취소대기</p>
	    </div>
	    
	    <!--취소대기 건수가 표시될 위치   -->
	    <p style="position:absolute; right:355px; bottom:350px; border: solid 1px; border-width:medium; width: 80px; height: 30px;"></p>
	    
	    
	    <div>
	    <img src= "/img/img2.jpg"style="position:absolute; right:700px; bottom:430px; width:50px; height:40px;">
	    <p style="position:absolute; right:690px; bottom:390px; font-size:20px; font-family:sans-serif; font-weight:bold; ">결제대기</p>
	<!-- <p style="position:absolute; right:700px; bottom:450px;">img2 들어갈 위치</p> -->
	    </div>
	   <!--결제대기 건수가 표시될 위치 -->
	    <p style="position:absolute; right:680px; bottom:350px; border: solid 1px; border-width:medium; width: 80px; height: 30px;"></p>
	   
	   
	   <div>
	    <img src= "/img/img1.jpg"style="position:absolute; right:1000px; bottom:430px; width:50px; height:40px;">
	    <p style="position:absolute; right:980px; bottom:390px; font-size:20px; font-family:sans-serif; font-weight:bold; ">총등록상품</p>
	   <!--  <p style="position:absolute; right:1000px; bottom:450px;">img1 들어갈 위치</p> -->
	    </div>
	   <!--총 등록상품이 표시될 위치  -->
	    <p style="position:absolute; right:980px; bottom:350px; border: solid 1px; border-width:medium; width: 80px; height: 30px;"></p>
	   <!--관리메모  -->
	   <div>
	    <p style="position:absolute; right:670px; bottom:280px; font-size:40px; font-family:sans-serif; font-weight:bold;  ">관리메모</p>
	    </div>
	  
	   <!--관리메모 옆에 표시될 이미지  -->
	    <div>
	    <img src= "/img/img4.png"style="position:absolute; right:870px; bottom:300px; width:50px; height:50px;">
	    </div>
	   
	   <!-- 관리자메모장  -->
	   <div>
	   <p style="position:absolute;right:700px; bottom:250px;"> 관리자 메모장 들어갈위치  </p>
	   
	   </div>
	   
	   
	    
	    <!--사이드바 생성   -->
	    <div class="my-account-left-nav" style="">
               <ul>
                  <li><a href="inputitem">입고상품</a></li>
                  <li><a href="">주문취소상품</a></li>
                  <li><a href="">주문내역조회</a></li>
                  <li><a href="">주문등록</a></li>
                  <li><a href="">배송지수정</a></li>
                  <li><a href="">배송완료상품조회</a></li>
                  <li><a href="Qna">Q&amp;A관리</a></li>
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
  