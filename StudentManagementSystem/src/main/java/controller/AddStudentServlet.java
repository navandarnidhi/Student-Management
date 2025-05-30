
package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import model.*;

public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Student s = new Student();
            s.setRollNo(Integer.parseInt(request.getParameter("rollNo")));
            s.setName(request.getParameter("name"));
            s.setEmail(request.getParameter("email"));
            s.setCourse(request.getParameter("course"));
            s.setGrade(request.getParameter("grade"));

            StudentDAO dao = new StudentDAO();
            dao.addStudent(s);
            response.sendRedirect("view"); // redirect to ViewStudentServlet
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}