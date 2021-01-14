<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>writeView</title>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>
<script>
 	$(function(){
 		
		$("#insertBtn").click(function(){
			$("#writeFrm").attr("action","write").attr("method","post").submit();
		})
		
		$("#updateBtn").click(function(){
			$("#writeFrm").attr("action","update").attr("method","post").submit();
		})
 	})
	 
</script>

</head>
<body>
     <form name="writeFrm" id="writeFrm">
<table>
	<tr>
		<td>
    <table width="100%" cellpadding="0" cellspacing="0" border="0">
      <td>글쓰기</td>
     </tr>
    </table>
   <table>
     <tr>
      <td>&nbsp;</td>
      <td align="center">작성자</td>
      <td><input name="mem_name" value="${map.memName}" size="50" maxlength="100"></td>
  <td>&nbsp;</td>
 </tr>
 <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
<tr>
  <td>&nbsp;</td>
  <td align="center">아이디</td>
  <td><input name="mem_id" value="${map.memId}" size="50" maxlength="50"></td>
  <td>&nbsp;</td>
 </tr>
  <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
<tr>
  <td>&nbsp;</td>
  <td align="center">제목</td>
  <td><input name="board_subject" value="${map.boardSubject}" size="50" maxlength="50"></td>
 <td>&nbsp;</td>
</tr>
<tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
<tr>
 <td>&nbsp;</td>
 <td align="center">내용</td>
 <td><textarea name="board_content" cols="50" rows="13">${map.boardContent}</textarea></td>
 <td>&nbsp;</td>
</tr>
<tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
<tr height="1" bgcolor="#82B5DF"><td colspan="4"></td></tr>
<tr align="center">
 <td>&nbsp;</td>
 <td colspan="2">
<c:choose>
<c:when test="${empty map}">
<input type="button" id="insertBtn" value="등록" >  
</c:when>
<c:otherwise>
<input type="button" id="updateBtn" value="수정" >  
  <input type="hidden" name="seq" value="${map.seq}">

</c:otherwise>
</c:choose>
 
<input type=button value="취소" onclick="location.href='list'">
     <td>&nbsp;</td>
    </tr>
  
   </table>
  </td>
 </tr>
</table>
     </form>


</body>
</html>