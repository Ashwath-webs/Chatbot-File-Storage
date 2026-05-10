<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register - Chatbot File System</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="chat-container register-container">
        <h2>Register</h2>
        <p style="text-align:center; margin-bottom: 20px; color: #e0d4f7; text-shadow: 0 0 5px #9b59b6;">
            Create a new account to access the system
        </p>
        <form action="RegisterServlet" method="post" class="register-form">
            <input type="text" name="username" placeholder="Username" required>
            <input type="password" name="password" placeholder="Password" required>
            <button type="submit" class="register-btn">Register</button>
        </form>
        <div style="text-align:center; margin-top:15px;">
            <a href="index.jsp">
                <button class="nav-btn">Back to Home</button>
            </a>
        </div>
    </div>
</body>
</html>