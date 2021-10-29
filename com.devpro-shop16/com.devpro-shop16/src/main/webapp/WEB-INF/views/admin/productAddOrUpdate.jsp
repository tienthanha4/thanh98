
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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin.css">
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

						<sf:form method="POST" action="${pageContext.request.contextPath}/Admin/product/addOrUpdate" modelAttribute="Products" enctype="multipart/form-data">
	
							<!-- Xác định là thêm mới hay chỉnh sửa -->
							<sf:hidden path="id"/>
	
							<div class="form-group">
								<label for="category">Category (required)</label>
								<sf:select path="categories.id" class="form-control" id="category">
									<sf:options items="${categories}" itemValue="id" itemLabel="name" />
								</sf:select>
							</div>
							
							<div class="form-group">
								<label for="title">Title (required)</label>
								<sf:input path="title" autocomplete="off" type="text" class="form-control" id="title" placeholder="${products.title}" required="required"></sf:input>
							</div>
							
							<div class="form-group">
								<label for="price">Price (required)</label>
								<sf:input type="number" autocomplete="off" path="price" class="form-control" id="price" placeholder="${products.price}" required="required"></sf:input>
							</div>
							
							<div class="form-group">
								<label for="priceSale">Price Sale (required)</label>
								<sf:input type="number" autocomplete="off" path="priceSale" class="form-control" id="priceSale" placeholder="${products.priceSale}" required="required"></sf:input>
							</div>
							
							<div class="form-group">
								<label for="short_description">Description (required)</label>
								<sf:textarea autocomplete="off" path="short_description" class="form-control" placeholder="${products.short_description}" id="short_description" rows="3" required="required"></sf:textarea>
							</div>
							
							<div class="form-group">
								<label for="detail_description">Details (required)</label>
								<sf:textarea autocomplete="off" path="detail_description" class="form-control summernote" id="detail_description" rows="3" required="required"></sf:textarea>
							</div>
							
							<div class="form-group form-check">
								<sf:checkbox path="is_hot" class="form-check-input" id="isHot" />
								<label class="form-check-label" for="isHot">Is Hot Product?</label>
							</div>
	
							<div class="form-group">
								<label for="fileProductAvatar">Avatar</label> 
								<input id="fileProductAvatar" name="productAvatar" type="file" class="form-control-file">
							</div>
							
							<%-- <div class="form-group">
								<img alt="" style="width: 100px; height: 100px;" src="${pageContext.request.contextPath}/upload/${product.avatar}">
							</div> --%>
	
							<div class="form-group">
								<label for="fileProductPictures">Picture(Multiple)</label> 
								<input id="fileProductPictures" name="productPictures" type="file" class="form-control-file" multiple="multiple">
							</div>
							
							<%-- <div class="form-group">
								<c:forEach items="${product.productImages}" var="productImage">
									<img alt="" style="width: 100px; height: 100px;" src="${pageContext.request.contextPath}/upload/${productImage.path}">
								</c:forEach>
							</div> --%>
							
							<%-- <div class="form-group">
								<label for="createdDate">Created date:</label> 
								<sf:input path="createdDate"/>
							</div> --%>
							
							<a href="${pageContext.request.contextPath}/Admin/product/list" class="btn btn-secondary active" role="button" aria-pressed="true">Back to list</a>
							<button type="submit" class="btn btn-primary">Save Product</button>
	
						</sf:form>

					</p>                    
                    
                </div>
            </div>
        </div>
	
	
	</main>							
</body>
<script src="${pageContext.request.contextPath}/boottrap/bootstrap.min.css"></script>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin.js">

</script>
</html>
<!-- jquery truoc bootrap -> script -->
