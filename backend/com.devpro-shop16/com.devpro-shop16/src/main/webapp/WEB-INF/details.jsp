
<!-- sử dụng tiếng việt -->
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!-- taglib JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- taglib SPRING-FORM -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/home.css">




</head>
<body onload="myFunction()">
	<div id="loader"></div>
	<div id="all-1">
		

			<div class="container">


				<div class="navbar-header left">
					<div class="logo">
						<a href="#"> <img
							src="${pageContext.request.contextPath}/images/logo-nettruyen.png">
						</a>
					</div>
					<div class="input-group inputseach ">
						<div class="form-control">
							<input type="text" name="" placeholder="Tim Truyen"> <i
								class="fas fa-search"></i>
						</div>


					</div>


				</div>
				<div class="logo-right">
					<i class="far fa-comment"></i>
				</div>

				<div class="navbar-header right">
					<ul class="nav justify-content-end">
						<li class="breadcrumb-item"><a href="#">Dang Ki</a></li>
						<li class="breadcrumb-item"><a href="#">Dang nhap</a></li>


					</ul>
				</div>

				<div class="logo-menu" style="font-size: 15px;">
					<nav class="navbar navbar-dark d-inline-block">
						<button class="navbar-toggler" type="button"
							data-toggle="collapse" data-target="#main-nav"
							aria-controls="navbarToggleExternalContent" aria-expanded="false"
							aria-label="Toggle navigation">
							<span class="navbar-toggler-icon"></span>
						</button>
					</nav>

				</div>
			</div>
	</div>
	</div>
	<div id="all-2">
		<div class="main-nav" id="main-nav">
			<div class="container">
				<div class="inner">

					<div id="menu">
						<ul>
							<li><a href="#"><i class="fas fa-home"></i></a></li>
							<li><a href="#">Hot</a></li>
							<li><a href="#">Theo doi</a></li>
							<li><a href="#">Lich su</a></li>
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
								id="navbarDropdownMenuLink" role="button" aria-haspopup="true"
								aria-expanded="false">The Loai</a>
								<div class=" showmenu" aria-labelledby="navbarDropdownMenuLink">
									<a class="dropdown-item" href="#">Action</a> <a
										class="dropdown-item" href="#">Another action</a> <a
										class="dropdown-item" href="#">Something else here</a> <a
										class="dropdown-item" href="#">Something else here</a> <a
										class="dropdown-item" href="#">Something else here</a> <a
										class="dropdown-item" href="#">Something else here</a> <a
										class="dropdown-item" href="#">Something else here</a>

								</div></li>
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
								id="navbarDropdownMenuLink" role="button" aria-haspopup="true"
								aria-expanded="false">The Loai</a>
								<div class=" showmenu" aria-labelledby="navbarDropdownMenuLink">
									<a class="dropdown-item" href="#">Action</a> <a
										class="dropdown-item" href="#">Another action</a> <a
										class="dropdown-item" href="#">Something else here</a> <a
										class="dropdown-item" href="#">Something else here</a> <a
										class="dropdown-item" href="#">Something else here</a> <a
										class="dropdown-item" href="#">Something else here</a> <a
										class="dropdown-item" href="#">Something else here</a>

								</div></li>
							<li><a href="#">Tim Truyen </a></li>
							<li><a href="#">Yeu Thich </a></li>

						</ul>
					</div>

				</div>
			</div>
		</div>
	</div>
	
	<section class="py-5">
		<div class="container px-4 px-lg-5 my-5">
			<div class="row gx-4 gx-lg-5 align-items-center">
				<div class="col-md-6">
					<img class="card-img-top mb-5 mb-md-0"
						src="https://dummyimage.com/600x700/dee2e6/6c757d.jpg" alt="..." />
				</div>
				<div class="col-md-6">
					<div class="small mb-1">SKU: BST-498</div>
					<h1 class="display-5 fw-bolder">${products.title}</h1>
					<div class="fs-5 mb-5">
						<span class="text-decoration-line-through">$45.00</span> <span>demo session ${totalItems}</span>
						<span> <fmt:setLocale value="vi_VN" /> <fmt:formatNumber
								value="${product.price}" type="currency" />
						</span>
					</div>
					<p class="lead">Lorem ipsum dolor sit amet consectetur
						adipisicing elit. Praesentium at dolorem quidem modi. Nam sequi
						consequatur obcaecati excepturi alias magni, accusamus eius
						blanditiis delectus ipsam minima ea iste laborum vero?</p>
					<div class="d-flex">
						<input class="form-control text-center me-3" id="inputQuantity"
							type="num" value="1" style="max-width: 3rem" />
						<button class="btn btn-outline-dark flex-shrink-0" type="button">
							<i class="bi-cart-fill me-1"></i> Add to cart
						</button>
					</div>
				</div>
			</div>
		</div>
	</section>


	<!-- Related items section-->
	<section class="py-5 bg-light">
		<div class="container px-4 px-lg-5 mt-5">
			<h2 class="fw-bolder mb-4">Related products</h2>
			<div
				class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Product image-->
						<img class="card-img-top"
							src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder">Fancy Product</h5>
								<!-- Product price-->
								$40.00 - $80.00
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto" href="#">View
									options</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Sale badge-->
						<div class="badge bg-dark text-white position-absolute"
							style="top: 0.5rem; right: 0.5rem">Sale</div>
						<!-- Product image-->
						<img class="card-img-top"
							src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder">Special Item</h5>
								<!-- Product reviews-->
								<div
									class="d-flex justify-content-center small text-warning mb-2">
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
								</div>
								<!-- Product price-->
								<span class="text-muted text-decoration-line-through">$20.00</span>
								$18.00
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Sale badge-->
						<div class="badge bg-dark text-white position-absolute"
							style="top: 0.5rem; right: 0.5rem">Sale</div>
						<!-- Product image-->
						<img class="card-img-top"
							src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder">Sale Item</h5>
								<!-- Product price-->
								<span class="text-muted text-decoration-line-through">$50.00</span>
								$25.00
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Product image-->
						<img class="card-img-top"
							src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder">Popular Item</h5>
								<!-- Product reviews-->
								<div
									class="d-flex justify-content-center small text-warning mb-2">
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
								</div>
								<!-- Product price-->
								$40.00
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<div id="all-4">
		<footer>
			<div class="container d-flex" style="padding: 20px;">
				<div class="footer-left">
					<div class="footer-left-top-img">
						<img
							src="${pageContext.request.contextPath}/images/logo-nettruyen.png"
							width="100%">
					</div>

					<div class="media footer-left-bootom">
						<img class="align-self-start mr-2"
							src="${pageContext.request.contextPath}/images/chien-hon-tuyet-the.jpg"
							width="70px" alt="Generic placeholder image">
						<div class="media-body">
							<h5 class="mt-0">
								<a href="#">NetTruyen.com - Truyện Tranh Online</a>
							</h5>
							<span><i class="fab fa-facebook-square"
								style="font-size: 30px"></i> 146K likes</span>
						</div>
					</div>

					<p style="color: white;">Copyright © 2015 NetTruyen</p>


				</div>
				<div class="footer-right">
					<h4 style="color: white;">Thể loại</h4>
					<div class="footer-right-menu">
						<ul>
							<li><a href="">Chuyển Sinh</a></li>
							<li><a href="">Chuyển Sinh</a></li>
							<li><a href="">Chuyển Sinh</a></li>
							<li><a href="">Chuyển Sinh</a></li>
							<li><a href="">Chuyển Sinh</a></li>
							<li><a href="">Chuyển Sinh</a></li>
							<li><a href="">Chuyển Sinh</a></li>
							<li><a href="">Chuyển Sinh</a></li>
						</ul>
					</div>


				</div>
			</div>
		</footer>
	</div>



</body>

<script
	src="${pageContext.request.contextPath}/bootstrap/bootstrap.min.css"></script>

<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/home.js"></script>


</html>



