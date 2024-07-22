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
			<form method="post" action="./controller/updateform">
		        <div class="container">
		            <div class="form-group">
		                <label for="sid">SID</label>
		                <input type="text" readonly="readonly" name="sid" value="${student.sid } id="sid" />
		            </div>
		            <div class="form-group">
		                <label for="sid">SNAME</label>
		                <input type="text" name="sid" value="${student.sname } "id="sname" />
		            </div>
		            <div class="form-group">
		                <label for="sid">SAGE</label>
		                <input type="text" name="sid" value="${student.sage } id="sage" />
		            </div>
		            <div class="form-group">
		                <label for="sid">SADDRESS</label>
		                <input type="text"  name="sid" value="${student.saddress }id="saddress" />
		            </div>
		            <div class="form-group">
		                <input type="submit" value="update" />
		            </div>
		        </div>
    			</form>
		</c:when>
		<c:otherwise>
			<h1 style='color:green; text-align: center;'>NO STUDENT FOUND</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>