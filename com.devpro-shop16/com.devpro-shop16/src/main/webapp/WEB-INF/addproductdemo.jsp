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
			<div class="muti-tabs" id="muti-tabs">
				<div class="row">
					<div class="tab-content">
						<sf:form
							action="${pageContext.request.contextPath}/addproductdemo"
							method="POST" modelAttribute="Products">
							<div id="tab-2">
								<div>
									<h2 class="page-title">
										Bài Đăng ${time} <i class="fa fa-angle-right"></i>
									</h2>
									<h2 class="page-title">${infor}</h2>
								</div>
								<div class="input-group mb-3">

									<sf:input type="text" class="form-control tieude"
										placeholder="short_description" aria-label="Username"
										aria-describedby="basic-addon1" name="short_description"
										id="short_description" path="short_description"></sf:input>
									<sf:input type="text" class="form-control tieude"
										placeholder="price" aria-label="Username"
										aria-describedby="basic-addon1" name="price" id="price"
										path="price"></sf:input>
									<sf:input type="text" class="form-control tieude"
										placeholder="detail_description" aria-label="Username"
										aria-describedby="basic-addon1" name="detail_description"
										id="detail_description" path="detail_description"></sf:input>
									<sf:input type="text" class="form-control tieude"
										placeholder="title" aria-label="Username"
										aria-describedby="basic-addon1" name="title"
										id="title" path="title"></sf:input>


								</div>
								<div class=" gr-button" role="group" aria-label="Basic example">
							<a type="submit" class="btn btn-success btn-luu">Luu</a> <%-- <a
								type="button" class="btn btn-success "
								onclick="SaveBv('${pageContext.request.contextPath}')">Save
								Ajax</a> --%>

						</div>
								
						</sf:form>
						

					</div>
				</div>
			</div>
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