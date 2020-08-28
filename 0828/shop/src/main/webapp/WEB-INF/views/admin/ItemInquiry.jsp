<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<html>
<head>
<title>Admin Page </title>
<link href="../resources/css/main.css" 
             rel="stylesheet" type="text/css">
<script src="../resources/js/jquery-1.10.2.min.js"></script>
<script src="../resources/js/mainScript.js" charset="utf-8" type="text/javascript"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="../resources/js/zipCheck.js"></script>
</head>
 
<body>
<c:choose>
<%--   <c:when test="${idKey==null}"> --%>
<%--      <c:redirect url="/login"></c:redirect> --%>
<%--   </c:when> --%>
  <c:when test="${idKey==null}">
	<div class="tb_wrap">
	  <div class ="tb_box">
		 <c:import url="Top.jsp"/>
		<table class="tb">
			<tr> 
				<td  class="tb2">
				  <table>
				   <thead>
					<tr>
					<p style="font-size:24px; font-family:sans-serif; font-weight:bold;">Admin Page- 상품문의 관리 </p>
					</tr>
					
					<tr> 
						<th  class="theadstyle" style="border: 1px solid;"><font color="#FFFFFF">상품문의번호</font></th>
						<th  class="theadstyle"  style="border: 1px solid;"><font color="#FFFFFF">상품문의제목</font></th>
						<th  class="theadstyle" style="border: 1px solid;"><font color="#FFFFFF">상품문의내용</font></th>
						<th  class="theadstyle" style="border: 1px solid;"><font color="#FFFFFF">상품문의 날짜</font></th>
						<th  class="theadstyle" style="border: 1px solid;"><font color="#FFFFFF">REF</font></th>
						<th  class="theadstyle" style="border: 1px solid;"><font color="#FFFFFF">상품번호</font></th>
						<th  class="theadstyle" style="border: 1px solid;"><font color="#FFFFFF">아이디</font></th>
					</tr>
					
					</thead>
	                 <tbody >
							<c:choose> 
							  <c:when test="${fn:length(iteminquiryList) >0}">
								<c:forEach var="iqdto" items="${iteminquiryList}">
									<tr > 
										<td class="tbodystyle">${iqdto.inq_no}</td>
										<td class="tbodystyle">${iqdto.inq_title}</td>
										<td class="tbodystyle">${iqdto.inq_content}</td>
										<td class="tbodystyle">${iqdto.inq_reg_date}</td>
										<td class="tbodystyle">${iqdto.inq_ref}</td>
										<td class="tbodystyle">${iqdto.item_no}</td>
										<td class="tbodystyle">${iqdto.mem_id}</td>
										<td><a href="/ItemInquiryDetail?inq_no=${iqdto.inq_no}">상세보기</a></td>
									
									</tr>
								</c:forEach>
							  </c:when>
							  <c:otherwise>
									    <tr >
										   <td class="tb2" colspan="5"> 등록된 상품문의가 없습니다.</td>
										</tr>
							  </c:otherwise>
							</c:choose>
							 <tr>
<!-- 					     	    <td colspan="5" class="tb2 "><a href="productInsert">답변등록</a></td> -->
					          </tr>
							</tbody>
					   
					</table>
				</td>
			</tr>
		</table>
	<table>
					<h1 style="text-align: center">
						<a href="/ItemInquiry?presentPage=1" style="color: black;font-size:0.7em;"> [start] </a>
						<c:if test="${pdto.presentPage!=1}">
							<a href="/ItemInquiry?presentPage=${pdto.presentPage-1}" style="color: black;font-size:0.7em;"> < 
						</c:if>
						</a>
						<c:forEach var="i" begin="${pdto.startPage}" end="${pdto.endPage}">
							<c:if test="${pdto.presentPage==i}">
								<a href="/ItemInquiry?presentPage=${i}"><span
									style="color: red;font-size:0.7em;"><c:out value="[${i}]" /></span></a>
							</c:if>
							<c:if test="${pdto.presentPage!=i}">
								<a href="/ItemInquiry?presentPage=${i}" style="color: black;font-size:0.7em;"><c:out value="[${i}]" /></a>
							</c:if>
						</c:forEach>
						<c:if test="${pdto.presentPage!=pdto.endPage}">
							<a href="/ItemInquiry?presentPage=${pdto.presentPage+1}" style="color: black;font-size:0.7em;"> > 
						</c:if>
						</a> <a href="/ItemInquiry?presentPage=${pdto.allPage}" style="color: black;font-size:0.7em;"> [end] </a>
					</h1>
				</table>
	   <c:import url="Bottom.jsp"/>
		</div>
		</div>
		<form name="detail" method="post" action="ItemInquiryDetail" >
		  <input type="hidden" name="inq_no">
		</form>
  </c:when>
</c:choose>

</body>
</html>