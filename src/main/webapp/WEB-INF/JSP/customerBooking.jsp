<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Bookings</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            color: #333;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            margin: 20px 0;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 10px;
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

        .home-link {
            display: block;
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <h1>My Bookings</h1>
    
    <table>
        <tr>
            <th>Booking ID</th>
            <th>Slot ID</th>
            <th>Item ID</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${bookingList}" var="booking">
            <tr>
                <td>${booking.bookingId}</td>
                <td>${booking.slotId}</td>
                <td>${booking.itemId}</td>
                <td><a href="/cancel-booking/${booking.bookingId}">Cancel</a></td>
            </tr>
        </c:forEach>
    </table>

    <a href="/index" class="home-link">Home</a>
</body>
</html>
