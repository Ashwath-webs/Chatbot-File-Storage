import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.*;
import java.sql.*;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Connection conn = DBConnection.getConnection();

            PreparedStatement stmt = conn.prepareStatement(
                "SELECT * FROM files WHERE id=?"
            );
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                response.setContentType(rs.getString("filetype"));
                response.setHeader("Content-Disposition",
                        "attachment; filename=" + rs.getString("filename"));

                InputStream is = rs.getBinaryStream("filedata");
                OutputStream os = response.getOutputStream();

                byte[] buffer = new byte[4096];
                int bytesRead;

                while ((bytesRead = is.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}