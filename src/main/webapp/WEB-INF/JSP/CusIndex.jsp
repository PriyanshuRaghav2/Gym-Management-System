<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>GYM Management System</title>
<style type="text/css">
    body {
        font-family: Arial, sans-serif;
        text-align: center;
        background-image: url("/images/gym3.jpg");
        background-size: cover;
        background-position: unset; 
        background-repeat: no-repeat;
        margin: 0;
        padding: 0;
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
        color: white;
        margin: 0 10px;
    }

    a:hover {
        text-decoration: underline;
        color: yellow;
        background-color: white;
    }

    ul {
        list-style-type: none;
        margin: 0; 
        padding: 0;
        background-color: #000000;
        display: block;
    }

    li {
        display: inline-block;
        position: relative;
        padding: 10px;
    }

    li ul {
        display: none;
        position: absolute;
        top: 100%;
        left: 0;
        background-color: #000;
        padding: 0;
        list-style: none;
    }

    li:hover ul {
        display: block;
    }

    li ul li {
        display: block;
        padding: 5px 10px;
    }

    li ul li a {
        color: white;
        display: block;
    }

    li ul li a:hover {
        background-color: #575757;
    }
</style>

</head>
<body>
    <div align="center">
        <header>Welcome to GYM Management System</header>
        <h3>
            <ul>
                <li><a href="/index">Home</a></li>
                <li><a href="/customer-gymSlotReport">Book Your Space</a></li>
                <li><a href="/customerBooking">Booking Details</a></li>
                <li><a href="/feedback">Feedback</a></li>
                <li><a href="/logout">Logout</a>&nbsp;&nbsp;</li>
            </ul>
        </h3>
    </div>
</body>
</html>
