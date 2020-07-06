<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
			<th>TiffinId</th>
			<th>TiffinName</th>
			<th>TiffinDescription</th>
			<th>Amount</th>
			<th>TiffinStatus</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${tiffins}" var="tiffin">
			<tr>
				<td><c:out value="${tiffin.tiffinId}"></c:out></td>
				<td><c:out value="${tiffin.tiffinName}"></c:out></td>
				<td><c:out value="${tiffin.tiffinDescription}"></c:out></td>
				<td><c:out value="${tiffin.amount}"></c:out></td>
				<td><c:out value="${tiffin.tiffinActive}"></c:out></td>
				<td><a href="edittiffin/${tiffin.tiffinId}"> Edit</a> | <a href="deletetiffin/${tiffin.tiffinId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>