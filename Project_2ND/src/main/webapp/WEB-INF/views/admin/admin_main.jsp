<!-- 관리자 페이지 메인화면 - 02.16 장재호 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="/resources/css/admin/admin_main.css" rel="stylesheet">
<link href="/resources/css/admin/chart.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
</head>
<body>
<div id="navSection">
	<%@ include file="/WEB-INF/views/common/navbar.jsp" %>
</div>
<div id="navSection"></div>
<h1>관리자 페이지2415315153</h1>

<div class="mainCon">
	<div class="categoryCon">
		<canvas id="categoryChart"></canvas>
	</div>
	
	<div class="genreCon">
		<canvas id="genreChart"></canvas>
	</div>
</div>

<input id="categoryH" type="hidden" value="${category}">
<input id="genreH" type="hidden" value="${genre}">

<script src="/resources/js/admin/category_chart.js"></script>
<script src="/resources/js/admin/genre_chart.js"></script>
</body>
</html>
