package servlet;

import java.io.IOException;
import java.util.StringTokenizer;

import dao.FileDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/ChatbotServlet")
public class ChatbotServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String message = request.getParameter("message");

        response.setContentType("text/html");

        FileDAO dao = new FileDAO();

        // SHOW FILES
        if (message.equalsIgnoreCase("show files")) {

            dao.getAllFiles().forEach(file -> {
                try {
                    response.getWriter().println(file.getFileName() + "<br>");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        // GET FILES (single or multiple)
        else if (message.startsWith("get")) {

            StringTokenizer st = new StringTokenizer(message);
            st.nextToken(); // skip "get"

            while (st.hasMoreTokens()) {

                String fileName = st.nextToken();

                boolean exists = dao.fileExists(fileName);

                if (exists) {
                    response.getWriter().println(
                        "<a href='DownloadServlet?file=" + fileName + "'>Download " 
                        + fileName + "</a><br><br>"
                    );
                } else {
                    response.getWriter().println(fileName + " not found<br>");
                }
            }
        }

        // DELETE FILE
        else if (message.startsWith("delete")) {

            String fileName = message.substring(7).trim();

            boolean status = dao.deleteFile(fileName);

            if (status) {
                response.getWriter().println("File Deleted Successfully");
            } else {
                response.getWriter().println("File Not Found");
            }
        }

        else {
            response.getWriter().println("Invalid Command");
        }
    }
}