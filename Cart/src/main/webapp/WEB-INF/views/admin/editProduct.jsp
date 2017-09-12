<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Product</title>
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
 	
 	<form:errors path="product.*" />
 	<form:form action="/Cart/admin/submitEditProduct" enctype="multipart/form-data" method="post" modelAttribute="product" >
 		
 		<form:hidden path="pid"/>
		<%--<input type="hidden" path="pid" name="pid" value="${myProduct.pid}"/><br />
 		 Category: <select name="cid" path="cid">
 					<c:forEach var="row" items="${cl}" > 
	 					<option value="${row.cid}" ${row.cid == cid ? 'selected' : ''}>${row.cname}</option>	
 					</c:forEach>
 				  </select><br />
 		Product Name: <input type="text" path="pname" name="pname" value="${myProduct.pname }"/><br />
 		Description: <input type="text" path="pdescription" name="pdescription" value="${myProduct.pdescription }" /> <br />
 		Price: <input type="text" path="pprice" name="pprice" value="${myProduct.pprice }" /><br />
 		Offer Price: <input type="text" path="pofferprice" name="pofferprice" value="${myProduct.pofferprice }" /><br />
 		Images: <input type="file" path="pimages" name="pimages" /><br />
 		Publish: <input type="text" min="0" max="1" name="publish" value="${myProduct.publish }" /><br /> --%>
 		
 		Category: <select name="cid" path="cid">
 					<c:forEach var="row" items="${cl}" > 
	 					<option value="${row.cid}" ${row.cid == cid ? 'selected' : ''}>${row.cname}</option>	
 					</c:forEach>
 				  </select><form:errors path="cid" cssStyle="color: #ff0000;"/><br />
		Product Name:<form:input path="pname"/><form:errors path="pname" cssStyle="color: #ff0000;"/> <br />
		Description: <form:input path="pdescription"/><form:errors path="pdescription" cssStyle="color: #ff0000;"/> <br />
		Price: <form:input path="pprice"/><form:errors path="pprice" cssStyle="color: #ff0000;"/> <br />
		Offer Price: <form:input path="pofferprice"/> <form:errors path="pofferprice" cssStyle="color: #ff0000;"/><br />
		<img src="${pageContext.request.contextPath}/resources/img/products/${pimages}" height="100" width="100"><br />
		Images:<form:input path="pimages" type="file" /><form:errors path="pimages" cssStyle="color: #ff0000;"/> <br />
		Publish: <form:input path="publish"/><form:errors path="publish" cssStyle="color: #ff0000;"/> <br />
 		
 		<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
 		
 		<input type="submit" value="Update" />
 		
	</form:form>
</body>
</html>