<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Category List</title>
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

<br /><br />
	<a href="/Cart/admin/addCategory">Add New Category</a>
	


	<table border="1px">
		<tr>
			<th>cid</th>
			<th>cname</th>
			<th>cdescription</th>
			<th>cimage</th>
			<th>publish</th>
			<th>Actions</th>
		</tr>

		<c:forEach items="${cl}" var="li">
			<tr>
				<td>${li.cid}</td>
				<td>${li.cname}</td>
				<td>${li.cdescription}</td>
				<td>${li.cimage}</td>
				<td>${li.publish}</td>
				<td>
					<a href="/Cart/admin/editCategory?cid=${li.cid}">Edit</a>|<a href="/Cart/admin/deleteCategory?cid=${li.cid}">Delete</a> 
				</td>
			</tr>
		</c:forEach>

	</table>


</body>
</html>