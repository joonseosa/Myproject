<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
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
<div class="tb_wrap">
  <div class ="tb_box">		
	<c:import url="Top.jsp"/>
 
	<table class="tb">
	 <tr> 
	   <td  class="tb2">

	 <form method=post name="order" action="/adminOrderProc">
		<table>
		 <tr> 
		  <td colspan="2"><font color="#FFFFFF">주문 상세내역</font></td>
		 </tr>
		
		 <tr> 
			<td align="center">주문자이름</td>
			<td align="center">${odto.mem_name}</td>
		 </tr>				
		 <tr> 
			<td align="center">상품가격</td>
			<td align="center">${odto.orders_item_money}</td>
		 </tr>
		 <tr> 
			<td align="center">수량</td>
			<td align="center">${odto.orders_item_cnt}</td>
		 </tr>
		 <tr> 
			<td align="center">상품옵션</td>
			<td align="center">${odto.option_name}</td>
		 </tr>
		 <tr> 
			<td align="center">상품번호</td>
			<td align="center">${odto.item_no}</td>
		 </tr>		
		 <tr> 
			<td align="center">주문번호</td>
			<td align="center">${odto.order_no}</td>
		 </tr>
		
		 <tr> 
			<td class="theadstyle" >주문상태</td>
			<td class="tbodystyle" align="center">
			 <select name="order_status" id='order_status'>
				<option value="접수중">접수중</option>
				<option value="접수">접수</option>
				<option value="입금확인">입금확인</option>
				<option value="배송준비">배송준비</option>
				<option value="배송중">배송중</option>
				<option value="완료">완료</option>
			  </select>
			<script>	   
			$(function(){
			   $("#order_status").val(${odto.order_status})
			});
	  </script>
			</td>
		</tr>
		
		
		
		
		<tr> 
		<td colspan="2" align="center">
		<input type="button"  value="수정" size="3" onclick="javascript:orderUpdate(this.form,'U')"> / 
		<input type="button" value="삭제" size="3" onclick="javascript:orderUpdate(this.form, 'D')">
		</td>
		</tr>
		</table>
		<input type="hidden" name="order_no" value="${odto.order_no}">
		<input type="hidden" name="flag">
		</form>		
			
	   </td>
	  </tr>
	</table>
	 <c:import url="Bottom.jsp"/>
	 </div>
  </div>
</body>
</html>