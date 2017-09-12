 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Make Order</title>
</head>
<body>

 <a href="">Home</a> | <a href="/about">About</a> |<a href="productsHome/1">Products</a>|
        <a href="admin">Admin</a>

	<form:errors path="order1.*" />
	<form:form action="/Cart/makeOrder" method="POST" modelAttribute="order1" >
	
		
		<input type="text" name="pid" path="pid" value="${myProduct.pid }" /><br />
		Product Name: <input type="text" name="pname" value="${myProduct.pname}" disabled /> <br />
		<input type="hidden" name="date" path="date" value="<%=new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())%>"/>
		<input type="hidden" name="status" path="status" value="false" />
		Name:<input type="text" name="buyerName" path="buyerName" value="${order1.buyerName }"/><form:errors path="buyerName" cssStyle="color: #ff0000;"/><br />
		Email: <input type="text" name="buyerEmail" path="buyerEmail" value="${order1.buyerEmail }"/><form:errors path="buyerEmail" cssStyle="color: #ff0000;"/><br />
		
		<input type="submit" value="Submit" />
		
		
	
	</form:form>
</body>
</html>