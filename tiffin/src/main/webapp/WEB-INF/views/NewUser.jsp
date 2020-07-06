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
	<s:form method="post" action="adduser"
		modelAttribute="userBean">
	UserName: <s:input path="userName" />
		<s:errors path="userName"></s:errors>
		<br>
	Password: <s:password path="password"/>
		<br>
	Email_id:<s:input path="emailId"/>
	<br>
	Address: <s:input path="address"/>
	<br>
	City: <s:input path="city"/>
	<br>
	Contact No: <s:input path="phone"/>		
		<input type="submit" value="Save" />

  <s:select path="roleId">
  		<s:option value="1">Admin</s:option>
  		<s:option value="2">User</s:option>
  		<s:option value="3">DelBoy</s:option>
  <s:option value="4">Vendor</s:option>
  </s:select>
	</s:form>

</body>
</html>