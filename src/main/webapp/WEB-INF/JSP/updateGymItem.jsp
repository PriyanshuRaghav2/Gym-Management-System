<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Update Gym Services</title>
<style type="text/css">
body {
    font-family: Arial, sans-serif;
    text-align: center;
    background-image: url("/images/gym3.jpg");
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    color: white;
    margin: 0;
    padding: 0;
}

.header {
    font-size: 3rem;
    margin: 20px 0;
    font-weight: 700;
    text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
}

.form-container {
    width: 80%;
    max-width: 500px;
    margin: 40px auto;
    background-color: rgba(0, 0, 0, 0.7);
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 0 15px rgba(0, 0, 0, 0.5);
}

.form-container form {
    display: flex;
    flex-direction: column;
}

.form-container form label {
    margin-bottom: 10px;
    font-size: 1.1rem;
    color: white;
}

.form-container form input[type="text"], .form-container form input[type="number"] {
    padding: 12px;
    margin-bottom: 20px;
    border-radius: 6px;
    border: 1px solid #ccc;
    font-size: 1rem;
    width: 100%;
    box-sizing: border-box;
}

.form-container form button {
    padding: 12px 24px;
    margin-top: 10px;
    border: none;
    border-radius: 6px;
    cursor: pointer;
    font-size: 1rem;
    transition: background-color 0.3s ease;
}

.form-container form button[type="submit"] {
    background-color: #4CAF50;
    color: white;
}

.form-container form button[type="submit"]:hover {
    background-color: #45a049;
}

.form-container form button[type="reset"] {
    background-color: #f44336;
    color: white;
}

.form-container form button[type="reset"]:hover {
    background-color: #e53935;
}

a {
    text-decoration: none;
    font-size: 1.1rem;
    color: white;
    margin: 20px;
    display: inline-block;
}

a:hover {
    text-decoration: underline;
    color: yellow;
    background-color: rgba(0, 0, 0, 0.5);
    padding: 10px;
    border-radius: 5px;
}
</style>
</head>
<body>
    <div class="header">Update Gym Services</div>
    <div class="form-container">
        <form action="/updateGymItem" method="post">
            <input type="hidden" name="itemId" value="${gymItem.itemId}" />
            <label for="itemName">Enter Updated Service Name:</label>
            <input type="text" id="itemName" name="itemName" value="${gymItem.itemName}" required />
            
            <label for="totalSeat">Enter Updated Total Seats:</label>
            <input type="number" id="totalSeat" name="totalSeat" value="${gymItem.totalSeat}" required />
            
            <button type="submit">Update</button>
            <button type="reset">Reset</button>
        </form>
        <a href="/index">Home</a>
    </div>
</body>
</html>
