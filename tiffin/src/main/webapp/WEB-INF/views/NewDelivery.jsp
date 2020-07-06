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
	<s:form method="post" action="adddelivery"
		modelAttribute="deliveryBean">
	ADD Delivery Name: <s:input path="deliveryName" />
		<s:errors path="deliveryName"></s:errors>
		<br>
		Delivery Status<s:select path="deliveryStatus">
				<s:option value ="1" >order</s:option>
		 </s:select>
		<s:errors path="deliveryStatus"></s:errors>
		<br>
		<input type="submit" value="Save" />
	</s:form>
</body>
</html>