<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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

	<!-- <p>
		View By: <select name="month">
			<option value="january">January</option>
			<option value="february">February</option>
			<option value="mars">Mars</option>
			<option value="april">April</option>
			<option value="may">May</option>
			<option value="june">June</option>
			<option value="july">July</option>
			<option value="august">August</option>
			<option value="september">September</option>
			<option value="october">October</option>
			<option value="november">November</option>
			<option value="december">December</option>
		</select>
	</p> -->
	
	<a href="/Cart/test/orderByDate?date=2017-01">January</a>|
	<a href="/Cart/test/orderByDate?date=2017-04">April</a>|
	<a href="/Cart/test/orderByDate?date=2017-05">May</a>

	<table border="1px">
		<tr>
			<th>Oid</th>
			<th>Pid</th>
			<th>Date</th>
			<th>Status</th>
			<th>buyerName</th>
			<th>buyerEmail</th>
		</tr>

		<c:forEach items="${listOrders }" var="li">
			<tr>
				<td>${li.oid}</td>
				<td>${li.pid}</td>
				<td><fmt:formatDate pattern="dd/MM/yyyy" value="${li.date}" /></td>
				<td>${li.status}</td>
				<td>${li.buyerName}</td>
				<td>${li.buyerEmail}</td>
			</tr>
		</c:forEach>

	</table>


</body>
</html>