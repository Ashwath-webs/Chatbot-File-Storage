// Simple AJAX chatbot logic

function sendMessage() {

    var message = document.getElementById("message").value;

    if(message.trim() === "") {
        alert("Please enter a command");
        return;
    }

    // Append user message to chat box
    var chatBox = document.getElementById("chat-box");
    var userMsg = document.createElement("div");
    userMsg.className = "user-msg";
    userMsg.innerHTML = "You: " + message;
    chatBox.appendChild(userMsg);

    // Clear input box
    document.getElementById("message").value = "";

    // AJAX request to ChatbotServlet
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "ChatbotServlet", true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    xhr.onreadystatechange = function() {
        if(xhr.readyState == 4 && xhr.status == 200) {
            var botMsg = document.createElement("div");
            botMsg.className = "bot-msg";
            botMsg.innerHTML = "Bot: " + xhr.responseText;
            chatBox.appendChild(botMsg);

            // Scroll chat box to bottom
            chatBox.scrollTop = chatBox.scrollHeight;
        }
    }

    xhr.send("message=" + encodeURIComponent(message));
}

// Send message on Enter key press
document.getElementById("message").addEventListener("keypress", function(e) {
    if(e.key === "Enter") {
        sendMessage();
    }
});