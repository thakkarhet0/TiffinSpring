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
	<s:form method="post" action="../updaterole"
		modelAttribute="roleBean">
		<s:hidden path="roleId"/>
	RoleName: <s:input path="roleName" />
		<s:errors path="roleName"></s:errors>
		<br>
		<input type="submit" value="Save" />

	</s:form>
	
</body>
</html>