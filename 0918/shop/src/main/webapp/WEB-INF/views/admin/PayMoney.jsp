<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<html>
<head>
<title>Simple Shopping Mall Admin</title>
<link href="../resources/css/main.css" 
             rel="stylesheet" type="text/css">
<script src="../resources/js/jquery-1.10.2.min.js"></script>
<script src="../resources/js/mainScript.js" charset="utf-8" type="text/javascript"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="../resources/js/zipCheck.js"></script>
</head>
 
<body>
<%-- <c:choose> --%>
<%--   <c:when test="${idKey==null}"> --%>
<%--      <c:redirect url="/login"></c:redirect> --%>
<%--   </c:when> --%>
<%--   <c:when test="${idKey!=null}"> --%>
	<div class="tb_wrap">
	  <div class ="tb_box">
		 <c:import url="Top.jsp"/>
		<table class="tb">
			<tr> 
				<td  class="tb2">
				  <form action="">				 
					<table>
				   <thead>
						<tr>
							<p style="font-size:24px; font-family:sans-serif; font-weight:bold;">Admin Page- 월별 매출조회 </p>
						</tr>
					
					<tr> 
						<th  class="theadstyle"><font color="#FFFFFF">주문날짜</font></th>
						<th  class="theadstyle"><font color="#FFFFFF">결제금액</font></th>
					</tr>
					</thead>
				
	                 <tbody >
							<c:choose> 
							  <c:when test="${fn:length(paymoneyList) >0}">
								<c:forEach var="odto" items="${paymoneyList}">
									<tr > 
										<td class="tbodystyle">${odto.order_date}</td>
										<td class="tbodystyle">${odto.order_money}</td>
									</tr>
								</c:forEach>
							  </c:when>
 						 	  <c:otherwise>
 									    <tr >
										   <td class="tb2" colspan="5"> 등록된 상품이 없습니다.</td>
										</tr>
							  </c:otherwise> 
							</c:choose>
							
			
							
							</tbody>
					   
					</table>
		</form>
				</td>
			</tr>
		</table>
		
<!-- 페이징처리할때 주석 풀기 -->
<!-- 	<table> -->
<!-- 					<h1 style="text-align: center"> -->
<!-- 						<a href="/ProductMgr?presentPage=1" style="color: black;font-size:0.7em;"> [start] </a> -->
<%-- 						<c:if test="${pdto.presentPage!=1}"> --%>
<%-- 							<a href="/ProductMgr?presentPage=${pdto.presentPage-1}" style="color: black;font-size:0.7em;"> <  --%>
<%-- 						</c:if> --%>
<!-- 						</a> -->
<%-- 						<c:forEach var="i" begin="${pdto.startPage}" end="${pdto.endPage}"> --%>
<%-- 							<c:if test="${pdto.presentPage==i}"> --%>
<%-- 								<a href="/ProductMgr?presentPage=${i}"><span --%>
<%-- 									style="color: red;font-size:0.7em;"><c:out value="[${i}]" /></span></a> --%>
<%-- 							</c:if> --%>
<%-- 							<c:if test="${pdto.presentPage!=i}"> --%>
<%-- 								<a href="/ProductMgr?presentPage=${i}" style="color: black;font-size:0.7em;"><c:out value="[${i}]" /></a> --%>
<%-- 							</c:if> --%>
<%-- 						</c:forEach> --%>
<%-- 						<c:if test="${pdto.presentPage!=pdto.endPage}"> --%>
<%-- 							<a href="/ProductMgr?presentPage=${pdto.presentPage+1}" style="color: black;font-size:0.7em;"> >  --%>
<%-- 						</c:if> --%>
<%-- 						</a> <a href="/ProductMgr?presentPage=${pdto.allPage}" style="color: black;font-size:0.7em;"> [end] </a> --%>
<!-- 					</h1> -->
<!-- 				</table> -->
	   <c:import url="Bottom.jsp"/>
		</div>
		</div>
		<!--상세보기 주석처리   -->
		<form name="detail" method="post" action="productDetail" >
		  <input type="hidden" name="item_no">
		</form> 
<%--   </c:when> --%>
<%-- </c:choose> --%>

</body>
</html>