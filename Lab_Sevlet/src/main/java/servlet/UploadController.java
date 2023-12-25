package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)

@WebServlet(name = "UploadController", value = "/upload")
public class UploadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("up");
        String fileName = filePart.getSubmittedFileName();
        String root = getServletContext().getRealPath("/data/");
        File check = new File(root);
        if(!check.exists()) {
            check.mkdirs();
        }
        if(filePart != null) {
            filePart.write(root + fileName);
        }
        response.getWriter().print("The file uploaded successfully");
    }
}