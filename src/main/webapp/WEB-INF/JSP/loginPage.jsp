<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log-In Page</title>
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
<style type="text/css">
body {
    margin: 0;
    padding: 0;
    font-family: 'Roboto', sans-serif;
    background: linear-gradient(to bottom, #2c3e50, #34495e);
    text-align: center;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.8);
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

.header {
    background-color: rgba(0, 0, 0, 0.8);
    padding: 15px;
    font-size: 3rem;
    color: #f1c40f;
    font-weight: 800;
    width: 100%;
    text-align: center;
    position: absolute;
    top: 0;
}

.container {
    background: rgba(0, 0, 0, 0.7);
    padding: 2rem;
    border-radius: 10px;
    width: 80%;
    max-width: 400px;
    margin: 7% auto;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
    animation: fadeIn 1s ease-in-out;
}

@keyframes fadeIn {
    from {
        opacity: 0;
        transform: scale(0.9);
    }
    to {
        opacity: 1;
        transform: scale(1);
    }
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
input[type="password"] {
    width: 100%;
    padding: 0.5rem;
    margin-bottom: 1rem;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 1rem;
}

input[type="submit"] {
    background-color: #f1c40f;
    border: none;
    color: black;
    padding: 0.75rem 1.5rem;
    text-decoration: none;
    border-radius: 40px;
    cursor: pointer;
    font-size: 1rem;
    transition: background-color 0.3s ease;
    width: 100%;
    margin-top: 1rem;
}

input[type="submit"]:hover {
    background-color: #d4ac0d;
}

.register-link {
    display: block;
    margin-top: 1rem;
    font-size: 1rem;
    color: #f1c40f;
    text-decoration: none;
}

.register-link:hover {
    text-decoration: underline;
}

.footer {
    background-color: rgba(0, 0, 0, 0.8);
    padding: 10px;
    position: absolute;
    bottom: 0;
    width: 100%;
    text-align: center;
    color: #f1c40f;
    font-size: 1rem;
}

.checkbox-container {
    display: flex;
    align-items: center;
    margin: 1rem 0;
}

.checkbox-container input {
    margin-right: 0.5rem;
}

@media (max-width: 600px) {
    .container {
        width: 90%;
        margin: 5% auto;
    }
}
</style>
<script>
function validateForm() {
    const username = document.forms["loginForm"]["username"].value;
    const password = document.forms["loginForm"]["password"].value;
    if (username == "" || password == "") {
        alert("Both fields must be filled out");
        return false;
    }
    return true;
}
</script>
</head>
<body>
<c:url value="/login" var="login"/>
<div class="header">
    Gym Management System
</div>

<div class="container">
    <h2>Sign-In</h2>
    <form:form name="loginForm" action="${login}" method="post" onsubmit="return validateForm()">
        <label>Enter User Id:</label>
        <input name="username" type="text" required />
        <label>Enter Password:</label>
        <input type="password" name="password" required />
        <div class="checkbox-container">
            <input type="checkbox" name="remember" />
            <label for="remember">Remember Me</label>
        </div>
        <input type="submit" value="Login" />
    </form:form>

    <a href="/register" class="register-link">Register for New User</a>
</div>

<div class="footer">
    &copy; 2024 Gym Management System. All rights reserved.
</div>
</body>
</html>
