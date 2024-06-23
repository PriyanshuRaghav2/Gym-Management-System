<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Gym Services</title>
<style type="text/css">
body {
    font-family: Arial, sans-serif;
    text-align: center;
    background-image: url("/images/gym3.jpg");
    background-size: cover;
    background-position: unset; 
    background-repeat: no-repeat;
    color: white;
    margin: 0;
    padding: 0;
}

.header {
    font-size: 45px;
    margin-bottom: 26px;
    font-weight: 800;
}

.form-container {
    width: 60%;
    max-width: 600px;
    margin: 20px auto;
    background-color: rgba(0, 0, 0, 0.6);
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
}

.form-container form {
    display: flex;
    flex-direction: column;
}

.form-container form label {
    margin-bottom: 10px;
    color: white; /* Ensure labels are visible */
}

.form-container form input[type="text"],
.form-container form input[type="number"] {
    padding: 10px;
    margin-bottom: 15px;
    border-radius: 5px;
    border: 1px solid #ccc;
    font-size: 16px;
    width: calc(100% - 22px); /* Adjusted width calculation for inputs */
}

.form-container form button {
    padding: 10px 20px;
    margin-top: 10px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px;
}

.form-container form button[type="submit"] {
    background-color: #4CAF50;
    color: white;
}

.form-container form button[type="reset"] {
    background-color: #f44336;
    color: white;
}
a {
	text-decoration: none;
	font-size: 18px;
	color: white;
	margin: 12px;
}

a:hover {
	text-decoration: underline;
	color: yellow;
	background-color: white;
}
</style> 
</head>
<body>
    <div class="header">
        Gym Services
    </div>
    <div class="form-container">
        <form action="/gymService" method="post">
            <input type="hidden" name="itemId" value="${itemRecord.itemId}" />
            <label for="itemName">Enter Service Name:</label>
            <input type="text" id="itemName" name="itemName" />
            <label for="totalSeat">Enter Total Seats:</label>
            <input type="number" id="totalSeat" name="totalSeat" />
            <button type="submit">Submit</button>
            <button type="reset">Reset</button>
            <a href="/index">Home</a>
        </form>
    </div>
</body>
</html>