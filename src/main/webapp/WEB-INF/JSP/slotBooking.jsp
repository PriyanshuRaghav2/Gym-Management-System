<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Book Your Space</title>
<style type="text/css">
body {
    margin: 0;
    padding: 0;
    font-family: Arial, sans-serif;
    text-align: center;
    background-image: url("/images/gym4.jpg");
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    color: white;
}

.header {
    background-color: rgba(0, 0, 0, 0.8);
    padding: 20px;
    font-size: 40px;
    color: #f1c40f;
    font-weight: 600;
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
input[type="date"],
select {
    width: 100%;
    padding: 0.5rem;
    margin-bottom: 1rem;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 1rem;
}

select {
    background-color: white;
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
    margin: 0.5rem;
}

button:hover {
    background-color: #d4ac0d;
}

.back-link {
    display: block;
    margin-top: 2rem;
    font-size: 1.2rem;
    color: #f1c40f;
    text-decoration: none;
}

.back-link:hover {
    text-decoration: underline;
}

</style>
</head>
<body>
    <div class="header">
        Book Your Space
    </div>
    <div class="container">
        <h2>Reserve Your Spot</h2>
        <form action="/book-space" method="post">
            <label for="name">Full Name:</label>
            <input type="text" id="name" name="name" required>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>

            <label for="date">Select Date:</label>
            <input type="date" id="date" name="date" required>

            <label for="time">Select Time Slot:</label>
            <select id="time" name="time" required>
                <option value="6am-7am">6am - 7am</option>
                <option value="7am-8am">7am - 8am</option>
                <option value="8am-9am">8am - 9am</option>
                <option value="9am-10am">9am - 10am</option>
                <option value="10am-11am">10am - 11am</option>
                <option value="11am-12pm">11am - 12pm</option>
                <option value="12pm-1pm">12pm - 1pm</option>
                <option value="1pm-2pm">1pm - 2pm</option>
                <option value="2pm-3pm">2pm - 3pm</option>
                <option value="3pm-4pm">3pm - 4pm</option>
                <option value="4pm-5pm">4pm - 5pm</option>
                <option value="5pm-6pm">5pm - 6pm</option>
                <option value="6pm-7pm">6pm - 7pm</option>
                <option value="7pm-8pm">7pm - 8pm</option>
            </select>

            <label for="session">Type of Session:</label>
            <select id="session" name="session" required>
                <option value="personal-training">Personal Training</option>
                <option value="group-class">Group Class</option>
                <option value="nutrition-counseling">Nutritional Counseling</option>
                <option value="massage-therapy">Massage Therapy</option>
            </select>

            <button type="submit">Book Now</button>
        </form>
        <a href="/index" class="back-link">Back to Home</a>
    </div>
</body>
</html>
    