<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Review</title>
</head>
<body>

 <a href="">Home</a> | <a href="/about">About</a> |<a href="productsHome/1">Products</a>|
        <a href="admin">Admin</a>

	<form action="customerReviewAdded" method="post" model="customerReview">
		
		Product Name: <input type="text" name="pid" value="${pid}" readonly="readonly" /> <br />
		Email: <input type="text" name="remail" value="${customerReview.remail }"/> <form:errors path="customerReview.remail" cssStyle="color: #ff0000;"/><br />
		Name: <input type="text" name="rname" value="${customerReview.rname }"/> <form:errors path="customerReview.rname" cssStyle="color: #ff0000;"/><br />
		Phone: <input type="text" name="rphone" value="${customerReview.rphone }"/> <form:errors path="customerReview.rphone" cssStyle="color: #ff0000;"/><br />
		Description: <textarea name="rdescription" value="${customerReview.rdescription }" cols="20" rows=5></textarea> <form:errors path="customerReview.rdescription" cssStyle="color: #ff0000;"/><br /> 
		Publish: <input type="text" name="publish" value="false"/><form:errors path="customerReview.publish" cssStyle="color: #ff0000;"/><br />
		
		<input type="submit" value="Submit" />
		
		
	</form>

</body>
</html>