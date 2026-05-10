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
        <p>Upload files or go to chatbot to manage files.</p>

        <div class="upload-section">
            <form action="UploadServlet" method="post" enctype="multipart/form-data">
                <input type="file" name="file" required>
                <input type="submit" value="Upload">
            </form>
        </div>

        <div>
            <a href="chatbot.jsp">
                <button style="padding:10px 15px; cursor:pointer;">Go to Chatbot</button>
            </a>
        </div>
    </div>
</body>
</html>