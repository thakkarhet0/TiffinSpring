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
			<th>OrderId</th>
			<th>OrderName</th>
			<th>OrderDescription</th>
			<th>OrderStatus</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${orders}" var="order">
			<tr>
				<td><c:out value="${order.orderId}"></c:out></td>
				<td><c:out value="${order.orderName}"></c:out></td>
				<td><c:out value="${order.orderDescription}"></c:out></td>
				<td><c:out value="${order.orderStatus}"></c:out></td>
				<td><a href=""> Edit</a> | <a href="">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>