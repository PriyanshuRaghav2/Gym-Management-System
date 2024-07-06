<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Gym Management System - Register</title>
<style type="text/css">
body {
    margin: 0;
    padding: 0;
    font-family: Arial, sans-serif;
    background-image: url("/images/gym3.jpg");
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    text-align: center;
    color: white;
}

.header {
    background-color: rgba(0, 0, 0, 0.8);
    padding: 20px;
    font-size: 2rem;
    color: #f1c40f;
}

.container {
    background: rgba(0, 0, 0, 0.7);
    padding: 2rem;
    border-radius: 10px;
    width: 80%;
    max-width: 400px;
    margin: 5% auto;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
}

h2 {
    margin-bottom: 1.5rem;
    font-size: 2rem;
    color: #f1c40f;
}

label {
    display: block;
    margin: 1rem 0 0.5rem;
    font-size: 1rem;
    color: #f1c40f;
}

input[type="text"],
input[type="email"],
input[type="password"] {
    width: 100%;
    padding: 0.5rem;
    margin-bottom: 1rem;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 1rem;
}

.password-strength {
    display: block;
    margin-top: 0.5rem;
    font-size: 0.8rem;
    color: #f1c40f;
    text-align: left;
}

button {
    background-color: #f1c40f;
    border: none;
    color: black;
    padding: 0.75rem 1.5rem;
    text-decoration: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 1rem;
    transition: background-color 0.3s ease;
}

button:hover {
    background-color: #d4ac0d;
}

.login-link {
    display: block;
    margin-top: 2rem;
    font-size: 1.2rem;
    color: #f1c40f;
    text-decoration: none;
}

.login-link:hover {
    text-decoration: underline;
}

.radio-group {
    text-align: left;
    margin: 1rem 0;
}

.radio-group label {
    margin-right: 1rem;
}
</style>
<script type="text/javascript">
function validatePassword() {
    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirm-password").value;

    if (password != confirmPassword) {
        alert("Passwords do not match.");
        return false;
    }

    if (password.length < 8) {
        alert("Password must be at least 8 characters long.");
        return false;
    }

    return true;
}
</script>
</head>
<body>
    <div class="header">
        Gym Management System
    </div>
    <div class="container">
        <h2>Register</h2>
        <form:form action="/register" method="post" onsubmit="return validatePassword()" modelAttribute="userRecord">
            <label for="fullname">First Name:</label>
            <input type="text" id="firstname" name="firstName" required>
            
            <label for="fullname">Last Name:</label>
            <input type="text" id="lastname" name="lastName" required>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>

            <label for="username">User ID:</label>
            <input type="text" id="username" name="username" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" pattern=".{8,}" title="Password must be at least 8 characters long" required>
            <span class="password-strength">Password must be at least 8 characters long.</span>

            <label for="confirm-password">Confirm Password:</label>
            <input type="password" id="confirm-password" name="confirm-password" required>

            <div class="radio-group">
                <label>User Type:</label>
                <label><input type="radio" name="type" value="admin" required> Admin</label>
                <label><input type="radio" name="type" value="customer" required> Customer</label>
            </div>

            <button type="submit">Register</button>
        </form:form>
        <a href="/loginpage" class="login-link">Already have an account? Login</a>
    </div>
</body>
</html>
