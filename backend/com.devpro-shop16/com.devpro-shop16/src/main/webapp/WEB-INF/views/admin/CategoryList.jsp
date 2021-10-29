
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
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/simplePagination.css" />
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

				<h1 class="mt-4">Add/Upadte Category</h1>

				<p>

					<sf:form method="get"
						action="${pageContext.request.contextPath}/Admin/category/list"
						enctype="multipart/form-data">
						<input type="hidden" id="page" name="page">
						<button type="submit" id="pt" style="display: none;"></button>
						<div>
							<a
								href="${pageContext.request.contextPath}/Admin/category/addOrUpdate"><button
									type="button" class="btn btn-secondary">them</button></a>
							<%-- <input type="hidden" id="page" name="page">
							<input type="text" id="keyword" name="keyword" class="form-control" placeholder="Search" value="${seachModel.keyword }">
							<input type="text" id="keyword" name="categoryId" class="form-control" placeholder="Search" value="${seachModel.categoryId }"> 
							<button type="submit" id="btnSearch" name="btnSearch" value="Search"  class="btn btn-primary">Seach</button> --%>
						</div>

						<table class="table">
							<thead>
								<tr>
									<th scope="col">#</th>
									<th scope="col">First</th>
									<th scope="col">Last</th>
									<th scope="col">Handle</th>
									<th scope="col">Avatar</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="categories" items="${categorieswithPaging.data}">
									<tr>
										<th scope="row">${categories.id}</th>
										<td>${categories.name}</td>
										<td>${categories.description}</td>
										<td>${categories.seo}</td>
										<td>${categories.seo}</td>
										<%-- <td>
									<img alt="" src="${pageContext.request.contextPath}/upload/${products.avatar}">
									</td> --%>
										<td><a href="">
												<button type="button"
													onclick="deleteCategoryById('${pageContext.request.contextPath}',${categories.id})"
													class="
													btn btn-danger">Xoa</button>

										</a></td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
						<!-- Paging -->
						<div class="row">
							<div class="col-12 d-flex justify-content-center">
								<div id="paging"></div>
							</div>
						</div>

					</sf:form>

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
	src="${pageContext.request.contextPath}/js/jquery.simplePagination.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/admin.js">	
	
</script>
<script type="text/javascript">
			$( document ).ready(function() {
				$("#paging").pagination({ 
					currentPage: ${categorieswithPaging.currentPage},
			        items: ${categorieswithPaging.totalItems},
			        itemsOnPage: 5,
			        cssStyle: 'dark-theme',
			        onPageClick: function(pageNumber, event) {
			        	$('#page').val(pageNumber);
			        	$('#pt').trigger('click'); 
			        	
			        	
					},
			    });
			});
		</script>
</html>
<!-- jquery truoc bootrap -> script -->
