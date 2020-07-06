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
			<th>DeliveryId</th>
			<th>DeliveryName</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${deliverys}" var="delivery">
			<tr>
				<td><c:out value="${delivery.deliveryId}"></c:out></td>
				<td><c:out value="${delivery.deliveryName}"></c:out></td>
				<td><c:out value="${delivery.deliveryStatus}"></c:out></td>
				<td><a href=""> Edit</a> | <a href="">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>