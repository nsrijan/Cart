<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<jsp:include page="header.jsp"></jsp:include>

<%--  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Products</title>
</head>
<body>

 <a href="">Home</a> | <a href="/about">About</a> |<a href="productsHome/1">Products</a>|
        <a href="/Cart/admin">Admin</a>
	
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
				<td><img src="${pageContext.request.contextPath}/resources/images/products/${pl.pimages}" height="100" width="100"> </td>
				<td><a href="/Cart/buyersDetails?pid=${pl.pid}">Order Now</a></td>
				<td><a href="/Cart/addCustomerReview?pid=${pl.pid}">Add Review</a></td>
				
			</tr>
		</c:forEach>
		
	</table>
	
	<br /> <br />
	<c:forEach varStatus="i" begin="1" step="1" end="${totalPages }">
		<a href="/Cart/productsHome/<c:out value="${i.count }" />"><c:out value="${i.count }"></c:out></a>
	</c:forEach>
	
	
</body>
</html>
 --%>


<div class="product-big-title-area">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="product-bit-title text-center">
					<h2>Shop</h2>
				</div>
			</div>
		</div>
	</div>
</div>


<div class="single-product-area">
	<div class="zigzag-bottom"></div>
	<div class="container">
		<div class="row">

			<c:forEach items="${pl }" var="pl">

				<div class="col-md-3 col-sm-6">
					<div class="single-shop-product">
						<div class="product-upper">
							<img
								src="${pageContext.request.contextPath}/resources/img/products/${pl.pimages}"
								alt="">
						</div>
						<h2>
							<a href="/Cart/productDetails/${pl.pid }">${pl.pname }</a>
						</h2>
						<div class="product-carousel-price">
							<ins>${pl.pofferprice }</ins>
							<del>${pl.pofferprice }</del>
						</div>

						<div class="product-option-shop">
							<a class="add_to_cart_button" data-quantity="1"
								data-product_sku="" data-product_id="70" rel="nofollow"
								href="/canvas/shop/?add-to-cart=70">Add to cart</a>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>

		<div class="row">
			<div class="col-md-12">
				<div class="product-pagination text-center">
					<nav>
						<ul class="pagination">
							<li><a href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>
							<c:forEach varStatus="i" begin="1" step="1" end="${totalPages }">
								<li><a href="/Cart/productsHome/<c:out value="${i.count }" />">
									<c:out value="${i.count }" />
								</a></li>
							</c:forEach>
							<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
</div>


<jsp:include page="footer.jsp" />


<!-- Latest jQuery form server -->
<script src="https://code.jquery.com/jquery.min.js"></script>

<!-- Bootstrap JS form CDN -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<!-- jQuery sticky menu -->
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.sticky.js"></script>

<!-- jQuery easing -->
<script src="js/jquery.easing.1.3.min.js"></script>

<!-- Main Script -->
<script src="js/main.js"></script>
</body>
</html>
