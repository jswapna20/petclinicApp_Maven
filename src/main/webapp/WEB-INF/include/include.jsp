<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>





<html>
	<head>
		<style>
			a:hover {
				background-color: ffff99;
			}

			.button:hover {
				color:white;
				font-weight:bold;
				background-color: 0099cc;
			}

			.subButtons:hover {
				color:white;
				font-weight:bold;
				background-color: cc6666;
			}
		</style>
		
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"
href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

		
	</head>
<body style="background-color:lightgreen;">

<div style= "background-color: #00ffff;" class="container">

		<p align="right" style="color:white;font-weight:bold; font-size:21px;">PET CLINIC MANAGEMENT</p>

		<p style= "background-color: #66ffff;">
			<spring:url var="fetchUrl" value="/petsearch" />
			<a style ="color:white; font-size:17px; font-weight:bold; background-color:3399FF;" href="${fetchUrl}">PETS</a>

			
			<spring:url var="fetchUrl" value="/vetsearch" />
			<a style ="color:white;font-size:17px; font-weight:bold; background-color:3399FF;" href="${fetchUrl}">VETS</a>

			<spring:url var="fetchUrl" value="/logout" />
			<a href="${fetchUrl}" style ="color:white;font-size:17px;font-weight:bold;background-color:3399FF;float:right;">LOGOUT</a>
		</p>

</div>

<br></br>
</body>
</html>
