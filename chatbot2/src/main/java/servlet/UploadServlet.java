package servlet;

import java.io.IOException;
import java.io.InputStream;

import dao.FileDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/UploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Part filePart = request.getPart("file");

        String fileName = filePart.getSubmittedFileName();
        String fileType = filePart.getContentType();

        InputStream inputStream = filePart.getInputStream();

        FileDAO dao = new FileDAO();

        boolean status = dao.uploadFile(fileName, fileType, inputStream);

        if (status) {
            response.sendRedirect("chatbot.jsp?msg=File Uploaded Successfully");
        } else {
            response.sendRedirect("chatbot.jsp?msg=Upload Failed");
        }
    }
}