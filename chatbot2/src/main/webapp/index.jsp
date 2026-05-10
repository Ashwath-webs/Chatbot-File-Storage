<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chatbot File System - Home</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="chat-container">
        <h2>Welcome to Chatbot File System</h2>
        <p style="text-align:center; margin-bottom: 20px; color: #e0d4f7; text-shadow: 0 0 5px #9b59b6;">
            Upload files or go to chatbot to manage your files.
        </p>

        <!-- Upload section -->
        <div class="upload-section">
            <form action="UploadServlet" method="post" enctype="multipart/form-data">
                <input type="file" name="file" required>
                <input type="submit" value="Upload">
            </form>
        </div>

        <!-- Navigation button -->
        <div style="text-align:center;">
            <a href="chatbot.jsp">
                <button class="nav-btn">Go to Chatbot</button>
            </a>
        </div>
    </div>
</body>
</html>