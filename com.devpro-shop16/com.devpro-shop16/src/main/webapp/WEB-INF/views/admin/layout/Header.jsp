<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- taglib JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- taglib SPRING-FORM -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="sidbar_left">
			<div class="logo"><a href="${base}/">Home</a></div>
			<div class="menu_sidebar">
				<ul class="nav nav-tabs">
					<li><a href="${base}/Admin/product/list">Products</a></li>
					<li><a href="${base}/Admin/category/list">Categories</a></li>
					<li><a href="${base}/Admin/cart/list">Oder</a></li>
					

				</ul>
			</div>
		</div>
		<div class="content">
			<div class="top_content">
				<div class="top_left">
					<div class="input-group-append">
						<button type="button" id="show_hide_sidebar">
							<i class="fas fa-ellipsis-v"></i>
						</button>

					</div>
					<form method="GET" action="#" class="form-control">
						<input type="text" name="keywrod" placeholder="TÃ¬m kiáº¿m ...">
						<button type="submit">
							<i class="fas fa-search"></i>
						</button>
					</form>
				</div>
				<c:if test="${userLogined != null}">
				<div class="top_right">
					<button class="btn_account">
						<img src="${pageContext.request.contextPath}/images/avatar10.jpg" width="25px"> ${userLogined.username} <i
							class="fas fa-chevron-down"></i>
						<div class="info hide_info">
							<ul>
								<li><a href="#">Profile</a></li>
								<li><a href="#">Setting</a></li>
								<li><a href="#">Change password</a></li>
								<li><a href="${base}/logout">Logout</a></li>
							</ul>
						</div>
					</button>
				</div>
				</c:if>
			</div>
