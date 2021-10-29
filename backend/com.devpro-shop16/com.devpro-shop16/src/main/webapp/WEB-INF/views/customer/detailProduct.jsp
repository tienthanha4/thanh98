<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- taglib JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- taglib SPRING-FORM -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%><!DOCTYPE html>
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
<link rel="stylesheet" href="/${base}css/index/index.css">

</head>
<body>
	<div style="z-index: 99999999999">dscdcsdcdcddddddddddddd</div>
	<div>${userLogined.email}</div>


	<!-- header section starts      -->

	<jsp:include page="/WEB-INF/views/customer/layout/Header.jsp"></jsp:include>
	<!-- home section starts  -->


	<!-- about section starts  -->

	<section class="about" id="about">

		<h3 class="sub-heading">about us</h3>
		<h1 class="heading">why choose us?</h1>

		<div class="row">

			<div class="image">
				<img src="${base}/upload/${products.avatar}" alt="">
			</div>

			<div class="content">
				<h3>${products.title}</h3>
				<p>${products.short_description}</p>
				<div class="stars">
					<c:forEach var="i" begin="1" end="${products.tb_rate}">
						<i class="fas fa-star" style="color: yellow; font-size: 20px"></i>
					</c:forEach>
					<%-- <h3>${products.tb_rate}/5</h3> --%>
				</div>
				
				<div class="icons-container">
					<div class="icons">
						<i class="fas fa-shipping-fast"></i> <span>free delivery</span>
					</div>
					<div class="icons">
						<i class="fas fa-dollar-sign"></i> <span>${products.price}</span>
					</div>
					<div class="icons">
						<i class="fas fa-headset"></i> <span>${products.tb_rate}/5</span>
					</div>
				</div>
				<a href="${base}/home/shopcart" class="btn"
					onclick="ls('${pageContext.request.contextPath}',${products.id},1)">Add
					to cart</a>
			</div>

		</div>

	</section>
	<section class="order" id="order">

		<h3 class="sub-heading">order now</h3>
		<h1 class="heading">free and fast</h1>

		<form action="${base}/home/product/details/${products.seo}"
			method="post">

			<div class="inputBox">

				<input type="hidden" id="seo" name="seo" value="${products.seo}">
				<input type="hidden" id="comment_product_id"
					name="comment_product_id" value="${products.id}">
				<div class="input">
					<div class="rating">
						<input type="radio" name="rate" value="5" id="5"><label
							for="5">☆</label> <input type="radio" name="rate" value="4"
							id="4"><label for="4">☆</label> <input type="radio"
							name="rate" value="3" id="3"><label for="3">☆</label> <input
							type="radio" name="rate" value="2" id="2"><label for="2">☆</label>
						<input type="radio" name="rate" value="1" id="1"required><label
							for="1">☆</label>
					</div>
					<div class="buttons px-4 mt-0"></div>
					<span>your address</span>
					<textarea name="comment" placeholder="enter your address"
						id="comment" cols="60" rows="10"></textarea>
				</div>

			</div>

			<div>



				<input type="submit" value="order now" class="btn">
			</div>


		</form>

	</section>
	<!-- <div id="fb-root"></div>
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v12.0&appId=1246273062555751&autoLogAppEvents=1" nonce="8PlzDVAu"></script>
	<div class="fb-comments" data-href="https://developers.facebook.com/docs/plugins/comments#configurator" data-width="" data-numposts="5"></div>
 -->
	<!-- about section ends -->

	<!-- menu section starts  -->


	<!-- footer section starts  -->

	<jsp:include page="/WEB-INF/views/customer/layout/Footer.jsp"></jsp:include>
	<!-- footer section ends -->

	<!-- loader part  -->
	<!-- <div class="loader-container">
    <img src="${base}/images/index/loader.gif" alt="">
</div> -->


	<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

	<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>

	<!-- custom js file link  -->
	<script src="${base}/js/index/index.js"></script>

</body>
</html>