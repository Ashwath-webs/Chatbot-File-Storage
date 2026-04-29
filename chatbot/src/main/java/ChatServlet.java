import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/chat")
public class ChatServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String msg = request.getParameter("message").toLowerCase();
        String reply = "";

        if (msg.contains("hi") || msg.contains("hello")) {
            reply = "Hello 👋 How can I help you today?";
        }

        else if (msg.contains("upload") || msg.contains("store") || msg.contains("save file")) {
            reply = "ACTION:UPLOAD";
        }

        else if (msg.contains("show") || msg.contains("my files") || msg.contains("retrieve")) {
            reply = "ACTION:SHOW_FILES";
        }

        else {
            reply = "🤖 I understand: \"" + msg + "\". Try saying 'upload file' or 'show my files'.";
        }

        response.setContentType("text/plain");
        response.getWriter().write(reply);
    }
}