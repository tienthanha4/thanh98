<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- taglib JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- taglib SPRING-FORM -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<header>

	<a href="#" class="logo"><i class="fas fa-utensils"></i>resto.</a>

	<nav class="navbar">
		<a class="active" href="${base}/home">home</a> <a href="#dishes">dishes</a>
		 <a href="#menu">menu</a> <a href="#review">review</a>
		<a href="#order">order</a>
	</nav>

	<div class="icons">
		<i class="fas fa-bars" id="menu-bars"></i> <i class="fas fa-search"
			id="search-icon"></i> <a href="#" class="fas fa-heart"></a> <a
			href="${base}/home/shopcart" class="fas fa-shopping-cart"
			id="soluong">${totalItems} </a>
		<c:if test="${userLogined != null}">
			<a href="${base}/logout" class="fas fa-user"></a>
		</c:if>


	</div>
	<c:if test="${userLogined == null}">
	<div style="display:inherit;">
	<a href="${base}/login" style="margin-right: 2px"><h3>Login</h3></a>/
		<a href="${base}/resgitry" style= "margin-left: 2px"><h3>Resgitry</h3></a>
	</div>
		
	</c:if>
	
</header>

<!-- header section ends-->

<!-- search form  -->

<form action="" id="search-form">
	<input type="search" placeholder="search here..." name=""
		id="search-box"> <label for="search-box" class="fas fa-search"></label>
	<i class="fas fa-times" id="close"></i>
</form>
