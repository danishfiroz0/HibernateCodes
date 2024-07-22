<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${student != null || !empty student }">
			<table>
				<tr>
					<th>SID</th>
					<td>${student.sid}</td>
				</tr>
				<tr>
					<th>SID</th>
					<td>${student.sname}</td>
				</tr>
				<tr>
					<th>SID</th>
					<td>${student.sage}</td>
				</tr>
				<tr>
					<th>SID</th>
					<td>${student.saddress}</td>
				</tr>
			</table>
		</c:when>
		<c:otherwise>
			<h1 style='color:green; text-align: center;'>NO STUDENT FOUND</h1>
		</c:otherwise>
	</c:choose>
	
</body>
</html>