<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login - Chatbot File System</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="chat-container login-container">
        <h2>Login</h2>
        <p style="text-align:center; margin-bottom: 20px; color: #e0d4f7; text-shadow: 0 0 5px #9b59b6;">
            Enter your credentials to access the system
        </p>
        <form action="LoginServlet" method="post" class="login-form">
            <input type="text" name="username" placeholder="Username" required>
            <input type="password" name="password" placeholder="Password" required>
            <button type="submit" class="login-btn">Login</button>
        </form>
        <div style="text-align:center; margin-top:15px;">
            <a href="index.jsp">
                <button class="nav-btn">Back to Home</button>
            </a>
        </div>
    </div>
</body>
</html>