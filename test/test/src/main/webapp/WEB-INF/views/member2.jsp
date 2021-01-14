<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<form>
 <table width="1400" height="650">
  <tr>
   <td width="100%" height="10%">회원가입
   </td>
  </tr>
  <tr>
   <td height="60%" align="center" valign="top">
   <hr><br>
   <p align="left" style="padding-left:160px">
   <br><br>
   ID : <input type="text" size="10" maxlength="15" name="id" id = "id" placeholder="아이디 입력" >
         <input type = "button" name = "idChk" id="idChk" value = "중복체크" onclick="check()">
  	

   <br><br>
   비밀번호 : <input type="password" size="15" maxlength="20" name="pass" id = "pw"><br><br>
   비밀번호 확인 : <input type="password" size="15" maxlength="20" name="pass2" id = "pw2"><br><br>
   이름 : <input type="text" size="13" name="name" id = "nm" onkeyup="fncNameKeyUp(this)"><br><br>
   이메일 : <input type="text" size="15" name="email1" id = "em1">@<input type="text" size="15" name="email2" id = "em2"><br><br>
   휴대폰 : <select name="ph1">
       <option value="010">010</option>
       <option value="011">011</option>
       <option value="016">016</option>
       <option value="017">017</option>
       <option value="019">019</option>
     </select>
     - <input type="text" name="ph2" size="5" maxlength="4" id = "ph2"> - <input type="text" name="ph3" size="5" maxlength="4" id = "ph3"><br><br>
   성별 : <input type="radio" name="gender" value="남자"> 남자&nbsp;&nbsp;
   <input type="radio" name="gender" value="여자"> 여자<br><br>
   주민번호 : <input type = "text" name = "jumin1" id = "jumin1"> -  <input type = "password" name = "jumin2" id = "jumin2"><br><br>
   주소 : <input type="text" name="address" size="15" maxlength="15"><br>
   *주소는 (시/도)만 입력해주세요 (예: 경기도, 서울특별시, 경상남도 등)
   </p>
  </td>
  </tr>
  <tr>
   <td align="center">
   <hr><br>
    <input type="button"  id = "regi_btn" value="가입신청" onclick="pwCheck()">&nbsp;
    <input type="reset" value="다시입력">&nbsp;
    <input type="button" value="취소">
   </td>
  </tr>
 </table>
</form>
<script src="/resources/Check.js"></script>
</body>
</html>