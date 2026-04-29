import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/files")
public class GetFilesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Connection conn = DBConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement(
                "SELECT filename FROM files"
            );

            ResultSet rs = ps.executeQuery();

            StringBuilder result = new StringBuilder();

            while (rs.next()) {
                result.append("📄 ").append(rs.getString("filename")).append("<br>");
            }

            if (result.length() == 0) {
                response.getWriter().write("No files found.");
            } else {
                response.getWriter().write(result.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Error fetching files");
        }
    }
}