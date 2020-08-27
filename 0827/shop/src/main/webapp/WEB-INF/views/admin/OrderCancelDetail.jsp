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

	 <form method=post name="orderCancel" action="/adminOrderProc">
		<table>
		 <tr> 
		  <td colspan="2"><font color="#FFFFFF">주문 상세내역</font></td>
		 </tr>
		
		 <tr> 
			<td align="center">주문번호</td>
			<td align="center">${ocdto.order_no}</td>
		 </tr>				
		 <tr> 
			<td align="center">취소접수일자</td>
			<td align="center">${ocdto.cancel_receipt_date}</td>
		 </tr>
		 <tr> 
			<td align="center">취소완료일자</td>
			<td align="center">${ocdto.cancel_complete_date}</td>
		 </tr>
		 <tr> 
			<td align="center">취소사유</td>
			<td align="center">${ocdto.cancel_reason}</td>
		 </tr>
		 <tr> 
			<td align="center">상세사유</td>
			<td align="center">${ocdto.detail_reason}</td>
		 </tr>		
		 <tr> 
			<td align="center">수량</td>
			<td align="center">${ocdto.cancel_quantity}</td>
		 </tr>

		
		 <tr> 
			<td class="theadstyle" >관리자 승인여부</td>
			<td class="tbodystyle" align="center">
			 <select name="admin_approval_or_not" id='admin_approval_or_not'>
				<option value="1">취소승인</option>
				<option value="2">취소대기 </option>
			  </select>
				
			<script>	   
			$(function(){
			   $("#admin_approval_or_not").val(${ocdto.admin_approval_or_not})
			});
	  </script>
			</td>
		</tr>
		
		
		
		<tr> 
		<td colspan="2" align="center">
		<input type="button"  value="수정" size="3" onclick="javascript:updateOrderCancel('U')"> / 
		<input type="button" value="삭제" size="3" onclick="javascript:updateOrderCancel('D')">
		</td>
		</tr>
		</table>
		<input type="hidden" name="order_no" value="${ocdto.order_no}">
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