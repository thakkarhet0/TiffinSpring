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
			<th>SubcategoryId</th>
			<th>SubcategoryName</th>
			<th>CategoryName</th>
			<th>subcategoryDescription</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${subcategorys}" var="subcategory">
			<tr>
				<td><c:out value="${subcategory.subcategoryId}"></c:out></td>
				<td><c:out value="${subcategory.subcategoryName}"></c:out></td>
				<td><c:out value="${subcategory.categoryName}"></c:out></td>
				<td><c:out value="${subcategory.subcategoryDescription}"></c:out></td>
				<td><a href="editsubcategory/${subcategory.subcategoryId }"> Edit</a> | <a href="deletesubcategory/${subcategory.subcategoryId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>