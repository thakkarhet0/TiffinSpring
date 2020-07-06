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
	<s:form method="post" action="../updatedish"
		modelAttribute="dishBean">
		<s:hidden path="dishId"/>
	ADD Dish: <s:input path="dishName" />
		<s:errors path="dishName"></s:errors>
		<br>
	Dish Description: <s:input path="dishDescription" />
		<s:errors path="dishDescription"></s:errors>
		Is Active:<s:checkbox path="dishactive" />
		<s:errors path="dishactive"></s:errors>
		<br>
		<input type="submit" value="Save" />
	</s:form>
</body>
</html>