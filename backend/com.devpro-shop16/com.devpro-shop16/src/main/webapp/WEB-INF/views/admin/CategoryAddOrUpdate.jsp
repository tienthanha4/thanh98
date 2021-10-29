
<%@ page language="java" contentType="text/html; charset=UTF -8"
	pageEncoding="ISO-8859-1"%>
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
<title>Them Bai Viet</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/admin.css">
</head>
<body>
	<main>
		<jsp:include page="/WEB-INF/views/admin/layout/Header.jsp"></jsp:include>
		<div class="bottom_content">
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="#">Home</a></li>
					<li class="breadcrumb-item active" aria-current="page">Library</li>
				</ol>
			</nav>
			<div class="container-fluid">

				<h1 class="mt-4">Add/Upadte category</h1>
				<p>
				<form method="POST"
					action="${pageContext.request.contextPath}/Admin/category/addOrUpdate"
					enctype="multipart/form-data">
					<div class="container">
						<section class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">Panel heading</h3>
							</div>
							<div class="panel-body">
									<div class="form-group">
										<label for="name" class="col-sm-3 control-label">Name</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" name="name" id="name"
												placeholder="">
										</div>
									</div>
									<!-- form-group // -->
									<div class="form-group">
										<label for="description" class="col-sm-3 control-label">descrip</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" name="description" id="description"
												placeholder="">
										</div>


										<a
											href="${pageContext.request.contextPath}/Admin/product/list"
											class="btn btn-secondary active" role="button"
											aria-pressed="true">Back to list</a>
										<button type="submit" class="btn btn-primary">Save
											Product</button>

										<form>

											</p>
									</div>
							</div>
					</div>
	</main>
</body>
<script
	src="${pageContext.request.contextPath}/boottrap/bootstrap.min.css"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js">
	
</script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/admin.js">

</script>
</html>
<!-- jquery truoc bootrap -> script -->
