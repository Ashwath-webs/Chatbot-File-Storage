import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Connection conn = DBConnection.getConnection();

            PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO users(username, password) VALUES(?, ?)"
            );

            stmt.setString(1, username);
            stmt.setString(2, password);

            int result = stmt.executeUpdate();

            if (result > 0) {
               
                response.sendRedirect("login.html");
            } else {
                response.getWriter().println("Registration failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Server Error");
        }
    }
}