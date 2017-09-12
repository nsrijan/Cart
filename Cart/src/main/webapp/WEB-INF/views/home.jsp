<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header.jsp"></jsp:include>

<!-- <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p>This is the homepage!</p>
        
        <a href="/">Home</a> | <a href="/about">About</a> |<a href="productsHome/1">Products</a>|
        <a href="admin">Admin</a>
        
    </body>
</html> -->



<div class="slider-area">
	<!-- Slider -->
	<div class="block-slider block-slider4">
		<ul class="" id="bxslider-home4">

			<c:forEach items="${pl }" var="pl">

				<li><a href="/Cart/productDetails/${pl.pid }"><img
					src="${pageContext.request.contextPath}/resources/img/products/${pl.pimages}"
					alt="Slide" height="192px" ></a>
					<div class="caption-group">
						<h2 class="caption title">
							${pl.pname } <span class="primary">6 <strong>Plus</strong></span>
						</h2>
						<h4 class="caption subtitle">${pl.pdescription }</h4>
						<a class="caption button-radius" href="#"><span class="icon"></span>Shop
							now</a>
					</div></li>

			</c:forEach>

		</ul>
	</div>
	<!-- ./Slider -->
</div>

<div class="promo-area">
	<div class="zigzag-bottom"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-sm-6">
				<div class="single-promo promo1">
					<i class="fa fa-refresh"></i>
					<p>30 Days return</p>
				</div>
			</div>
			<div class="col-md-3 col-sm-6">
				<div class="single-promo promo2">
					<i class="fa fa-truck"></i>
					<p>Free shipping</p>
				</div>
			</div>
			<div class="col-md-3 col-sm-6">
				<div class="single-promo promo3">
					<i class="fa fa-lock"></i>
					<p>Secure payments</p>
				</div>
			</div>
			<div class="col-md-3 col-sm-6">
				<div class="single-promo promo4">
					<i class="fa fa-gift"></i>
					<p>New products</p>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- End promo area -->

<div class="maincontent-area">
	<div class="zigzag-bottom"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="latest-product">
					<h2 class="section-title">Latest Products</h2>
					<div class="product-carousel">

						<c:forEach items="${pl }" var="pl">

							<div class="single-product" style="width: 205px; height: 255px;">
								<div class="product-f-image">
									<img
										src="${pageContext.request.contextPath}/resources/img/products/${pl.pimages}"
										alt="">
									<div class="product-hover">
										<a href="#" class="add-to-cart-link"><i
											class="fa fa-shopping-cart"></i> Add to cart</a>
											<a
											href="single-product.html" class="view-details-link"><i
											class="fa fa-link"></i> See details</a>
									</div>
								</div>

								<h2>
									<a href="/Cart/productDetails/${pl.pid }">${pl.pname}</a>
								</h2>

								<div class="product-carousel-price">
									<ins>${pl.pofferprice }</ins>
									<del>${pl.pprice}</del>
								</div>
							</div>

						</c:forEach>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- End main content area -->

<div class="brands-area">
	<div class="zigzag-bottom"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="brand-wrapper">
					<div class="brand-list">
						<img
							src="${pageContext.request.contextPath}/resources/img/brand1.png"
							alt=""> <img
							src="${pageContext.request.contextPath}/resources/img/brand2.png"
							alt=""> <img
							src="${pageContext.request.contextPath}/resources/img/brand3.png"
							alt=""> <img
							src="${pageContext.request.contextPath}/resources/img/brand4.png"
							alt=""> <img
							src="${pageContext.request.contextPath}/resources/img/brand5.png"
							alt=""> <img
							src="${pageContext.request.contextPath}/resources/img/brand6.png"
							alt=""> <img
							src="${pageContext.request.contextPath}/resources/img/brand1.png"
							alt=""> <img
							src="${pageContext.request.contextPath}/resources/img/brand2.png"
							alt="">
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- End brands area -->


<jsp:include page="footer.jsp"></jsp:include>




