<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Admin Page</title>
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
		<form method="post" action="productMgrProc" enctype="multipart/form-data">
		     <table class="tableclass3">
				<thead >
					<tr > 
					<th colspan="2" class="theadstyle" ><font color="#FFFFFF">상품 등록</font></th>
					</tr>
				</thead>
				<tbody style="height: 90%;">
					<tr> 
						<td class="tbodystyle" width="20%" >상품번호</td>
						<td class="tbodystyle"><input type="text" name="item_no" size="20" class="null_check"></td>
					</tr>
					<tr> 
						<td class="tbodystyle">상품원가</td>
						<td class="tbodystyle"><input type="text" name="item_first_price" size="20" class="null_check">원</td>
					</tr>
					<tr>
						<td class="tbodystyle">할인판매가격</td>
						<td class="tbodystyle"><input type="text" name="item_discount" size="20" class="null_check">원</td>
						
					</tr>
					<tr>
					<td class="tbodystyle">상품설명</td>
						<td class="tbodystyle"><textarea rows="10" cols="80" name="item_descripttion"></textarea></td>
					</tr>
					
					
					
					<tr> 
						<td class="tbodystyle">상품명</td>
						<td class="tbodystyle"><input type="text" name="item_name" size="20" class="null_check"></td>
					</tr>
					<tr> 
						<td class="tbodystyle">재고</td>
						<td class="tbodystyle"><input type="text" name="item_stock" size="10" class="null_check">개</td>
					</tr>
					<tr> 
						<td class="tbodystyle">이미지첨부 </td>
						<td class="tbodystyle"><input type="file" name="item_thumbnail2"  SIZE = "30" style="height: 25PX" class="null_check"></td>
					</tr>
					<tr > 
						<th colspan="2" class="tbtnystyle"> 
						<!-- chk title기입 -->
						<button type="submit" id ="inputCheck">상품등록</button> 
							&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
						<button type="reset">다시쓰기 </button>
						</th>
					</tr>
				</tbody>
			</table>
		</form>
	
     	</td>
	  </tr>
	</table>

     <c:import url="Bottom.jsp"/>
   </div>
  </div>
</body>
</html>

