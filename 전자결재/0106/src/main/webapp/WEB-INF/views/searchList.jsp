<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<c:choose>
					<c:when test="${not empty list}">
						<c:forEach items="${list}" var="list">
								<tr onclick ="location.href='detail?seq=${list.seq}'">
							 		<td>${list.seq}</td>
									<td>${list.memName}</td>
									<td>${list.apprSubject}</td>
									<td>${list.apprRegDate}</td>
									<td>${list.apprDate}</td>
									<td>${list.apprName}</td>
									<td>${list.apprStatusKor}</td>
								</tr>
							</c:forEach>
               		</c:when>
					<c:otherwise>
						 <tr>
						 		<td colspan="7">검색된 데이터가 없습니다</td>
						 </tr>
					</c:otherwise>
			</c:choose>



</body>
</html>