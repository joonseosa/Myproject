<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" 
     uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<title>Admin Page</title>
<link href="../resources/css/main.css"  rel="stylesheet" type="text/css">
<script src="../resources/js/jquery-1.10.2.min.js"></script>
<script src="../resources/js/mainScript.js" charset="utf-8" type="text/javascript"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="../resources/js/zipCheck.js"></script>
</head>
<body>
<div class="tb_wrap">
  <div class ="tb_box">
	 <c:import url="Top.jsp"/>
 
	<table class="tb">
	<tr> 
	<td class="tb2">
		<table>
	  	  <thead>
			<tr>
				<p style="font-size:24px; font-family:sans-serif; font-weight:bold;">Admin Page- 주문취소관리 </p>
			</tr>
			
			<tr> 
				<th  class="theadstyle"><font color="#FFFFFF">주문번호</font></th>
				<th  class="theadstyle"><font color="#FFFFFF">취소접수일자</font></th>
				<th  class="theadstyle"><font color="#FFFFFF">취소완료일자</font></th>
				<th  class="theadstyle"><font color="#FFFFFF">관리자승인여부</font></th>
				<th  class="theadstyle"><font color="#FFFFFF">취소사유</font></th>
				<th  class="theadstyle"><font color="#FFFFFF">상세사유</font></th>

			</tr>
		  </thead>
		  <tbody>
			<c:choose> 
			  <c:when test="${fn:length(ordercancelList) >0}">
				<c:forEach var="ocdto" items="${ordercancelList}">
					<tr> 
					<td class="tbodystyle">${ocdto.order_no}</td>
					<td class="tbodystyle">${ocdto.cancel_receipt_date}</td>
					<td class="tbodystyle">${ocdto.cancel_complete_date}</td>
					<c:if test="${ocdto.admin_approval_or_not==1}">
						<td class="tbodystyle">취소승인</td>
					</c:if>
					<c:if test="${ocdto.admin_approval_or_not==0}">
						<td class="tbodystyle">취소대기</td>
					</c:if>
					<td class="tbodystyle">${ocdto.cancel_reason}</td>
					<td class="tbodystyle">${ocdto.detail_reason}</td>
					<td><a href="/OrderCancelDetail?order_no=${ocdto.order_no}">상세보기</a></td>
									
		

<!-- 상세보기기능 주석처리  -->
<%-- 					<td class="tbodystyle">${odto.order_no}</td> --%>
<%-- 					<td><a href="javascript:shopMgrDetail('${odto.no}')">상세보기</a></td> --%>
					</tr>
			   </c:forEach>
			   </c:when>
			   <c:otherwise>
					<tr> 
					<td class="tb2" colspan="7">취소 내역이 없습니다</td>
					</tr>
			   </c:otherwise>
			</c:choose>
		   </tbody>
		  </table>
		</td>
		</tr>
		</table>
		
	     <c:import url="Bottom.jsp"/>
    </div>
  </div>
  
<!-- 	<form name="detail" method="post" action="/orderDetail" > -->
<!-- 	  <input type="hidden" name="no"> -->
<!-- 	</form> -->

</body>
</html>
