<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Booking Successful</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #f8f9fa;
            color: #333;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .confirmation {
            text-align: center;
            background: #fff;
            border-radius: 8px;
            padding: 40px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
        }
        .confirmation h1 {
            color: #007bff;
            margin-bottom: 20px;
        }
        .confirmation p {
            font-size: 18px;
            line-height: 1.6;
            margin-bottom: 10px;
        }
        .home-link {
            display: block;
            text-align: center;
            margin-top: 20px;
            text-decoration: none;
            color: #007bff;
            transition: color 0.3s ease;
        }
        .home-link:hover {
            color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="confirmation">
        <h1>Booking Successful!</h1>
        <p>Your slot has been successfully booked.</p>
        <p>Slot Timing: ${slot.slotTime}</p>
        <p>Gym Service: ${item.itemName}</p>
        <a href="/index" class="home-link">Home</a> <!-- Adjust the link to your home page -->
    </div>
</body>
</html>
