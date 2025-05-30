package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import model.*;

public class EditStudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int rollNo = Integer.parseInt(request.getParameter("rollNo"));
            StudentDAO dao = new StudentDAO();
            Student s = dao.getStudent(rollNo);
            request.setAttribute("student", s);
            RequestDispatcher rd = request.getRequestDispatcher("edit_student.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Student s = new Student();
            s.setRollNo(Integer.parseInt(request.getParameter("rollNo")));
            s.setName(request.getParameter("name"));
            s.setEmail(request.getParameter("email"));
            s.setCourse(request.getParameter("course"));
            s.setGrade(request.getParameter("grade"));

            StudentDAO dao = new StudentDAO();
            dao.updateStudent(s);
            response.sendRedirect("view");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}