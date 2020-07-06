<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>UserId</th>
			<th>UserName</th>
			<th>password</th>
			<th>address</th>
			<th>Email_Id</th>
			<th>City</th>
			<th>Contact No</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td><c:out value="${user.userId}"></c:out></td>
				<td><c:out value="${user.userName}"></c:out></td>
				<td><c:out value="${user.password}"></c:out></td>
				<td><c:out value="${user.address}"></c:out></td>
				<td><c:out value="${user.emailId}"></c:out></td>
				<td><c:out value="${user.city}"></c:out></td>
				<td><c:out value="${user.phone}"></c:out></td>
				<td><a href=""> Edit</a> | <a href="">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
