<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>datailView</title>
</head>
<body>
     <form action="detail" method="post">
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
      <td><input name="mem_name" size="50" maxlength="100"></td>
      <td>&nbsp;</td>
     </tr>
     <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
    <tr>
      <td>&nbsp;</td>
      <td align="center">아이디</td>
      <td><input name="mem_id" size="50" maxlength="50"></td>
      <td>&nbsp;</td>
     </tr>
      <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
    <tr>
      <td>&nbsp;</td>
      <td align="center">제목</td>
      <td><input name="board_subject" size="50" maxlength="50"></td>
      <td>&nbsp;</td>
     </tr>
     <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
     <tr>
      <td>&nbsp;</td>
      <td align="center">내용</td>
      <td><textarea name="board_content" cols="50" rows="13"></textarea></td>
      <td>&nbsp;</td>
     </tr>
     <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
     <tr height="1" bgcolor="#82B5DF"><td colspan="4"></td></tr>
     <tr align="center">
      <td>&nbsp;</td>
      <td colspan="2">
      
 
      <input type=submit value="수정" >  
     <input type=button value="취소">
      <td>&nbsp;</td>
     </tr>
   
    </table>
   </td>
  </tr>
 </table>
      </form>


</body>
</html>