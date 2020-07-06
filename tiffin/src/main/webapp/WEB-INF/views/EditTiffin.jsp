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
	<s:form method="post" action="../updatetiffin"
		modelAttribute="tiffinBean">
		<s:hidden path="tiffinId"/>
	Tiffin Name: <s:input path="tiffinName" />
		<s:errors path="tiffinName"></s:errors>
		<br>
	Tiffin Description: <s:input path="tiffinDescription" />
		<s:errors path="tiffinDescription"></s:errors>
		<br>
	Amount : <s:input path="amount"/>
			 <s:errors path="amount"></s:errors>
		<br>	 	
		Tiffin Status<s:checkbox path="tiffinActive" />
		<s:errors path="tiffinActive"></s:errors>
		<br>
		<input type="submit" value="Save" />
	</s:form>
</body>
</html>