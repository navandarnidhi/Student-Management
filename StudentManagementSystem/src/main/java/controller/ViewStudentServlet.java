package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
import model.*;

public class ViewStudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            StudentDAO dao = new StudentDAO();
            List<Student> list = dao.getAllStudents();
            request.setAttribute("studentList", list); 
            RequestDispatcher rd = request.getRequestDispatcher("view_students.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}