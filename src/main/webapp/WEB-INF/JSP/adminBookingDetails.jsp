<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin Bookings</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        color: #333;
        margin: 0;
        padding: 0;
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    h1 {
        text-align: center;
        margin: 20px 0;
        color: #4CAF50;
    }

    table {
        width: 80%;
        margin: 20px 0;
        border-collapse: collapse;
        background-color: white;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    th, td {
        padding: 12px;
        text-align: center;
        border: 1px solid #ddd;
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

    .button-container {
        text-align: center;
        margin-top: 20px;
    }

    button {
        padding: 10px 20px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    button:hover {
        background-color: #45a049;
    }

    .home-link {
        display: block;
        text-align: center;
        margin-top: 20px;
        color: #4CAF50;
        text-decoration: none;
        font-weight: bold;
    }

    .home-link:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
    <h1>Admin Booking Details</h1>

    <table>
        <tr>
            <th>Booking ID</th>
            <th>User Name</th>
            <th>Slot ID</th>
            <th>Item ID</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${bookingList}" var="booking">
            <tr>
                <td>${booking.bookingId}</td>
                <td>${booking.userName}</td>
                <td>${booking.slotId}</td>
                <td>${booking.itemId}</td>
                <td><a href="/delete-booking/${booking.bookingId}">
                        <button type="button">Delete</button>
                    </a></td>
            </tr>
        </c:forEach>
    </table>

    <a href="/index" class="home-link">Home</a>
</body>
</html>
