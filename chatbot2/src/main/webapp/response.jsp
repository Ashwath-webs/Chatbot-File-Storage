<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Action Response</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="chat-container response-container">
        <h2>Response</h2>

        <div class="response-message">
            <% 
                String msg = request.getParameter("msg");
                if(msg != null) {
            %>
                <p><%= msg %></p>
            <% } else { %>
                <p>No response message.</p>
            <% } %>
        </div>

        <div style="text-align:center; margin-top: 20px;">
            <a href="chatbot.jsp">
                <button class="nav-btn">Back to Chatbot</button>
            </a>
            <a href="index.jsp">
                <button class="nav-btn">Back to Home</button>
            </a>
        </div>
    </div>
</body>
</html>