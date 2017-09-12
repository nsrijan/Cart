<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Products</title>
</head>
<body>
	
	<h3>Products</h3>
	
	<table>
		<tr>
			<th>Pid</th>
			<th>Category</th>
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>Offer Price</th>
			<th>Images</th>
			<th>Order Now</th>
			<th>Add Review</th>
		</tr>
		
	<c:forEach items="${pl }" var="pl" >		
			<tr>
				<td>${pl.pid}</td>
				<td>${pl.cid}</td>
				<td>${pl.pname}</td>
				<td>${pl.pdescription}</td>
				<td>${pl.pprice}</td>
				<td>${pl.pofferprice}</td>
				<td>${pl.pimages}</td>
				<td><a href="buyersDetails?pid=${pl.pid}">Order Now</a></td>
				<td><a href="addCustomerReview?pid=${pl.pid}">Add Review</a></td>
			</tr>
		</c:forEach>
		
	</table>
	
	
</body>
</html>