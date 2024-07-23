<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	font-family: Arial, sans-serif;
	text-align: center;
	background-image: url("/images/gym1.jpg");
	background-size: cover;
	background-position: unset;
	background-repeat: no-repeat;
}

header {
	font-size: 45px;
	margin-bottom: 26px;
	font-weight: 800;
	color: white;
}

a {
	text-decoration: none;
	font-size: 20px;
	color: silver;
	margin: 50px;
	font-weight: 700;
}

a:hover {
	text-decoration: underline;
	color: gray;
	background-color: darkgray;
}

ul {
	list-style-type: none;
	margin: 0;
	padding: 5px;
	background-color: #000000;
}

li {
	display: inline;
}

table {
	margin: 20px auto;
	border-collapse: collapse;
	width: 80%;
	background-color: white;
	opacity: 0.9;
}

th, td {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: center;
}

th {
	background-color: #4CAF50;
	color: white;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

tr:hover {
	background-color: #ddd;
}
</style>
</head>
<body>
	<div>
		<header>All Services</header>
		<table>
			<tr>
				<th>Service Id</th>
				<th>Service Name</th>
				<th>Total Seats</th>
				<th>Add to Slot</th>
				<th>Update the Slot</th>
			</tr>
			<c:forEach items="${itemList}" var="item">
				<tr>
					<td>${item.itemId}</td>
					<td>${item.itemName}</td>
					<td>${item.totalSeat}</td>
					<td><a href="/slot-item-add/${item.itemId}">Add to Slots</a></td>
					<td><a href="/updateGymItem/${item.itemId}">Update</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="/index">Home</a>
	</div>
</body>
</html>