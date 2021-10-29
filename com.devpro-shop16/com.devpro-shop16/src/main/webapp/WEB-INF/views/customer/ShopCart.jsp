<%@ page language="java" contentType="text/html; charset=UTF -8"
	pageEncoding="ISO-8859-1"%>
<!-- taglib JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- taglib SPRING-FORM -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!--    <meta name="viewport" content="width=device-width, initial-scale=1.0">
  -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Complete Responsive Food Website Design Tutorial</title>

<link rel="stylesheet"
	href="https://unpkg.com/swiper/swiper-bundle.min.css" />

<!-- font awesome cdn link  -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

<!-- custom css file link  -->
<link rel="stylesheet" href="${base}/css/shopcart/index.css">

</head>
<body>

	<!-- header section starts      -->

	<jsp:include page="/WEB-INF/views/customer/layout/Header.jsp"></jsp:include>
	<!-- home section starts  -->





	<section class="order" id="order">

		<h3 class="sub-heading">order now</h3>
		<h1 class="heading">free and fast</h1>
		<link
			href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
			rel="stylesheet">
		<div class="container padding-bottom-3x mb-1">
			<!-- Alert-->
			<!-- Shopping Cart-->
			<div class="table-responsive shopping-cart cartOder">
				<div class="cartFull">
					<div class="orderRight">
						<table class="table">
							<thead>
								<tr>
									<th>Product Name</th>
									<th class="text-center">Quantity</th>
									<th class="text-center">Price</th>

									<th class="text-center"><a
										class="btn btn-sm btn-outline-danger" href="#">Clear Cart</a></th>
								</tr>
							</thead>
							<tbody style="text-align: center;">
								
								<c:forEach var="cartItems" items="${cart.cartItems}">
									<tr id="${cartItems.productId}">
										<td>
											<div class="product-item" >
												<a class="product-thumb" href="#"><img
													src="https://via.placeholder.com/220x180/9932CC/000000"
													alt="Product"></a>
												<div class="product-info">
													<h4 class="product-title">
														<a href="#">${cartItems.productName}</a>
													</h4>
													<span><em>Size:</em> -</span><span><em>Color:</em>
														Turquoise</span>
												</div>
											</div>
										</td>
										<%-- <td class="text-center">
											<div class="form-group mb-0">
												<input type="number" class="form-control cart-qty"
													name="quanlity" id="quanlity" value="${cartItems.quanlity}"> 
												
											</div>
										</td>
										 --%>	
										 <td class="text-center text-lg text-medium" name="quanlity" id = "quanlity">${cartItems.quanlity} </td>
										<td class="text-center text-lg text-medium" name="price" id = "price">${cartItems.priceUnit} </td>

										

										<td class="text-center"><a class="remove-from-cart"
											onclick="deleteSessionCart('${pageContext.request.contextPath}',${cartItems.productId})" data-toggle="tooltip" title=""
											data-original-title="Remove item"><i class="fa fa-trash"></i></a></td>
									
									</tr>
								</c:forEach>
							
								
							</tbody>
			
						</table>
						<h2 style="text-align: right ;margin-right: 5%; " id = "totalt">Toltal : ${toltalprice}</h2>
					</div>


				</div>

				<div class="orderLeft">
					<form action="/home/shopcart" method="post">

						<div class="inputBox">
							<div class="input">
								<span>your name</span> <input type="text"
									placeholder="customerName" value="${userLogined.username}" name="customerName">
							</div>
							<div class="input">
								<span>your number</span> <input type="text"
									placeholder="enter your number" name="customerPhone">
							</div>
						</div>
						<div class="inputBox">
							<div class="input">
								<span>Email</span> <input name="customerEmail" type="text"
									placeholder="enter food name"   name="customerEmail" value="${userLogined.email}">
							</div>
							<div class="input">
								<span>additional food</span> <input type="test"
									placeholder="extra with food"  >
							</div>
						</div>
						<div class="inputBox">
							<div class="input">
								<span>your address</span>
								<textarea name="customerAddress" placeholder="enter your address" id="customerAddress"
									cols="30" rows="10" ></textarea>
							</div>

						</div>
	
						<input type="submit" value="order now" class="btn">

					</form>


				</div>

			</div>
	</section>

	<!-- order section ends -->

	<!-- footer section starts  -->

	<section class="footer">

		<div class="box-container">

			<div class="box">
				<h3>locations</h3>
				<a href="#">india</a> <a href="#">japan</a> <a href="#">russia</a> <a
					href="#">USA</a> <a href="#">france</a>
			</div>

			<div class="box">
				<h3>quick links</h3>
				<a href="#">home</a> <a href="#">dishes</a> <a href="#">about</a> <a
					href="#">menu</a> <a href="#">reivew</a> <a href="#">order</a>
			</div>

			<div class="box">
				<h3>contact info</h3>
				<a href="#">+123-456-7890</a> <a href="#">+111-222-3333</a> <a
					href="#">shaikhanas@gmail.com</a> <a href="#">anasbhai@gmail.com</a>
				<a href="#">mumbai, india - 400104</a>
			</div>

			<div class="box">
				<h3>follow us</h3>
				<a href="#">facebook</a> <a href="#">twitter</a> <a href="#">instagram</a>
				<a href="#">linkedin</a>
			</div>

		</div>

		<div class="credit">
			copyright @ 2021 by <span>mr. web designer</span>
		</div>

	</section>

	<!-- footer section ends -->

	<!-- loader part  -->
	<!-- <div class="loader-container">
    <img src="images/loader.gif" alt="">
</div> -->
	 <script language="JavaScript"  src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.0/jquery.min.js"></script>
	<script src="jquery.min.js"></script>
	<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
	<!-- custom js file link  -->
	<script src="${base}/js/shopcart/index.js"></script>

</body>
</html>