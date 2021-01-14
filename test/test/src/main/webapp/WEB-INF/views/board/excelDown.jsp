<%@ page language="java" contentType="application/vnd.ms-excel;charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%
	response.setHeader("Content-Disposition","attachment;filename=" + "exceltest.xls"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border = "1">
					<tr>
						<th><input type = "checkbox" name = "allChk" id = "allChk">전체</th>
						<th>번호</th>
						<th>작성자(ID)</th>
						<th>제목</th>
						<th>작성일</th>
						<th>수정일</th>
						<th>조회수</th>
					</tr>
					<c:forEach items="${modelList }" var = "i" varStatus="num">
						<tr>
							<td><input type = "checkbox" name = "chk" id = "chk${num.index}" value = "${i.seq }"></td>
							<td>${i.seq }</td>
							<td>${i.memName }(${i.memId })</td>
							<td><a href = "detail?seq=${i.seq }">${i.boardSubject }</a></td>
							<td>${i.regDate }</td>
							<td>${i.uptDate }</td>
							<td>${i.viewCnt }</td>
						</tr>
					</c:forEach>
				</table>
</body>
</html>