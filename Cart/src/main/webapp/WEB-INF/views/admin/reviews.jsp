<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reviews</title>
</head>
<body>

<ul>
		<li><a href="/Cart/">Home</a></li>
		<li><a href="/Cart/admin/orders">Order List</a></li>
		<li><a href="/Cart/admin/productStatus">Product Status</a></li>
		<li><a href="/Cart/admin/product/1">Products</a></li>
		<li><a href="/Cart/admin/category">Categories</a></li>
		<li><a href="/Cart/admin/reviews">Reviews</a></li>
	</ul>
<br /> <br />

<h2>All Reviews</h2>

<table border="1px">
	<tr>
		<th>Rid</th>
		<th>Pid</th>
		<th>REmail</th>
		<th>RPhone</th>
		<th>RDescription</th>
	</tr>
	
	<c:forEach items="${lr }" var="li" >		
		<tr>
			<td>${li.rid}</td>
			<td>${li.pid}</td>
			<td>${li.remail}</td>
			<td>${li.rphone}</td>
			<td>${li.rdescription}</td>
		</tr>
	</c:forEach>

</table>

</body>
</html>