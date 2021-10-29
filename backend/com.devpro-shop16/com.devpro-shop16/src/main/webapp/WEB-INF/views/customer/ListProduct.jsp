<%@ page language="java" contentType="text/html; charset=UTF -8"
	pageEncoding="ISO-8859-1"%>
<!-- taglib JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- taglib SPRING-FORM -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%><!DOCTYPE html>
<html lang="en" style="font-size: 45%">
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
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/simplePagination.css" />
</head>

</head>
<body>



	<!-- header section starts      -->

	<jsp:include page="/WEB-INF/views/customer/layout/Header.jsp"></jsp:include>
	<!-- home section starts  -->


	<!-- about section starts  -->

	<section class="menu" id="menu" style="padding: 7%;">
		<form action="${pageContext.request.contextPath}/home/product/list"
			method="get">
			<h3 class="sub-heading">our menu</h3>
			<h1 class="heading">today's speciality</h1>
			<input type="hidden" id="page" name="page">
			<button type="submit" id="pt" style="display: none;"></button>
			
		<select class="form-select" aria-label="Default select example"
				style="height: 32px; margin-left: 81%; margin-bottom: 1%;"name="sx">
				<option value="price"> price</option> 
				<option value="tb_rate">Rating</option> 
		</select>
		<button type="submit"  class="btn btn-primary">Seach</button>
		<div class="box-container">
	<c:forEach var="products" items="${productswithPaging.data}">
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
		



			>			<div>
				<div class="row" style="margin-left: 38%; margin-top: 10px">
					<div class="col-12 d-flex justify-content-center">
						<div id="paging"></div>
					</div>
				</div>
			</div>
		</form>

	</section>


	<!-- menu section ends -->

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
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/jquery.simplePagination.js"></script>

	<!-- custom js file link  -->
	<script src="${base}/js/index/index.js"></script>
	<!-- <script type="text/javascript">
	$(window).scroll(function() {
		   if($(window).scrollTop() + $(window).height() == $(document).height()){
		       alert("bottom!");
		       // getData();
		   }
		});	

	</script>
 -->
	<script type="text/javascript">
			$( document ).ready(function() {
				$("#paging").pagination({ 
					currentPage: ${productswithPaging.currentPage},
			        items: ${productswithPaging.totalItems},
			        itemsOnPage: 5,
			        cssStyle: 'dark-theme',
			        onPageClick: function(pageNumber, event) {
			        	$('#page').val(pageNumber);
			        	$('#pt').trigger('click'); 
			        	
			        	
					},
			    });
			});
		</script>


</body>
</html>