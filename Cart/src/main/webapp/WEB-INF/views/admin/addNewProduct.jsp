<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add New</title>
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
	<form:form action="submitNewProduct" method="POST" enctype="multipart/form-data" modelAttribute="product" >
		
		Category: <select name="cid" path="cid">
 					<c:forEach var="row" items="${cl}" > 
	 					<option value="${row.cid}" ${row.cid == cid ? 'selected' : ''}>${row.cname}</option>	
 					</c:forEach>
 				  </select><form:errors path="cid" cssStyle="color: #ff0000;"/><br />
		Product Name:<form:input path="pname"/><form:errors path="pname" cssStyle="color: #ff0000;"/> <br />
		Description: <form:input path="pdescription"/><form:errors path="pdescription" cssStyle="color: #ff0000;"/> <br />
		Price: <form:input path="pprice"/><form:errors path="pprice" cssStyle="color: #ff0000;"/> <br />
		Offer Price: <form:input path="pofferprice"/> <form:errors path="pofferprice" cssStyle="color: #ff0000;"/><br />
		Images:<form:input path="pimages" type="file"/><form:errors path="pimages" cssStyle="color: #ff0000;"/> <br />
	<%-- 	Images:<form:input path="pimages"/><form:errors path="pimages" cssStyle="color: #ff0000;"/> <br /> --%>
		Publish: <form:input path="publish"/><form:errors path="publish" cssStyle="color: #ff0000;"/> <br />
		
		<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
		
		<input type="submit" value="Add">
		
	
	</form:form>

 
 <%-- <form:errors path="product1.*" />
 	<form action="/Cart/admin/submitNewProduct" method="post" model="product1" >
 	
 		Category: <select name="cid" path="cid">
 					<c:forEach var="row" items="${cl}" > 
	 					<option value="${row.cid}" ${row.cid == cid ? 'selected' : ''}>${row.cname}</option>	
 					</c:forEach>
 				  </select><br />
 		Product Name: <input type="text" path="pname" name="pname"/><td><form:errors path="product1.pname" cssStyle="color: #ff0000;"/></td><br />
 		Description: <input type="text" path="pdescription" name="pdescription"  /> <br />
 		Price: <input type="text" path="pprice" name="pprice"  /><br />
 		Offer Price: <input type="text" path="pofferprice" name="pofferprice"  /><br />
 		Images: <input type="text" path="pimages" name="pimages"  /><br />
 		Publish: <input type="text" min="0" max="1" name="publish"  /><br />
 		
 		<input type="submit" value="Add" />
 		
 	</form>
 --%>
 

 	
 
</body>
</html>