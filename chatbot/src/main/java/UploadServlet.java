import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

@WebServlet("/upload")

@MultipartConfig(
    fileSizeThreshold = 1024 * 1024,   // 1MB
    maxFileSize = 10 * 1024 * 1024,    // 10MB
    maxRequestSize = 15 * 1024 * 1024
)

public class UploadServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Part filePart = request.getPart("file");

            String fileName = filePart.getSubmittedFileName();
            InputStream fileContent = filePart.getInputStream();

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO files (filename, data) VALUES (?, ?)"
            );

            ps.setString(1, fileName);
            ps.setBlob(2, fileContent);

            int result = ps.executeUpdate();

            if (result > 0) {
                response.getWriter().write("File uploaded successfully!");
            } else {
                response.getWriter().write("Upload failed!");
            }

        } catch (Exception e) {
            e.printStackTrace();   // 🔥 VERY IMPORTANT (see error in console)
            response.getWriter().write("Error uploading file");
        }
    }
}