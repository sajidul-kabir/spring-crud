<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
        <div>
            <a href="<%=request.getContextPath()%>/" class="navbar-brand"> Product Management App </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/products" class="nav-link">Products</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">

            <form id="productForm">
            <caption>
                <h2>
                    <c:if test="${product != null}">
                        Update Product
                    </c:if>
                    <c:if test="${product == null}">
                        Add New Product
                    </c:if>
                </h2>
            </caption>

            <input type="hidden" id="id" name="id" value="<c:out value='${product.id}' />" />

            <fieldset class="form-group">
                <label for="name">Name</label>
                <input type="text" id="name" class="form-control" name="name" value="<c:out value='${product.name}' />" required>
            </fieldset>

            <fieldset class="form-group">
                <label for="price">Price</label>
                <input type="text" id="price" class="form-control" name="price" value="<c:out value='${product.price}' />">
            </fieldset>

            <button type="button" id="saveProductButton" class="btn btn-success">Save</button>
            </form>

        </div>
    </div>
</div>
<script>
var contextPath = '<%=request.getContextPath()%>';
var product='${product}'
</script>
<script src="../static/js/insertUpdateProduct.js"></script>
</body>
</html>
