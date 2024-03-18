<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<html>
<head>
    <title>Demo Application</title>
     <link rel="stylesheet" href="./static/css/style.css">
</head>
<body>
<div class="rootDiv">
    <div class="card">
        <a href="<%=request.getContextPath()%>/products">
            <h2>Products</h2>
            <p>Click here to view products</p>
        </a>
    </div>
    <div class="card">
        <a href="<%=request.getContextPath()%>/orders">
            <h2>Orders</h2>
            <p>Click here to view orders</p>
        </a>
    </div>
</div>
</body>
</html>