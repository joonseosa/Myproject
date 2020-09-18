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
    <form name="delete" method="post" action="/memberdelete">
		<table class="tableclass3" style="height: 80%; " >
		<thead >
			
			<tr>
			<p style="font-size:24px; font-family:sans-serif; font-weight:bold;">Admin Page- 회원관리 </p>
			</tr>
			
			<tr> 
			<th  class="theadstyle">회원이름</th>
			<th  class="theadstyle">회원아이디 </th>
			<th  class="theadstyle">전화번호 </th>
			<th class="theadstyle">이메일 </th> 
			<th  class="theadstyle">주소 </th>
			<th  class="theadstyle"><button type="button" class="selectDelete_btn">회원삭제</button>
			<script type="text/javascript">
			$(".selectDelete_btn").click(function(){
				var confirm_val=confirm("정말 삭제하시겠습니까?")
				if(confirm_val){
					var checkArr = new Array();
					$("input:checkbox[name=mem_id]:checked").each(function(){
						checkArr.push($(this).val());
					});
					location.href="/memberdelete?checkArr="+checkArr;
				}
			});
			</script>
				
			
			
			

			
			
			
			
						
			
			</th>
			</tr>
		</thead>
		<tbody >
			<c:forEach var="mdto" items="${memberList}">
				<tr > 
				<td class="tbodystyle"><input type="checkbox" class="chBox"  name="mem_id" value="${mdto.mem_id}">${mdto.mem_name}</td>
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
		</form>
		
	</td>
	</tr>
	</table>
	<table>
					<h1 style="text-align: center">
						<a href="/MemberMgr?presentPage=1" style="color: black;font-size:0.7em;"> [start] </a>
						<c:if test="${pdto.presentPage!=1}">
							<a href="/MemberMgr?presentPage=${pdto.presentPage-1}" style="color: black;font-size:0.7em;"> < 
						</c:if>
						</a>
						<c:forEach var="i" begin="${pdto.startPage}" end="${pdto.endPage}">
							<c:if test="${pdto.presentPage==i}">
								<a href="/MemberMgr?presentPage=${i}"><span
									style="color: red;font-size:0.7em;"><c:out value="[${i}]" /></span></a>
							</c:if>
							<c:if test="${pdto.presentPage!=i}">
								<a href="/MemberMgr?presentPage=${i}" style="color: black;font-size:0.7em;"><c:out value="[${i}]" /></a>
							</c:if>
						</c:forEach>
						<c:if test="${pdto.presentPage!=pdto.endPage}">
							<a href="/MemberMgr?presentPage=${pdto.presentPage+1}" style="color: black;font-size:0.7em;"> > 
						</c:if>
						</a> <a href="/MemberMgr?presentPage=${pdto.allPage}" style="color: black;font-size:0.7em;"> [end] </a>
					</h1>
				</table>
	
     <c:import url="Bottom.jsp"/>

<!--수정하기버튼 주석   -->
<!-- 	<form name="update" method="post" action="/memberUpdate"> -->
<!-- 	<input type=hidden name="mem_id"> -->
<%-- 	<c:set var="adminPro" value="mdto"/> --%>
<!-- 	</form> -->

</body>
</html>
