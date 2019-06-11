<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<link rel="stylesheet" type="text/css" href="styles/styles.css">
</head>
<body>
	<h1>Hello from Index</h1>
	
	<c:out value="${ 2 + 3 }" />
	
	<form action="/posted" method="post" autocomplete="off" >
		<input type="text" name="name">
		<input type="number" name="age">
		<button>Submit</button>
	</form>
	
	
	
	<section>
		<p>Previous name was <c:out value="${name }"/></p>
		<p>Previous age was <c:out value="${age }" /></p>
	</section>
</body>
</html>