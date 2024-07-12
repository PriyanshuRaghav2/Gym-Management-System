<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Book Your Space</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-image: url("/images/gym2.jpg");
        background-size: cover;
        background-position: center;
        background-repeat: no-repeat;
        color: #333;
        margin: 0;
        padding: 0;
    }

    h3 {
        font-size: 24px;
        font-weight: 600;
        color: white;
        text-align: center;
        text-shadow: 2px 2px 4px #000;
        margin: 20px 0;
    }

    div {
        background-color: rgba(255, 255, 255, 0.8);
        border-radius: 10px;
        padding: 20px;
        margin: 50px auto;
        width: 80%;
        max-width: 800px;
        box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin: 20px 0;
        background-color: white;
    }

    th, td {
        padding: 12px;
        text-align: center;
        border: 1px solid #ddd;
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

    button {
        display: block;
        width: 100%;
        padding: 15px;
        background-color: #4CAF50;
        color: white;
        font-size: 16px;
        font-weight: bold;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    button:hover {
        background-color: #45a049;
    }
    
    .home-button {
        background-color: #555;
        margin-top: 10px;
    }

    .home-button:hover {
        background-color: #333;
    }
    
</style>
</head>
<body>
    <div> 
        <h3>Slot ID: ${slot.slotId}</h3>
        <h3>Slot Time: ${slot.slotTime}</h3>
        <h3>Pricing: ${slot.pricing}</h3>
    </div>
    <div>
        <form action="/slot-book" method="post">
            <input type="hidden" value="${slot.slotId}" name="slotId"/>
            <table>
                <tr>
                    <th>Item No</th>
                    <th>Item Name</th>
                    <th>Total Seats</th>
                    <th>Available Seats</th>
                    <th>Select</th>
                </tr>
                <c:forEach items="${itemList}" var="item">
                    <tr>
                        <td>${item.itemId}</td>
                        <td>${item.itemName}</td>
                        <td>${item.totalSeat}</td>
                        <td>${item.seatVacent}</td>
                        <td><input name="itemId" type="radio" value="${item.itemId}"/></td>
                    </tr>
                </c:forEach>
            </table>
            <button type="submit">Book</button>
        </form>
        <a href="/index"><button class="home-button">Home</button></a>
    </div>
</body>
</html>
