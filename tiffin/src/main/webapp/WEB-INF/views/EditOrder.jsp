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
	<s:form method="post" action="addorder"
		modelAttribute="orderBean">
		<s:hidden path="orderId"/>
	Order Name: <s:input path="orderName" />
		<s:errors path="orderName"></s:errors>
		<br>
	Order Description: <s:input path="orderDescription" />
		<s:errors path="orderDescription"></s:errors>
		<br>
		Order Status<s:checkbox path="orderStatus" />
		<s:errors path="orderStatus"></s:errors>
		<br>
		<input type="submit" value="Save" />
	</s:form>

</body>
</html>