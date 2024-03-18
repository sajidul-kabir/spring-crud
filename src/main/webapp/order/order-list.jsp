<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Product Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: teal">
			<div>
				<a href="<%=request.getContextPath()%>/" class="navbar-brand"> Product
					Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/products"
					class="nav-link">Products</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Orders</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/orders/new-order" class="btn btn-success">Add
					New Order</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Customer Name</th>
						<th>Product Name</th>
						<th>Transaction</th>
						<th>Address</th>



					</tr>
				</thead>
				<tbody>

					<c:forEach var="order" items="${listOrders}">

						<tr>
							<td><c:out value="${order.id}" /></td>
							<td><c:out value="${order.customer_name}" /></td>
							<td><c:out value="${order.product}" /></td>
							<td><c:out value="${order.transaction}" /></td>
							<td><c:out value="${order.address}" /></td>



						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>