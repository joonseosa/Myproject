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
<!-- <script type="text/javascript"> -->
<!-- // 	$(function(){ -->
<!-- // 		$("#deleteBtn").click(function(){ -->
<!-- // 			if(confirm("삭제하시겠습니까?")){ -->
<%-- // 				window.location.href="/productMgrDeleteProc?item_no=${idto.item_no}"; --%>
<!-- // 			}else{ -->
<!-- // 				return false; -->
<!-- // 			} -->
<!-- // 		}); -->
<!-- // 	}); -->
<!-- </script> -->

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
			<th class="theadstyle" colspan="3"><font color="#FFFFFF">${iqdto.item_no}</font></th>
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
				<th class="tbodystyle" ><b>상품이름 : </b>${iqdto.inq_no}</th>
				</tr>			
				<tr>
				<td class="tbodystyle" ><b>상품문의 제목 : </b>${iqdto.inq_title}</td>
				</tr>
				<tr>
				<td class="tbodystyle" ><b>상품문의 등록일 : </b>${iqdto.inq_reg_date}</td>
				</tr>
				<tr>
				<td class="tbodystyle" ><b>REF : </b>${iqdto.inq_ref}</td>
				</tr>
				<tr>
				<td class="tbodystyle" ><b>상품번호 : </b>${iqdto.item_no}</td>
				</tr>
				<tr>
				<td class="tbodystyle" ><b>아이디 : </b>${iqdto.mem_id}</td>
				</tr>
				<tr>
				<td class="tbodystyle" ><b>질문번호 : </b>${iqdto.question_no}</td>
				</tr>
				</table>
			
			</td>
			<td class="tbodystyle" width="50%" valign="top"><b>내용</b><br><pre>${iqdto.inq_content}</pre></td>
			</tr>
			<tr> 
			<td class="tbtnstyle" colspan="3" align="center">
<%-- 			<a href="javascript:productUpdate('${pdto.no}','U')">수정하기</a>&nbsp;&nbsp;&nbsp;&nbsp; --%>
<%-- 			<a href="javascript:productUpdate('${pdto.no}','D')">삭제하기</a>&nbsp;&nbsp;&nbsp;&nbsp; --%>
			<a href="/ItemInquiryWrite?inq_no=${iqdto.inq_no}">답글</a>
			<a id="deleteBtn" style="cursor: pointer;" >상품삭제</a>

<!-- 		클릭을 했을때 java script alert 함수를 싷행시킨다 -->
			
			
			<a href="/ItemInquiry">목록으로</a>
			</td>
			</tr>
			</table>
		 </td>
		</tr>
		</table>
	      <c:import url="Bottom.jsp"/>
		</div>
	    </div>
	
	<form name="update" method="post" action="/ItemInquiryWrite">
	<input type=hidden name=no>
	</form>
<%--   </c:when> --%>
<%--   </c:choose> --%>
</body>
</html>

