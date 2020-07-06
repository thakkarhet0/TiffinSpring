<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:form method="post" action="../updatesubcategory"
		modelAttribute="subcategoryBean">
		<s:hidden path="subcategoryId"/>
		Category:	
		<s:select path="categoryId">
			<s:options items="${categories}"  itemLabel="categoryName" itemValue="categoryId" />
		</s:select>
		<br>
	SubcategoryName: <s:input path="subcategoryName" />
		<s:errors path="subcategoryName"></s:errors>
<br>	SubcategoryDescription: <s:input path="subcategoryDescription" />
		<s:errors path="subcategoryDescription"></s:errors>
		<br>
		<input type="submit" value="Save" />
	</s:form>
</body>
</html>