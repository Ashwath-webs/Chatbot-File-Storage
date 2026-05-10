package servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.ResultSet;

import dao.FileDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fileName = request.getParameter("file");

        try {

            FileDAO dao = new FileDAO();

            ResultSet rs = dao.getFileByName(fileName);

            if (rs.next()) {

                Blob blob = rs.getBlob("file_data");

                byte[] fileBytes = blob.getBytes(1, (int) blob.length());

                response.setContentType(rs.getString("file_type"));

                response.setHeader("Content-Disposition",
                        "attachment; filename=" + rs.getString("file_name"));

                OutputStream os = response.getOutputStream();
                os.write(fileBytes);
                os.flush();
                os.close();

            } else {
                response.getWriter().println("File Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}