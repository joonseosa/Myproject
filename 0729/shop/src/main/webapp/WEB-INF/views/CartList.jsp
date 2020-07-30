<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" 
     uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<title>Simple Shopping Mall</title>
<link href="./resources/css/main.css" 
             rel="stylesheet" type="text/css">
<script src="./resources/js/jquery-1.10.2.min.js"></script>
<script src="./resources/js/mainScript.js" charset="utf-8" type="text/javascript"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="./resources/js/zipCheck.js"></script>
</head>

<body>
<c:choose>
  <c:when test="${idKey==null}">
     <c:redirect url="/login"></c:redirect>
  </c:when>
  <c:when test="${idKey!=null}">
   <div class="tb_wrap">
   <div class ="tb_box">
	 <c:import url="Top.jsp"/>
    <table class="tb">
		<tr> 
			<td  class="tb2">
			  <table>
			   <thead>
				<tr> 
					<th  class="theadstyle"><font color="#FFFFFF">제품번호</font></th>
					<th  class="theadstyle"><font color="#FFFFFF">제품명</font></th>
					<th  class="theadstyle"><font color="#FFFFFF">가격</font></th>
					<th  class="theadstyle"><font color="#FFFFFF">수량</font></th>
					<th  class="theadstyle"><font color="#FFFFFF">수정 / 삭제</font></th>
					<th  class="theadstyle"><font color="#FFFFFF">조회</font></th>
				</tr>
				</thead>
                 <tbody >
						<c:choose> 
						  <c:when test="${fn:length(hCartList) >0}">
							<c:forEach var="cdto" items="${hCartList}">
								<tr > 
									<td class="tb2">${cdto.key}</td>
									<td class="tb2">${cdto.value.pname}</td>
									<td class="tb2">${cdto.value.price}</td>
									<td class="tb2">${cdto.value.quantity}</td>
									<td class="tb2">
									   <input type="button" value="수정" size="3" onclick="javascript:cartUpdate(this.form)"> /
									  <input type="button" value="삭제" size="3" onclick="javascript:cartDelete(this.form)">
									</td>
									<td class="tb2"><a href="javascript:shopMgrDetail('${cdto.value.product_no}')">상세보기</a></td>
								</tr>
							</c:forEach>
								    <tr >
								      <td class="tb2" colspan="6"><a href="/orderProc">주문하기</a></td>
									</tr>
						  </c:when>
						  <c:otherwise>
								    <tr >
								    <td class="tb2"colspan="6"> 선택한 상품이 없습니다.</td>
									</tr>
						  </c:otherwise>
						</c:choose>
						</tbody>
				   
				</table>
			</td>
		</tr>
	</table>
    <c:import url="Bottom.jsp"/> 
		<form name="detail" method="post" action="/productDetail" >
			<input type="hidden" name="no">
		 </form>	
	</div>
	</div>
    </c:when>
  </c:choose>	
</body>
</html>
