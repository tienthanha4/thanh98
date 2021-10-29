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
		<header>

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


	</header>
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
								<%-- <c:forEach items="${categories}" var="category">
									<a class="dropdown-item" href="${pageContext.request.contextPath}//category/{seo}">${category.name}</a> 
								</c:forEach>
								</div></li> --%>
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
	<div id="all-3">
		<main>
			<div class="container all">
				<div class="container">
					<div class="container">
						<div class="content-1">
							<h2 class="page-title">
								Truyện Đề Cử <i class="fa fa-angle-right"></i>
							</h2>
							<div class="sidle">
								<div id="carouselExampleIndicators" class="carousel slide"
									data-ride="carousel">

									<div class="carousel-inner" style="display: block;">
										<div class="carousel-item active">
											<div class="row">

												<div class="item" id="1">
													<a
														href="http://www.nettruyenvip.com/truyen-tranh/van-co-than-vuong-24261">
														<img class="lazyOwl"
														src="${pageContext.request.contextPath}/images/chien-hon-tuyet-the.jpg"
														alt="Vạn Cổ Thần Vương" style="display: inline;"
														width="100%">
													</a>

													<div class="slide-caption">
														<a href="" class="title" title="Vạn Cổ Thần Vương">Vạn
															Cổ Thần Vương </a>
														<div class="title-2">
															<a href="" title="Chapter 262">Chapter 262</a> <span
																class="time"> <i class="fa fa-clock-o"> </i> 1
																giờ trước
															</span>
														</div>
													</div>

												</div>
												<div class="item" id="2">
													<a
														href="http://www.nettruyenvip.com/truyen-tranh/van-co-than-vuong-24261">
														<img class="lazyOwl"
														src="${pageContext.request.contextPath}/images/chien-hon-tuyet-the.jpg"
														alt="Vạn Cổ Thần Vương" style="display: inline;"
														width="100%">
													</a>

													<div class="slide-caption">
														<a href="" class="title" title="Vạn Cổ Thần Vương">Vạn
															Cổ Thần Vương </a>
														<div class="title-2">
															<a href="" title="Chapter 262">Chapter 262</a> <span
																class="time"> <i class="fa fa-clock-o"> </i> 1
																giờ trước
															</span>
														</div>
													</div>

												</div>
												<div class="item" id="3">
													<a
														href="http://www.nettruyenvip.com/truyen-tranh/van-co-than-vuong-24261">
														<img class="lazyOwl"
														src="${pageContext.request.contextPath}/images/chien-hon-tuyet-the.jpg"
														alt="Vạn Cổ Thần Vương" style="display: inline;"
														width="100%">
													</a>

													<div class="slide-caption">
														<a href="" class="title" title="Vạn Cổ Thần Vương">Vạn
															Cổ Thần Vương </a>
														<div class="title-2">
															<a href="" title="Chapter 262">Chapter 262</a> <span
																class="time"> <i class="fa fa-clock-o"> </i> 1
																giờ trước
															</span>
														</div>
													</div>

												</div>
												<div class="item" id="4">
													<a
														href="http://www.nettruyenvip.com/truyen-tranh/van-co-than-vuong-24261">
														<img class="lazyOwl"
														src="${pageContext.request.contextPath}/images/chien-hon-tuyet-the.jpg"
														alt="Vạn Cổ Thần Vương" style="display: inline;"
														width="100%">
													</a>

													<div class="slide-caption">
														<a href="" class="title" title="Vạn Cổ Thần Vương">Vạn
															Cổ Thần Vương </a>
														<div class="title-2">
															<a href="" title="Chapter 262">Chapter 262</a> <span
																class="time"> <i class="fa fa-clock-o"> </i> 1
																giờ trước
															</span>
														</div>
													</div>

												</div>


											</div>
										</div>
										<div class="carousel-item ">
											<div class="row">

												<div class="item active" id="5">
													<a
														href="http://www.nettruyenvip.com/truyen-tranh/van-co-than-vuong-24261">
														<img class="lazyOwl"
														src="${pageContext.request.contextPath}/images/chien-hon-tuyet-the.jpg"
														alt="Vạn Cổ Thần Vương" style="display: inline;"
														width="100%">
													</a>

													<div class="slide-caption">
														<a href="" class="title" title="Vạn Cổ Thần Vương">Vạn
															Cổ Thần Vương </a>
														<div class="title-2">
															<a href="" title="Chapter 262">Chapter 262</a> <span
																class="time"> <i class="fa fa-clock-o"> </i> 1
																giờ trước
															</span>
														</div>
													</div>

												</div>
												<div class="item" id="6">
													<a
														href="http://www.nettruyenvip.com/truyen-tranh/van-co-than-vuong-24261">
														<img class="lazyOwl"
														src="${pageContext.request.contextPath}/images/chien-hon-tuyet-the.jpg"
														alt="Vạn Cổ Thần Vương" style="display: inline;"
														width="100%">
													</a>

													<div class="slide-caption">
														<a href="" class="title" title="Vạn Cổ Thần Vương">Vạn
															Cổ Thần Vương </a>
														<div class="title-2">
															<a href="" title="Chapter 262">Chapter 262</a> <span
																class="time"> <i class="fa fa-clock-o"> </i> 1
																giờ trước
															</span>
														</div>
													</div>

												</div>
												<div class="item" id="7">
													<a
														href="http://www.nettruyenvip.com/truyen-tranh/van-co-than-vuong-24261">
														<img class="lazyOwl"
														src="${pageContext.request.contextPath}/images/chien-hon-tuyet-the.jpg"
														alt="Vạn Cổ Thần Vương" style="display: inline;"
														width="100%">
													</a>

													<div class="slide-caption">
														<a href="" class="title" title="Vạn Cổ Thần Vương">Vạn
															Cổ Thần Vương </a>
														<div class="title-2">
															<a href="" title="Chapter 262">Chapter 262</a> <span
																class="time"> <i class="fa fa-clock-o"> </i> 1
																giờ trước
															</span>
														</div>
													</div>

												</div>
												<div class="item" id="8">
													<a
														href="http://www.nettruyenvip.com/truyen-tranh/van-co-than-vuong-24261">
														<img class="lazyOwl"
														src="${pageContext.request.contextPath}/images/chien-hon-tuyet-the.jpg"
														alt="Vạn Cổ Thần Vương" style="display: inline;"
														width="100%">
													</a>

													<div class="slide-caption">
														<a href="" class="title" title="Vạn Cổ Thần Vương">Vạn
															Cổ Thần Vương </a>
														<div class="title-2">
															<a href="" title="Chapter 262">Chapter 262</a> <span
																class="time"> <i class="fa fa-clock-o"> </i> 1
																giờ trước
															</span>
														</div>
													</div>

												</div>


											</div>
										</div>
									</div>
									<a class="carousel-control-prev"
										href="#carouselExampleIndicators" role="button"
										data-slide="prev"> <span
										class="carousel-control-prev-icon" aria-hidden="true"></span>
										<span class="sr-only">Previous</span>
									</a> <a class="carousel-control-next"
										href="#carouselExampleIndicators" role="button"
										data-slide="next"> <span
										class="carousel-control-next-icon" aria-hidden="true"></span>
										<span class="sr-only">Next</span>
									</a>

								</div>
							</div>
						</div>
						<div class="center-sidle">
							<div class="container center-sidle-1 pr-0 mt-4 ">

								<div class="center-sidle-left">
									<h2 class="page-title">
										Truyện Đề Cử <i class="fa fa-angle-right"></i>
									</h2>
									<div class="row">
										<c:forEach items="${productsData.data }" var="product">
											<div class="item ">
												<div class="card" style=>
													<div>
														<img class="card-img-top"
															src="${pageContext.request.contextPath}/images/chien-hon-tuyet-the.jpg"
															width="100%" alt="Card image cap"
															style="display: inline;">
														<div class="slide-caption-center"
															style="width: 100%; transform: translate(-5px, -35px); height: 35px;">

															<div class="title-2">

																<span class="time"> <i class="fas fa-eye"></i>
																	999999 <i class="fas fa-heart"></i> 999999
																</span>
															</div>
														</div>
													</div>
													<div class="card-body">
														<a
															href="${pageContext.request.contextPath}/details/${product.seo}">
															<h5 class="card-title">Vạn Cổ Thần Vương</h5>
														</a>
														<li class="clearfix list-inline" style="font-size: 14px;"><a
															href="#">Chương 1</a><i
															class="float-right font-weight-normal">25phut truoc</i></li>
														<li class="clearfix list-inline" style="font-size: 14px;"><a
															href="#">Chương 1</a><i
															class="float-right font-weight-normal">25phut truoc</i></li>
														<li class="clearfix list-inline" style="font-size: 14px;"><a
															href="#">Chương 1</a><i
															class="float-right font-weight-normal">25phut truoc</i></li>



													</div>
												</div>
											</div>
										</c:forEach>
										<div class="item ">
											<div class="card" style=>
												<div>
													<img class="card-img-top"
														src="${pageContext.request.contextPath}/images/chien-hon-tuyet-the.jpg"
														width="100%" alt="Card image cap" style="display: inline;">
													<div class="slide-caption-center"
														style="width: 100%; transform: translate(-5px, -35px); height: 35px;">

														<div class="title-2">

															<span class="time"> <i class="fas fa-eye"></i>
																999999 <i class="fas fa-heart"></i> 999999
															</span>
														</div>
													</div>
												</div>
												<div class="card-body">
													<h5 class="card-title">Vạn Cổ Thần Vương</h5>
													<li class="clearfix list-inline" style="font-size: 14px;"><a
														href="#">Chương 1</a><i
														class="float-right font-weight-normal">25phut truoc</i></li>
													<li class="clearfix list-inline" style="font-size: 14px;"><a
														href="#">Chương 1</a><i
														class="float-right font-weight-normal">25phut truoc</i></li>
													<li class="clearfix list-inline" style="font-size: 14px;"><a
														href="#">Chương 1</a><i
														class="float-right font-weight-normal">25phut truoc</i></li>



												</div>
											</div>
										</div>

										<div class="item ">
											<div class="card" style=>
												<div>
													<img class="card-img-top"
														src="${pageContext.request.contextPath}/images/chien-hon-tuyet-the.jpg"
														width="100%" alt="Card image cap" style="display: inline;">
													<div class="slide-caption-center"
														style="width: 100%; transform: translate(-5px, -35px); height: 35px;">

														<div class="title-2">

															<span class="time"> <i class="fas fa-eye"></i>
																999999 <i class="fas fa-heart"></i> 999999
															</span>
														</div>
													</div>
												</div>
												<div class="card-body">
													<h5 class="card-title">Vạn Cổ Thần Vương</h5>
													<li class="clearfix list-inline" style="font-size: 14px;"><a
														href="#">Chương 1</a><i
														class="float-right font-weight-normal">25phut truoc</i></li>
													<li class="clearfix list-inline" style="font-size: 14px;"><a
														href="#">Chương 1</a><i
														class="float-right font-weight-normal">25phut truoc</i></li>
													<li class="clearfix list-inline" style="font-size: 14px;"><a
														href="#">Chương 1</a><i
														class="float-right font-weight-normal">25phut truoc</i></li>



												</div>
											</div>
										</div>
										<div class="item ">
											<div class="card" style=>
												<div>
													<img class="card-img-top"
														src="${pageContext.request.contextPath}/images/chien-hon-tuyet-the.jpg"
														width="100%" alt="Card image cap" style="display: inline;">
													<div class="slide-caption-center"
														style="width: 100%; transform: translate(-5px, -35px); height: 35px;">

														<div class="title-2">

															<span class="time"> <i class="fas fa-eye"></i>
																999999 <i class="fas fa-heart"></i> 999999
															</span>
														</div>
													</div>
												</div>
												<div class="card-body">
													<h5 class="card-title">Vạn Cổ Thần Vương</h5>
													<li class="clearfix list-inline" style="font-size: 14px;"><a
														href="#">Chương 1</a><i
														class="float-right font-weight-normal">25phut truoc</i></li>
													<li class="clearfix list-inline" style="font-size: 14px;"><a
														href="#">Chương 1</a><i
														class="float-right font-weight-normal">25phut truoc</i></li>
													<li class="clearfix list-inline" style="font-size: 14px;"><a
														href="#">Chương 1</a><i
														class="float-right font-weight-normal">25phut truoc</i></li>



												</div>
											</div>
										</div>
										<div class="item ">
											<div class="card" style=>
												<div>
													<img class="card-img-top"
														src="${pageContext.request.contextPath}/images/chien-hon-tuyet-the.jpg"
														width="100%" alt="Card image cap" style="display: inline;">
													<div class="slide-caption-center"
														style="width: 100%; transform: translate(-5px, -35px); height: 35px;">

														<div class="title-2">

															<span class="time"> <i class="fas fa-eye"></i>
																999999 <i class="fas fa-heart"></i> 999999
															</span>
														</div>
													</div>
												</div>
												<div class="card-body">
													<h5 class="card-title">Vạn Cổ Thần Vương</h5>
													<li class="clearfix list-inline" style="font-size: 14px;"><a
														href="#">Chương 1</a><i
														class="float-right font-weight-normal">25phut truoc</i></li>
													<li class="clearfix list-inline" style="font-size: 14px;"><a
														href="#">Chương 1</a><i
														class="float-right font-weight-normal">25phut truoc</i></li>
													<li class="clearfix list-inline" style="font-size: 14px;"><a
														href="#">Chương 1</a><i
														class="float-right font-weight-normal">25phut truoc</i></li>



												</div>
											</div>
										</div>
										<div class="item ">
											<div class="card" style=>
												<div>
													<img class="card-img-top"
														src="${pageContext.request.contextPath}/images/chien-hon-tuyet-the.jpg"
														width="100%" alt="Card image cap" style="display: inline;">
													<div class="slide-caption-center"
														style="width: 100%; transform: translate(-5px, -35px); height: 35px;">

														<div class="title-2">

															<span class="time"> <i class="fas fa-eye"></i>
																999999 <i class="fas fa-heart"></i> 999999
															</span>
														</div>
													</div>
												</div>
												<div class="card-body">
													<h5 class="card-title">Vạn Cổ Thần Vương</h5>
													<li class="clearfix list-inline" style="font-size: 14px;"><a
														href="#">Chương 1</a><i
														class="float-right font-weight-normal">25phut truoc</i></li>
													<li class="clearfix list-inline" style="font-size: 14px;"><a
														href="#">Chương 1</a><i
														class="float-right font-weight-normal">25phut truoc</i></li>
													<li class="clearfix list-inline" style="font-size: 14px;"><a
														href="#">Chương 1</a><i
														class="float-right font-weight-normal">25phut truoc</i></li>



												</div>
											</div>
										</div>
										<div class="item ">
											<div class="card" style=>
												<div>
													<img class="card-img-top"
														src="${pageContext.request.contextPath}/images/chien-hon-tuyet-the.jpg"
														width="100%" alt="Card image cap" style="display: inline;">
													<div class="slide-caption-center"
														style="width: 100%; transform: translate(-5px, -35px); height: 35px;">

														<div class="title-2">

															<span class="time"> <i class="fas fa-eye"></i>
																999999 <i class="fas fa-heart"></i> 999999
															</span>
														</div>
													</div>
												</div>
												<div class="card-body">
													<h5 class="card-title">Vạn Cổ Thần Vương</h5>
													<li class="clearfix list-inline" style="font-size: 14px;"><a
														href="#">Chương 1</a><i
														class="float-right font-weight-normal">25phut truoc</i></li>
													<li class="clearfix list-inline" style="font-size: 14px;"><a
														href="#">Chương 1</a><i
														class="float-right font-weight-normal">25phut truoc</i></li>
													<li class="clearfix list-inline" style="font-size: 14px;"><a
														href="#">Chương 1</a><i
														class="float-right font-weight-normal">25phut truoc</i></li>



												</div>
											</div>
										</div>
										<div class="item ">
											<div class="card" style=>
												<div>
													<img class="card-img-top"
														src="${pageContext.request.contextPath}/images/chien-hon-tuyet-the.jpg"
														width="100%" alt="Card image cap" style="display: inline;">
													<div class="slide-caption-center"
														style="width: 100%; transform: translate(-5px, -35px); height: 35px;">

														<div class="title-2">

															<span class="time"> <i class="fas fa-eye"></i>
																999999 <i class="fas fa-heart"></i> 999999
															</span>
														</div>
													</div>
												</div>
												<div class="card-body">
													<h5 class="card-title">Vạn Cổ Thần Vương</h5>
													<li class="clearfix list-inline" style="font-size: 14px;"><a
														href="#">Chương 1</a><i
														class="float-right font-weight-normal">25phut truoc</i></li>
													<li class="clearfix list-inline" style="font-size: 14px;"><a
														href="#">Chương 1</a><i
														class="float-right font-weight-normal">25phut truoc</i></li>
													<li class="clearfix list-inline" style="font-size: 14px;"><a
														href="#">Chương 1</a><i
														class="float-right font-weight-normal">25phut truoc</i></li>



												</div>
											</div>
										</div>
										<div class="item ">
											<div class="card" style=>
												<div>
													<img class="card-img-top"
														src="${pageContext.request.contextPath}/images/chien-hon-tuyet-the.jpg"
														width="100%" alt="Card image cap" style="display: inline;">
													<div class="slide-caption-center"
														style="width: 100%; transform: translate(-5px, -35px); height: 35px;">

														<div class="title-2">

															<span class="time"> <i class="fas fa-eye"></i>
																999999 <i class="fas fa-heart"></i> 999999
															</span>
														</div>
													</div>
												</div>
												<div class="card-body">
													<h5 class="card-title">Vạn Cổ Thần Vương</h5>
													<li class="clearfix list-inline" style="font-size: 14px;"><a
														href="#">Chương 1</a><i
														class="float-right font-weight-normal">25phut truoc</i></li>
													<li class="clearfix list-inline" style="font-size: 14px;"><a
														href="#">Chương 1</a><i
														class="float-right font-weight-normal">25phut truoc</i></li>
													<li class="clearfix list-inline" style="font-size: 14px;"><a
														href="#">Chương 1</a><i
														class="float-right font-weight-normal">25phut truoc</i></li>



												</div>
											</div>
										</div>
										<div class="item ">
											<div class="card" style=>
												<div>
													<img class="card-img-top"
														src="${pageContext.request.contextPath}/images/chien-hon-tuyet-the.jpg"
														width="100%" alt="Card image cap" style="display: inline;">
													<div class="slide-caption-center"
														style="width: 100%; transform: translate(-5px, -35px); height: 35px;">

														<div class="title-2">

															<span class="time"> <i class="fas fa-eye"></i>
																999999 <i class="fas fa-heart"></i> 999999
															</span>
														</div>
													</div>
												</div>
												<div class="card-body">
													<h5 class="card-title">Vạn Cổ Thần Vương</h5>
													<li class="clearfix list-inline" style="font-size: 14px;"><a
														href="#">Chương 1</a><i
														class="float-right font-weight-normal">25phut truoc</i></li>
													<li class="clearfix list-inline" style="font-size: 14px;"><a
														href="#">Chương 1</a><i
														class="float-right font-weight-normal">25phut truoc</i></li>
													<li class="clearfix list-inline" style="font-size: 14px;"><a
														href="#">Chương 1</a><i
														class="float-right font-weight-normal">25phut truoc</i></li>



												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="center-sidle-right " style="">
									<ul class="list-group history">
										<li class="list-group-item ">Lich Su doc truyen</li>
										<li class="list-group-item">
											<div class="media">
												<img class="align-self-start mr-3"
													src="${pageContext.request.contextPath}/images/chien-hon-tuyet-the.jpg"
													width="70px" height="70px" alt="Generic placeholder image">
												<div class="media-body">
													<h7 class="mt-0"> <a href="#">Vạn Cổ Thần Vương</a></h7>
													<p>Chap 1</p>
												</div>
											</div>
										</li>
										<li class="list-group-item"><div class="media">
												<img class="align-self-start mr-3"
													src="${pageContext.request.contextPath}/images/chien-hon-tuyet-the.jpg"
													width="70px" height="70px" alt="Generic placeholder image">
												<div class="media-body">
													<h7 class="mt-0"> <a href="#">Vạn Cổ Thần Vương</a></h7>
													<p>Chap 1</p>
												</div>
											</div></li>
										<li class="list-group-item"><div class="media">
												<img class="align-self-start mr-3"
													src="${pageContext.request.contextPath}/images/chien-hon-tuyet-the.jpg"
													width="70px" height="70px" alt="Generic placeholder image">
												<div class="media-body">
													<h7 class="mt-0"> <a href="#">Vạn Cổ Thần Vương</a></h7>
													<p>Chap 1</p>
												</div>
											</div></li>
										<li class="list-group-item"><div class="media">
												<img class="align-self-start mr-3"
													src="${pageContext.request.contextPath}/images/chien-hon-tuyet-the.jpg"
													width="70px" height="70px" alt="Generic placeholder image">
												<div class="media-body">
													<h7 class="mt-0"> <a href="#">Vạn Cổ Thần Vương</a></h7>
													<p>Chap 1</p>
												</div>
											</div></li>
									</ul>
									<br>
									<ul class="list-group rank">
										<li class="list-group-item">
											<ul class="nav nav-tabs d-flex justify-content-around">
												<li class="active"><a data-toggle="tab" href="#home">Home</a></li>
												<li><a data-toggle="tab" href="#menu1">Menu 1</a></li>
												<li><a data-toggle="tab" href="#menu2">Menu 2</a></li>
												<li><a data-toggle="tab" href="#menu3">Menu 3</a></li>
											</ul>

										</li>
										<li class="list-group-item">
											<div class="tab-content">
												<div id="home" class="tab-pane fade in active show">
													<ul class="list-group">
														<li class="list-group-item"><div class="media">
																<img class="align-self-start mr-3"
																	src="${pageContext.request.contextPath}/images/chien-hon-tuyet-the.jpg"
																	width="70px" height="70px"
																	alt="Generic placeholder image">
																<div class="media-body">
																	<h7 class="mt-0"> <a href="#">Vạn Cổ Thần
																		Vương</a></h7>
																	<p>Chap 1</p>
																</div>
															</div></li>
														<li class="list-group-item"><div class="media">
																<img class="align-self-start mr-3"
																	src="${pageContext.request.contextPath}/images/chien-hon-tuyet-the.jpg"
																	width="70px" height="70px"
																	alt="Generic placeholder image">
																<div class="media-body">
																	<h7 class="mt-0"> <a href="#">Vạn Cổ Thần
																		Vương</a></h7>
																	<p>Chap 1</p>
																</div>
															</div></li>

													</ul>


												</div>
												<div id="menu1" class="tab-pane fade">
													<ul class="list-group">
														<li class="list-group-item"><div class="media">
																<img class="align-self-start mr-3"
																	src="${pageContext.request.contextPath}/images/chien-hon-tuyet-the.jpg"
																	width="70px" height="70px"
																	alt="Generic placeholder image">
																<div class="media-body">
																	<h7 class="mt-0"> <a href="#">Vạn Cổ Thần
																		Vương</a></h7>
																	<p>Chap 11</p>
																</div>
															</div></li>
														<li class="list-group-item"><div class="media">
																<img class="align-self-start mr-3"
																	src="${pageContext.request.contextPath}/images/chien-hon-tuyet-the.jpg"
																	width="70px" height="70px"
																	alt="Generic placeholder image">
																<div class="media-body">
																	<h7 class="mt-0"> <a href="#">Vạn Cổ Thần
																		Vương</a></h7>
																	<p>Chap 11</p>
																</div>
															</div></li>

													</ul>


												</div>
												<div id="menu2" class="tab-pane fade">
													<ul class="list-group">
														<li class="list-group-item"><div class="media">
																<img class="align-self-start mr-3"
																	src="${pageContext.request.contextPath}/images/chien-hon-tuyet-the.jpg"
																	width="70px" height="70px"
																	alt="Generic placeholder image">
																<div class="media-body">
																	<h7 class="mt-0"> <a href="#">Vạn Cổ Thần
																		Vương</a></h7>
																	<p>Chap 2</p>
																</div>
															</div></li>
														<li class="list-group-item"><div class="media">
																<img class="align-self-start mr-3"
																	src="${pageContext.request.contextPath}/images/chien-hon-tuyet-the.jpg"
																	width="70px" height="70px"
																	alt="Generic placeholder image">
																<div class="media-body">
																	<h7 class="mt-0"> <a href="#">Vạn Cổ Thần
																		Vương</a></h7>
																	<p>Chap 2</p>
																</div>
															</div></li>

													</ul>

												</div>
												<div id="menu3" class="tab-pane fade">
													<ul class="list-group">
														<li class="list-group-item"><div class="media">
																<img class="align-self-start mr-3"
																	src="${pageContext.request.contextPath}/images/chien-hon-tuyet-the.jpg"
																	width="70px" height="70px"
																	alt="Generic placeholder image">
																<div class="media-body">
																	<h7 class="mt-0"> <a href="#">Vạn Cổ Thần
																		Vương</a></h7>
																	<p>Chap 3</p>
																</div>
															</div></li>
														<li class="list-group-item"><div class="media">
																<img class="align-self-start mr-3"
																	src="${pageContext.request.contextPath}/images/chien-hon-tuyet-the.jpg"
																	width="70px" height="70px"
																	alt="Generic placeholder image">
																<div class="media-body">
																	<h7 class="mt-0"> <a href="#">Vạn Cổ Thần
																		Vương</a></h7>
																	<p>Chap 3</p>
																</div>
															</div></li>

													</ul>

												</div>
											</div>

										</li>
									</ul>
									<br>



								</div>

							</div>

						</div>

					</div>
					<div>
						<nav aria-label="Page navigation example">
							<ul class="pagination justify-content-center "
								style="padding: 20px;">
								<li class="page-item disabled"><a class="page-link"
									href="#" tabindex="-1">Previous</a></li>
								<li class="page-item"><a class="page-link" href="#">1</a></li>
								<li class="page-item"><a class="page-link" href="#">2</a></li>
								<li class="page-item"><a class="page-link" href="#">3</a></li>
								<li class="page-item"><a class="page-link" href="#">Next</a>
								</li>
							</ul>
						</nav>
					</div>
				</div>
			</div>


		</main>
	</div>
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



