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
	<s:form method="post" action="../updatecategory"
		modelAttribute="categoryBean">
		
		<s:hidden path="categoryId"/>
	ADD CATEGORY: <s:input path="categoryName" />
		<s:errors path="categoryName"></s:errors>
		<br>
		Is Active:<s:checkbox path="active" />
		<s:errors path="active"></s:errors>
		<br>
		<input type="submit" value="Save" />
	</s:form>
</body>
</html>