<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ask Query</title>
<style type="text/css">

body {
	margin: 0;
	padding: 0;
	font-family: Arial, sans-serif;
	text-align: center;
	background-image: url("/images/gym5.jpg");
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
	color: white;
}

.container {
	background: rgba(0, 0, 0, 0.7);
	padding: 2rem;
	border-radius: 10px;
	width: 80%;
	max-width: 600px;
	margin: 5% auto;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
}

h2 {
	margin-bottom: 1.5rem;
	font-size: 38px;
	color: #f1c40f;
	font-weight: 800;
}

label {
	display: block;
	margin: 1rem 0 0.5rem;
	font-size: 20px;
	color: #f1c40f;
}

input[type="text"],
input[type="email"],
textarea {
	width: 100%;
	padding: 0.5rem;
	margin-bottom: 1rem;
	border: 1px solid #ccc;
	border-radius: 5px;
	font-size: 1rem;
}

textarea {
	resize: none;
}

input[type="submit"],
button {
	background-color: #f1c40f;
	border: none;
	color: black;
	padding: 0.75rem 2.5rem;
	text-decoration: none;
	border-radius: 45px;
	cursor: pointer;
	font-size: 1rem;
	transition: background-color 0.3s ease;
	margin-right: 25px;
	margin-left: 25px;
}

input[type="submit"]:hover {
	background-color: #d4ac0d;
}

button:hover {
	background-color: #d4ac0d;
}

</style>
</head>
<body>
	<div class="container">
		<form action="/feedback" method="post">
			<h2>Write us your Feedback</h2>
			<input type="hidden" name="feedbackId" value="${feedback.feedbackId}"/>
			<label for="fname">User name:</label><br> 
			<input type="text"id="username" name="username"  required><br>
			 
			<label for="feedback">Write Your Feedback:</label><br />
			<textarea name="feedbackContent" rows="10" cols="30"placeholder="Write Us your Feedback"></textarea>
			
			<input type="hidden" name="timestamp" value="${feedback.timestamp}"/>
			
			<input type="submit" value="Submit">
			<a href="/index"><button>Home</button></a>
		</form>
	</div>

</body>
</html>