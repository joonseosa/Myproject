<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>

<title>Simple Shopping Mall Admin</title>
<link href="../resources/css/main.css"  rel="stylesheet" type="text/css">
<script src="../resources/js/jquery-1.10.2.min.js"></script>
<script src="../resources/js/mainScript.js" charset="utf-8" type="text/javascript"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="../resources/js/zipCheck.js"></script>
<script type="text/javascript">
	$(function(){
		$("#deleteBtn").click(function(){
			if(confirm("삭제하시겠습니까?")){
				window.location.href="/productMgrDeleteProc?item_no=${idto.item_no}";
			}else{
				return false;
			}
		});
	});
</script>

</head>

<body>
<%-- <c:choose> --%>
<%--   <c:when test="${adminDto==null}"> --%>
<%--      <c:redirect url="/login"></c:redirect> --%>
<%--   </c:when> --%>
<%--   <c:when test="${adminDto!=null}"> --%>
	 <div class="tb_wrap">
	  <div class ="tb_box">
		<c:import url="Top.jsp"/>
		<table class="tb">
		<tr> 
		 <td class="tb2">
	
			<table>
			<tr> 
			<th class="theadstyle" colspan="3"><font color="#FFFFFF">${idto.item_name}</font></th>
			</tr>
			<tr> 
			<td class="tbodystyle" width="20%">
		
<%-- 			<img src="./study/thumbnail/${idto.item_thumbnail}" height="150" width="150"> --%>
<%-- 				<img src="/img/thumbnail/${idto.item_thumbnail}" height="150" width="150"> --%>
				<img src="/img/thumbnail/${idto.item_thumbnail}" height="150" width="150">
			  </td>
			  <td class="tbodystyle" width="30%" >
	
				<table>
				<tr>
				<th class="tbodystyle" ><b>상품이름 : </b>${idto.item_name}</th>
				</tr>			
				<tr>
				<td class="tbodystyle" ><b>가    격 : </b>${idto.item_first_price}</td>
				</tr>
				<tr>
				<td class="tbodystyle" ><b>등록일자 : </b>${idto.reg_date}</td>
				</tr>
				<tr>
				<td class="tbodystyle" ><b>재    고 : </b>${idto.item_stock}</td>
				</tr>
				</table>
			
			</td>
			<td class="tbodystyle" width="50%" valign="top"><b>상세설명</b><br><pre>${idto.item_descripttion}</pre></td>
			</tr>
			<tr> 
			<td class="tbtnstyle" colspan="3" align="center">
<%-- 			<a href="javascript:productUpdate('${pdto.no}','U')">수정하기</a>&nbsp;&nbsp;&nbsp;&nbsp; --%>
<%-- 			<a href="javascript:productUpdate('${pdto.no}','D')">삭제하기</a>&nbsp;&nbsp;&nbsp;&nbsp; --%>
			<a href="/productUpdate?item_no=${idto.item_no}">상품수정</a>
			<a id="deleteBtn" style="cursor: pointer;" >상품삭제</a>

<!-- 		클릭을 했을때 java script alert 함수를 싷행시킨다 -->
			
			
			<a href="/ProductMgr">목록으로</a>
			</td>
			</tr>
			</table>
		 </td>
		</tr>
		</table>
	      <c:import url="Bottom.jsp"/>
		</div>
	    </div>
	
	<form name="update" method="post" action="/productUpdate">
	<input type=hidden name=no>
	</form>
<%--   </c:when> --%>
<%--   </c:choose> --%>
</body>
</html>

