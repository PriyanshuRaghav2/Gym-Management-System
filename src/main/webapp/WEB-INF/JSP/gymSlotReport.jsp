<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gym Slots</title>
<style type="text/css">
body {
    font-family: Arial, sans-serif;
    text-align: center;
    background-image: url("/images/gym1.jpg");
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    margin: 0;
    padding: 0;
}

header {
    font-size: 45px;
    margin: 50px 0 20px 0;
    font-weight: 800;
    color: white;
    text-shadow: 2px 2px 4px #000;
}

a {
    text-decoration: none;
    font-size: 20px;
    color: #4CAF50;
    margin: 20px;
    font-weight: 700;
    padding: 10px 20px;
    border: 2px solid #4CAF50;
    border-radius: 25px;
    transition: all 0.3s ease;
}

a:hover {
    text-decoration: underline;
    color: white;
    background-color: #4CAF50;
}

ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    background-color: #000;
    overflow: hidden;
}

li {
    display: inline;
    padding: 10px 20px;
}

table {
    margin: 20px auto;
    border-collapse: collapse;
    width: 90%;
    background-color: white;
    opacity: 0.95;
    border-radius: 10px;
    overflow: hidden;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
}

th, td {
    border: 1px solid #ddd;
    padding: 12px;
    text-align: center;
}

th {
    background-color: #4CAF50;
    color: white;
    font-weight: bold;
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
        <header>All Slots</header>
        <table>
            <tr>
                <th>Slot Id</th>
                <th>Slot Timing</th>
                <th>Slot Pricing</th>
                <th>Slot Enquire</th>
            </tr>
            <c:forEach items="${slotList}" var="slot">
                <tr>
                    <td>${slot.slotId}</td>
                    <td>${slot.slotTime}</td>
                    <td>${slot.pricing}</td>
                    <td><a href="/slot-show/${slot.slotId}">See Enquire</a></td>
                </tr>
            </c:forEach>
        </table>
        <a href="/index">Home</a>
    </div>
</body>
</html>
