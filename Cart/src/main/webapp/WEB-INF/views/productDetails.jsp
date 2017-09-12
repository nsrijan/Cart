<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="header.jsp"></jsp:include>


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
			<div class="col-md-4">
				<div class="single-sidebar">
					<h2 class="sidebar-title">Search Products</h2>
					<form action="">
						<input type="text" placeholder="Search products..."> <input
							type="submit" value="Search">
					</form>
				</div>

				<div class="single-sidebar">
					<h2 class="sidebar-title">Products</h2>
					<div class="thubmnail-recent">
						<img
							src="${pageContext.request.contextPath}/resources/img/product-thumb-1.jpg"
							class="recent-thumb" alt="">
						<h2>
							<a href="">Sony Smart TV - 2015</a>
						</h2>
						<div class="product-sidebar-price">
							<ins>$700.00</ins>
							<del>$100.00</del>
						</div>
					</div>
					<div class="thubmnail-recent">
						<img
							src="${pageContext.request.contextPath}/resources/img/product-thumb-1.jpg"
							class="recent-thumb" alt="">
						<h2>
							<a href="">Sony Smart TV - 2015</a>
						</h2>
						<div class="product-sidebar-price">
							<ins>$700.00</ins>
							<del>$100.00</del>
						</div>
					</div>
					<div class="thubmnail-recent">
						<img
							src="${pageContext.request.contextPath}/resources/img/product-thumb-1.jpg"
							class="recent-thumb" alt="">
						<h2>
							<a href="">Sony Smart TV - 2015</a>
						</h2>
						<div class="product-sidebar-price">
							<ins>$700.00</ins>
							<del>$100.00</del>
						</div>
					</div>
					<div class="thubmnail-recent">
						<img
							src="${pageContext.request.contextPath}/resources/img/product-thumb-1.jpg"
							class="recent-thumb" alt="">
						<h2>
							<a href="">Sony Smart TV - 2015</a>
						</h2>
						<div class="product-sidebar-price">
							<ins>$700.00</ins>
							<del>$100.00</del>
						</div>
					</div>
				</div>

				<div class="single-sidebar">
					<h2 class="sidebar-title">Recent Posts</h2>
					<ul>
						<li><a href="">Sony Smart TV - 2015</a></li>
						<li><a href="">Sony Smart TV - 2015</a></li>
						<li><a href="">Sony Smart TV - 2015</a></li>
						<li><a href="">Sony Smart TV - 2015</a></li>
						<li><a href="">Sony Smart TV - 2015</a></li>
					</ul>
				</div>
			</div>

			<div class="col-md-8">
				<div class="product-content-right">
					<div class="product-breadcroumb">
						<a href="">Home</a> <a href="">Category Name</a> <a href="">Sony
							Smart TV - 2015</a>
					</div>

					<div class="row">
						<div class="col-sm-6">
							<div class="product-images">
								<div class="product-main-img">
									<img
										src="${pageContext.request.contextPath}/resources/img/products/${myProduct.pimages}"
										alt="">
								</div>

								<div class="product-gallery">
									<img
										src="${pageContext.request.contextPath}/resources/img/product-thumb-1.jpg"
										alt=""> <img
										src="${pageContext.request.contextPath}/resources/img/product-thumb-2.jpg"
										alt=""> <img
										src="${pageContext.request.contextPath}/resources/img/product-thumb-3.jpg"
										alt="">
								</div>
							</div>
						</div>

						<div class="col-sm-6">
							<div class="product-inner">
								<h2 class="product-name">${myProduct.pname}</h2>
								<div class="product-inner-price">
									<ins>$ ${myProduct.pofferprice}</ins>
									<del>$ ${myProduct.pprice}</del>
								</div>

								<form action="" class="cart">
									<div class="quantity">
										<input type="number" size="4" class="input-text qty text"
											title="Qty" value="1" name="quantity" min="1" step="1">
									</div>
									<button class="add_to_cart_button" type="submit">Add
										to cart</button>
								</form>

								<div class="product-inner-category">
									<p>
										Category: <a href="">Summer</a>. Tags: <a href="">awesome</a>,
										<a href="">best</a>, <a href="">sale</a>, <a href="">shoes</a>.
									</p>
								</div>

								<div role="tabpanel">
									<ul class="product-tab" role="tablist">
										<li role="presentation" class="active"><a href="#home"
											aria-controls="home" role="tab" data-toggle="tab">Description</a></li>
										<li role="presentation"><a href="#profile"
											aria-controls="profile" role="tab" data-toggle="tab">Reviews</a></li>
									</ul>
									<div class="tab-content">
										<div role="tabpanel" class="tab-pane fade in active" id="home">
											<h2>Product Description</h2>
											<p>${myProduct.pdescription}</p>
										</div>

										<div role="tabpanel" class="tab-pane fade" id="profile">
											<h2>Reviews</h2>
											<div class="submit-review">
												<form action="/Cart/customerReviewAdded" method="post"
													model="customerReview">
													<p>
														<input name="pid" type="hidden" value=${pid }>
													</p>
													<p>
														<label for="rname">Name</label> <input name="rname"
															type="text" value="${customerReview.rname }">
														<form:errors path="customerReview.rname"
															cssStyle="color: #ff0000;" />
													</p>
													<p>
														<label for="remail">Email</label> <input name="remail"
															type="email" value="${customerReview.remail }">
														<form:errors path="customerReview.remail"
															cssStyle="color: #ff0000;" />
													</p>
													<p>
														<label for="rphone">Phone</label> <input name="rphone"
															type="text" value="${customerReview.rphone }">
														<form:errors path="customerReview.rphone"
															cssStyle="color: #ff0000;" />
													</p>

													<p>
														<label for="name"></label> <input name="publish"
															type="hidden" value="false">
													</p>
													<div class="rating-chooser">
														<p>Your rating</p>

														<div class="rating-wrap-post">
															<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
																class="fa fa-star"></i> <i class="fa fa-star"></i> <i
																class="fa fa-star"></i>
														</div>
													</div>
													<p>
														<label for="review">Your review</label>
														<textarea id="" cols="30" rows="10" name="rdescription"
															value="${customerReview.rdescription }"></textarea>
														<form:errors path="customerReview.rdescription"
															cssStyle="color: #ff0000;" />
													</p>
													<p>
														<input type="submit" value="Submit">
													</p>
												</form>

											</div>
										</div>
									</div>
								</div>

							</div>
						</div>
					</div>


					<div class="related-products-wrapper">
						<h2 class="related-products-title">Related Products</h2>
						<div class="related-products-carousel">

							<c:forEach items="${spl}" var="spl">

								<c:if test="${spl.pid != myProduct.pid}">

									<div class="single-product">
										<div class="product-f-image">
											<img
												src="${pageContext.request.contextPath}/resources/img/products/${spl.pimages}"
												alt="">
											<div class="product-hover">
												<a href="" class="add-to-cart-link"><i
													class="fa fa-shopping-cart"></i> Add to cart</a> <a href=""
													class="view-details-link"><i class="fa fa-link"></i>
													See details</a>
											</div>
										</div>

										<h2>
											<a href="/Cart/productDetails/${spl.pid }">${spl.pname}</a>
										</h2>

										<div class="product-carousel-price">
											<ins>$ ${spl.pofferprice}</ins>
											<del>$ ${spl.pprice}</del>
										</div>
									</div>
								</c:if>
								
							</c:forEach>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<jsp:include page="footer.jsp"></jsp:include>
