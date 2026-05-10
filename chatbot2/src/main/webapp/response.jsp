<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Action Response</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="chat-container">
        <h2>Response</h2>

        <% 
            String msg = request.getParameter("msg");
            if(msg != null) {
        %>
            <p><%= msg %></p>
        <% } else { %>
            <p>No response message.</p>
        <% } %>

        <div>
            <a href="chatbot.jsp">
                <button style="padding:10px 15px; cursor:pointer;">Back to Chatbot</button>
            </a>
        </div>
        <div>
            <a href="index.jsp">
                <button style="padding:10px 15px; cursor:pointer;">Back to Home</button>
            </a>
        </div>
    </div>
</body>
</html>