<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	   <c:import url="Top.jsp"/>

	<table  style="height: 80%;">
	<tr> 
	<td>

		<table class="tableclass3" style="height: 80%; " >
		<thead >
			<tr> 
			<th  class="theadstyle">회원이름</th>
			<th  class="theadstyle">회원아이디 </th>
			<th  class="theadstyle">전화번호 </th>
			<th class="theadstyle">이메일 </th> 
			<th  class="theadstyle">주소 </th>
			<th  class="theadstyle">수정 </th>
			</tr>
		</thead>
		<tbody >
			<c:forEach var="mdto" items="${memberList}">
				<tr > 
				<td class="tbodystyle">${mdto.mem_name}</td>
				<td class="tbodystyle">${mdto.mem_id}</td>
				<td class="tbodystyle">${mdto.mem_mobile}</td>
				<td class="tbodystyle">${mdto.mem_email}</td>
				<td class="tbodystyle">${mdto.mem_address}</td>
<%-- 				<td class="tbodystyle"><a href="javascript:Update('${mdto.mem_id}')">수정하기</a></td> --%>
				<!-- 수정하기 버튼 잠시 주석처리  -->
				
				</tr>
			</c:forEach>
		</tbody>
		</table>
	</td>
	</tr>
	</table>
     <c:import url="Bottom.jsp"/>

<!--수정하기버튼 주석   -->
<!-- 	<form name="update" method="post" action="/memberUpdate"> -->
<!-- 	<input type=hidden name="mem_id"> -->
<%-- 	<c:set var="adminPro" value="mdto"/> --%>
<!-- 	</form> -->

</body>
</html>
