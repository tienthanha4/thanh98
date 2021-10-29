<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
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

	<!-- header section starts      -->

	<jsp:include page="/WEB-INF/views/customer/layout/Header.jsp"></jsp:include>
	<!-- home section starts  -->

	<section class="home" id="home">
	


		<div class="swiper-container home-slider">

			<div class="swiper-wrapper wrapper ">

				<div class="swiper-slide slide">
					<div class="content">


						<span>our special dish thành</span>
						<h3>spicy noodles</h3>
						<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
							Sit natus dolor cumque?</p>
						<a href="#" class="btn">order now</a>
					</div>
					<div class="image">
						<img src="${base}/images/index/home-img-1.png" alt="">
					</div>
				</div>

				<div class="swiper-slide slide">
					<div class="content">
						<span>our special dish</span>
						<h3>fried chicken</h3>
						<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
							Sit natus dolor cumque?</p>
						<a href="#" class="btn">order now</a>
					</div>
					<div class="image">
						<img src="${base}/upload/product/avatar/menu-3.jpg" alt="">
					</div>
				</div>

				<div class="swiper-slide slide">
					<div class="content">
						<span>our special dish</span>
						<h3>hot pizza</h3>
						<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
							Sit natus dolor cumque?</p>
						<a href="#" class="btn">order now</a>
					</div>
					<div class="image">
						<img src="${base}/images/index/home-img-2.png" alt="">
					</div>
				</div>

			</div>

			<div class="swiper-pagination"></div>

		</div>

	</section>

	<!-- home section ends

<!-- dishes section starts  -->

	<section class="dishes" id="dishes">

		<h3 class="sub-heading">our dishes</h3>
		<h1 class="heading">popular dishes</h1>

		<div class="box-container">
			<c:forEach var="products" items="${productsData.data}">

				<div class="box">
					<a href="#" class="fas fa-heart"></a> <a href="${base}/home/product/details/${products.seo}"
						class="fas fa-eye"></a> <img src="${base}/upload/${products.avatar}"
						alt="">
					<h3><a href="${base}/home/product/details/${products.seo}">${products.title}</a></h3>
					<div class="stars">
						<c:forEach var="i" begin="1" end="${products.tb_rate}">
						<i class="fas fa-star" style="color:#27ae60; font-size: 20px"></i>
					</c:forEach>
					</div>
					<%-- <fmt:setLocale value="vi_VN" scope="session" />
					<fmt:formatNumber value="${products.price}" type="currency" /> --%>
					<span> ${products.price} $</span>
					<button id="scroll"
						onclick="ls('${pageContext.request.contextPath}',${products.id},1)"
						class="btn">add to cart</button>
				</div>
			</c:forEach>
			
			<%--      </sf:form> --%>

		</div>
		<div class="container" style="text-align: center;">
		<a href="${base}/home/product/list" class="btn">learn more</a>
		</div>
		

	</section>

	<!-- dishes section ends -->

	<!-- about section starts  -->


	<!-- about section ends -->

	<!-- menu section starts  -->

	<section class="menu" id="menu">

		<h3 class="sub-heading">our menu</h3>
		<h1 class="heading">today's speciality</h1>

		<div class="box-container">
	<c:forEach var="products" items="${productsData.data}">
			<div class="box">
				<div class="image">
					<img src="${base}/upload/${products.avatar}" alt="">
					<a href="#" class="fas fa-heart"></a>
				</div>
				<div class="content">
					<div class="stars">
						<c:forEach var="i" begin="1" end="${products.tb_rate}">
						<i class="fas fa-star" style="color:#27ae60; font-size: 20px"></i>
					</c:forEach>
					</div>
					<h3><a href="${base}/home/product/details/${products.seo}">${products.title}</a></h3>
					<p>${products.short_description}</p>
					<button id="scroll"
						onclick="ls('${pageContext.request.contextPath}',${products.id},1)"
						class="btn">add to cart</button><span class="price">${products.price}$</span>
				</div>
			</div>
			</c:forEach>

			
		</div>

	</section>

	<!-- menu section ends -->

	<!-- review section starts  -->

	<section class="review" id="review">

		<h3 class="sub-heading">customer's review</h3>
		<h1 class="heading">what they say</h1>

		<div class="swiper-container review-slider">
			<div class="swiper-wrapper">
			<c:forEach var = "comment" items="${comment}">
			<div class="swiper-slide slide">
					<i class="fas fa-quote-right"></i>
					<div class="user">
						<img src="${base}/images/index/pic-1.png" alt="">
						<div class="user-info">
							<h3>${comment.comment_name}</h3>
							<div class="stars">
								<c:forEach var="i" begin="1" end="${comment.rate}">
						<i class="fas fa-star" style="color:#27ae60; font-size: 20px"></i>
					</c:forEach>
							</div>
						</div>
					</div>
					<p>${comment.comment_product_id.title}</p>
					<p>${comment.comment}</p>
				</div>
			
			
			</c:forEach>

				
				
		</div>

	</section>

	<!-- review section ends -->

	<!-- order section starts  -->

	<section class="order" id="order">

		<h3 class="sub-heading">order now</h3>
		<h1 class="heading">free and fast</h1>

		<form action="">

			<div class="inputBox">
				<div class="input">
					<span>your name</span> <input type="text"
						placeholder="enter your name">
				</div>
				<div class="input">
					<span>your number</span> <input type="number"
						placeholder="enter your number">
				</div>
			</div>
			<div class="inputBox">
				<div class="input">
					<span>your order</span> <input type="text"
						placeholder="enter food name">
				</div>
				<div class="input">
					<span>additional food</span> <input type="test"
						placeholder="extra with food">
				</div>
			</div>
			<div class="inputBox">
				<div class="input">
					<span>how musch</span> <input type="number"
						placeholder="how many orders">
				</div>
				<div class="input">
					<span>date and time</span> <input type="datetime-local">
				</div>
			</div>
			<div class="inputBox">
				<div class="input">
					<span>your address</span>
					<textarea name="" placeholder="enter your address" id="" cols="30"
						rows="10"></textarea>
				</div>
				<div class="input">
					<span>your message</span>
					<textarea name="" placeholder="enter your message" id="" cols="30"
						rows="10"></textarea>
				</div>
			</div>

			<input type="submit" value="order now" class="btn">

		</form>

	</section>

	<!-- order section ends -->

	<!-- footer section starts  -->

	<jsp:include page="/WEB-INF/views/customer/layout/Footer.jsp"></jsp:include>
	<!-- footer section ends -->

	<!-- loader part  -->
	 <div class="loader-container">
    <img src="${base}/images/index/loader.gif" alt="">
</div> 


	<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

	<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>

	<!-- custom js file link  -->
	<script src="${base}/js/index/index.js"></script>

</body>
</html>