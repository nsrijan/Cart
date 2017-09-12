<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Category</title>
</head>
<body>

<ul>
		<li><a href="/Cart/">Home</a></li>
		<li><a href="admin/orders">Order List</a></li>
		<li><a href="admin/productStatus">Product Status</a></li>
		<li><a href="admin/product/1">Products</a></li>
		<li><a href="admin/category">Categories</a></li>
		<li><a href="admin/reviews">Reviews</a></li>
	</ul>
<br /> <br />
<form:errors path="category1.*" />	
	<form action="submitEditCategory" method="post" model="category1">
		<input type="hidden" name="cid" value="${myCategory.cid }"/> <br />
		Category Name: <input type="text" name="cname" value="${myCategory.cname }" /> <br />
		Description: <input type="text" name="cdescription" value="${myCategory.cdescription }" /> <br />
		Category Image: <input type="text" name="cimage" value="${myCategory.cimage }" /> <br />
		Publish: <input	type="text" min="0" max="1" name="publish" value="${myCategory.publish }" /> <br />
		
		<input type="submit" value="Add" />

	</form>

</body>
</html>