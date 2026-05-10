<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chatbot File System</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="chat-container">
        <h2>Chatbot File System</h2>

        <!-- Chat messages box -->
        <div id="chat-box" class="chat-box"></div>

        <!-- Input box -->
        <input type="text" id="message" placeholder="Type command (e.g., get file.pdf)">
        <button id="sendBtn" onclick="sendMessage()">Send</button>

        <hr>

        <!-- Upload section -->
        <div class="upload-section">
            <form action="UploadServlet" method="post" enctype="multipart/form-data">
                <input type="file" name="file" required>
                <input type="submit" value="Upload">
            </form>
        </div>

        <!-- Back button -->
        <div>
            <a href="index.jsp">
                <button style="padding:10px 15px; cursor:pointer;">Back to Home</button>
            </a>
        </div>
    </div>

    <script src="js/chatbot.js"></script>
</body>
</html>