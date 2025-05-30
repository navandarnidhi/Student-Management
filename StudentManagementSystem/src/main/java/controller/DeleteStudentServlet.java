package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import model.*;

public class DeleteStudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int rollNo = Integer.parseInt(request.getParameter("rollNo"));
            StudentDAO dao = new StudentDAO();
            dao.deleteStudent(rollNo);
            response.sendRedirect("view");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}