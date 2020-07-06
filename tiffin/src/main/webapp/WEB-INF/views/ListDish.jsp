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
			<th>DishId</th>
			<th>DishName</th>
			<th>DishDescription</th>
			<th>Status</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${dishes}" var="dish">
			<tr>
				<td><c:out value="${dish.dishId}"></c:out></td>
				<td><c:out value="${dish.dishName}"></c:out></td>
				<td><c:out value="${dish.dishDescription}"></c:out></td>
				<td><c:out value="${dish.dishactive}"></c:out></td>
				<td><a href="editdish/${dish.dishId }"> Edit</a> | <a href="deletedish/${dish.dishId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>