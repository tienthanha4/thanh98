
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
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" />
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

				<h1 class="mt-4">Add/Upadte Products</h1>

				<p>

					<sf:form method="get"
						action="${pageContext.request.contextPath}/Admin/product/list"
						modelAttribute="Products" enctype="multipart/form-data">
						<div style="display: flex;">
							<input type="hidden" id="page" name="page"> <input
								type="text" id="keyword" name="keyword" class="form-control"
								placeholder="Search" value="${seachModel.keyword }"
								style="width: 20%"> <select class="form-select"
								aria-label="Default select example"
								style="    height: 32
px
;
    margin-left: 4%;
    margin-right: 1%;
    width: 20%;"
								name="sx">
								<option value="price">price</option>
								<option value="tb_rate">Rating</option>
								<option value="id">new</option>
							</select>
							<button type="submit" id="btnSearch" name="btnSearch"
								value="Search" class="btn btn-primary">Seach</button>
							<%-- <h1 id="toltal">${toltal}</h1>
 --%>
						</div>
						<a
							href="${pageContext.request.contextPath}/Admin/product/addOrUpdate"><button
								type="button" class="btn btn-secondary"
								style="margin-top: 5px; margin-bottom: 5px">them</button></a>



						<table class="table">
							<thead>
								<tr>
									<th scope="col">#</th>
									<th scope="col">Name</th>
									<th scope="col">Price</th>
									<th scope="col">Status</th>
									<th scope="col">Descip</th>
									<th scope="col">Category</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="products" items="${productswithPaging.data}">
									<tr>
										<th scope="row">${products.id}</th>
										<td>${products.title}</td>
										<td>${products.price}</td>
										<td id="${products.id}"><c:if
												test="${products.status == 'true'}">
										         oke
										     </c:if> <c:if test="${products.status == 'false'}">
									         delete
									     </c:if></td>

										<td>${products.short_description}</td>
										<td>${products.categories.name}
										<td style="display: flex;">
										<c:if test="${products.status == true}">
										<a
											href="${pageContext.request.contextPath}/Admin/product/edit/${products.id}">
												<button type="button" class="btn btn-primary">sua</button>
										</a> 
										<a>	<button type="button" class="btn btn-danger"
												onclick="deleteProductById('${pageContext.request.contextPath}',${products.id}) ">Xoa</button></a>
												</c:if>
										</td>
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



	</main>
</body>
<script
	src="${pageContext.request.contextPath}/boottrap/bootstrap.min.css"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>




<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.simplePagination.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/admin.js">	
	
</script>

<script type="text/javascript">
			$( document ).ready(function() {
				$("#paging").pagination({ 
					currentPage: ${productswithPaging.currentPage},
			        items: ${productswithPaging.totalItems},
			        itemsOnPage: 5,
			        cssStyle: 'dark-theme',
			        onPageClick: function(pageNumber, event) {
			        	 $('#page').val(pageNumber);
			        	$('#btnSearch').trigger('click');
					},
			    });
			});
		</script>
</html>
<!-- jquery truoc bootrap -> script -->
