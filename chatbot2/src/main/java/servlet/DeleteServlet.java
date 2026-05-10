package servlet;

import java.io.IOException;

import dao.FileDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fileName = request.getParameter("file");

        FileDAO dao = new FileDAO();

        boolean status = dao.deleteFile(fileName);

        if (status) {
            response.sendRedirect("chatbot.jsp?msg=File Deleted Successfully");
        } else {
            response.sendRedirect("chatbot.jsp?msg=File Not Found");
        }
    }
}