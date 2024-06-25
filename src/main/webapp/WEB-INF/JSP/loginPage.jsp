<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log-In Page</title>
<style type="text/css">
body {
    margin: 0;
    padding: 0;
    font-family: Arial, sans-serif;
    /*background-image: url("/images/gym3.jpg");
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;*/
    text-align: center;
    overflow: hidden;
    height: 100%;
    margin: 0;
    padding: 0;
    background-color: rgba(0, 0, 0, 0.8);
}

.header {
    background-color: rgba(0, 0, 0, 0.8);
    padding: 15px;
    font-size: 3rem;
    color: #f1c40f;
    font-weight: 800;
}

.container {
    background: rgba(0, 0, 0, 0.7);
    padding: 2rem;
    border-radius: 10px;
    width: 80%;
    max-width: 400px;
    margin: 7% auto;
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
    width: 200px;
}

input[type="submit"]:hover {
    background-color: #d4ac0d;
}

.register-link {
    display: block;
    margin-top: 2rem;
    font-size: 1.2rem;
    color: #f1c40f;
    text-decoration: none;
}

.register-link:hover {
    text-decoration: underline;
}
</style>

</head>
<body>
<c:url value="/login" var="login"/>
<div class="header">
    Gym Management System
</div>

<div class="container">
    <h2>Sign-In</h2>
    <form:form action="/login" method="post">
        <h3>
            <label>Enter User Id:</label> <br/>
            <input name="username" type="text" required />
            <label>Enter Password:</label><br/>
            <input type="password" name="password" required />
            <input type="submit" value="Login" />
        </h3>
    </form:form>

    <a href="/register" class="register-link">Register for New User</a>
</div>
</body>
</html>