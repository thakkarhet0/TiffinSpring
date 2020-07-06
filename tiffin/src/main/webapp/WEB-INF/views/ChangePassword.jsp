<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
	<form:form modelAttribute="changePasswordBean"
		action="updatePassword" method="post">
		<table align="center">
			<tr>
				<td><form:label path="oldPassword">Old Password: </form:label></td>
				<td><form:input path="oldPassword"   /></td>
			</tr>
			<tr>
				<td><form:label path="newPassword">New Password:</form:label></td>
				<td><form:password path="newPassword" name="newPassword"
						id="newPassword" /></td>
			</tr>
			<tr>
				<td><form:label path="confirmNewPassword">Confirm New Password:</form:label></td>
				<td><form:password path="confirmNewPassword" name="confirmNewPassword"
						id="confirmNewPassword" /></td>
			</tr>
			
			<tr>
				<td></td>
				<td align="left"><input type="submit" value="Update Password" /></td>
			</tr>
			<tr></tr>
			 
		</table>
	</form:form>
	${error }
</body>
</html>