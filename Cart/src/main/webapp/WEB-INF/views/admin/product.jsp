<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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

	<a href="/Cart/admin/addNewProduct">Add New Product</a>
	<table border="1px">
		<tr>
			<th>Pid</th>
			<th>cid</th>
			<th>pname</th>
			<th>pdescription</th>
			<th>pprice</th>
			<th>pofferprice</th>
			<th>pimages</th>
			<th>publish</th>
			<th>Actions</th>

		</tr>

		<c:forEach items="${pl }" var="li">
			<tr>
				<td>${li.pid}</td>
				<td>${li.cid}</td>
				<td>${li.pname}</td>
				<td>${li.pdescription}</td>
				<td>${li.pprice}</td>
				<td>${li.pofferprice}</td>
				<td><img src="${pageContext.request.contextPath}/resources/img/products/${li.pimages}" height="100" width="100"> </td>
				<td>${li.publish}</td>
				<td>
					<a href="/Cart/admin/editProduct/${li.pid}">Edit</a>|<a href="/Cart/admin/deleteProduct/${li.pid}">Delete</a> 
				</td>
			</tr>
		</c:forEach>

	</table>
	
	<br /> <br />
	<c:forEach varStatus="i" begin="1" end="${totalPages }">
		<a href="/Cart/admin/product/<c:out value="${i.count }" />"><c:out value="${i.count }"></c:out></a>
	</c:forEach>
 


</body>
</html> --%>

<!-- block -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="headAndSidebar.jsp" />

<a href="/Cart/admin/addNewProduct"><button class="btn btn-info pull-right">Add New Product</button></a> <br />

<div class="block">
	<div class="navbar navbar-inner block-header">
		<div class="muted pull-left">Products</div>
		<div class="pull-right">
			<span class="badge badge-info">${totalProduct }</span>

		</div>
	</div>
	
	<div class="block-content collapse in">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Pid</th>
					<th>cid</th>
					<th>pname</th>
					<th>pdescription</th>
					<th>pprice</th>
					<th>pofferprice</th>
					<th>pimages</th>
					<th>publish</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${pl }" var="li">
					<tr>
						<td>${li.pid}</td>
						<td>${li.cid}</td>
						<td>${li.pname}</td>
						<td>${li.pdescription}</td>
						<td>${li.pprice}</td>
						<td>${li.pofferprice}</td>
						<td><img
							src="${pageContext.request.contextPath}/resources/img/products/${li.pimages}"
							height="100" width="100"></td>
						<td>${li.publish}</td>
						<td><a href="/Cart/admin/editProduct/${li.pid}"><button
									class="btn btn-info">Edit</button></a> <a
							href="/Cart/admin/deleteProduct/${li.pid}"><button
									class="btn btn-info">Delete</button></a></td>
					</tr>
				</c:forEach>



			</tbody>
		</table>
	</div>

	<div class="pagination text-center">
		<ul>
			<li><a href="#">Prev</a></li>
			<c:forEach varStatus="i" begin="1" end="${totalPages }">
				<li><a href="/Cart/admin/product/<c:out value="${i.count }" />"><c:out
						value="${i.count }"></c:out></a>
				</li>
			</c:forEach>
		<li><a href="#">Next</a></li>
		</ul>
	</div>


</div>
<!-- /block -->

</body>
</html>



