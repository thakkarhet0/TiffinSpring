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
			<th>CategoryId</th>
			<th>CategoryName</th>
			<th>active</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${categories}" var="category">
			<tr>
				<td><c:out value="${category.categoryId}"></c:out></td>
				<td><c:out value="${category.categoryName}"></c:out></td>
				<td><c:out value="${category.active}"></c:out></td>
				<td><a href="editcategory/${category.categoryId }"> Edit</a> | <a href="deletecategory/${category.categoryId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>