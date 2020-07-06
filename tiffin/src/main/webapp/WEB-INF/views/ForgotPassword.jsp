<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<form:form  modelAttribute="loginBean"
		action="retrive" method="post">
		<table align="center">
			<tr>
				<td><form:label path="email">Email: </form:label></td>
				<td><form:input path="email" name="email" id="email" /></td>
			</tr>
			<tr>
				<td></td>
				<td align="left"><input type="submit" value="retrive" /></td>
			</tr>
		</table>
		</form:form>
</body>
</html>