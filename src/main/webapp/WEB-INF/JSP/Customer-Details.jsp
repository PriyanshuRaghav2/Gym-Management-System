<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Customer Details</title>
<style>
body {
	font-family: Arial, sans-serif;
	text-align: center;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

.container {
	width: 80%;
	max-width: 800px;
	margin: 50px auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h1 {
	color: #4CAF50;
	margin-bottom: 20px;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-bottom: 20px;
}

th, td {
	border: 1px solid #ddd;
	padding: 10px;
	text-align: left;
}

th {
	background-color: #4CAF50;
	color: white;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

a {
	text-decoration: none;
	color: #4CAF50;
	font-weight: bold;
}

a:hover {
	text-decoration: underline;
}

.home-button {
	padding: 10px 20px;
	font-size: 16px;
	color: #fff;
	background-color: #4CAF50;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.home-button:hover {
	background-color: #45a049;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Customer Details</h1>
		<table>
			<tr>
				<th>Customer User Name</th>
				<th>Email</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${userList}" var="customer">
				<tr>
					<td>${customer.username}</td>
					<td>${customer.email}</td>
					<td>${customer.firstName}</td>
					<td>${customer.lastName}</td>
					<td><a href="/deleteCustomer/${customer.username}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="/index"><button class="home-button">Back To Home</button></a>
	</div>
</body>
</html>
