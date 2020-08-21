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
				<th  class="theadstyle"><font color="#FFFFFF">주문자 이름</font></th>
				<th  class="theadstyle"><font color="#FFFFFF">상품가격</font></th>
				<th  class="theadstyle"><font color="#FFFFFF">수량</font></th>
				<th  class="theadstyle"><font color="#FFFFFF">상품옵션</font></th>
				<th  class="theadstyle"><font color="#FFFFFF">상품번호</font></th>
				<th  class="theadstyle"><font color="#FFFFFF">주문번호</font></th>
				<th  class="theadstyle"><font color="#FFFFFF">상태</font></th>
				<th  class="theadstyle"><font color="#FFFFFF">상세보기</font></th>
			</tr>
		  </thead>
		  <tbody>
			<c:choose> 
			  <c:when test="${fn:length(orderList) >0}">
				<c:forEach var="odto" items="${orderList}" varStatus="i">
					<tr> 
					<td class="tbodystyle">${odto.mem_name}</td>
					<td class="tbodystyle">${odto.orders_item_money}</td>
					<td class="tbodystyle">${odto.orders_item_cnt}</td>
					<td class="tbodystyle">${odto.option_name}</td>
					<td class="tbodystyle">${odto.item_no}</td>
					<td class="tbodystyle">${odto.order_no}</td>
					<td class="tbodystyle">${odto.order_status}</td>
<!-- 상세보기기능 주석처리  -->
						
					<td><a href="/OrderDetail?order_no=${odto.order_no}">상세보기</a></td>
					</tr>
			   </c:forEach>
			   </c:when>
			   <c:otherwise>
					<tr> 
					<td class="tb2" colspan="7">주문 내역이 없습니다</td>
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
  
	<form name="detail" method="post" action="OrderDetail" >
	  <input type="hidden" name="order_no">
	</form>

</body>
</html>
