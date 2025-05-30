<%@ page import="java.util.*, model.Student" %>
<html>
<head><title>All Students</title></head>
<body>
    <h2>All Students</h2>
    <%
        List<Student> list = (List<Student>) request.getAttribute("studentList");
        if (list == null || list.isEmpty()) {
    %>
        <p>No student records found.</p>
    <%
        } else {
    %>
    <table border="1">
        <tr>
            <th>Roll No</th><th>Name</th><th>Email</th><th>Course</th><th>Grade</th><th>Actions</th>
        </tr>
        <%
            for (Student s : list) {
        %>
        <tr>
            <td><%= s.getRollNo() %></td>
            <td><%= s.getName() %></td>
            <td><%= s.getEmail() %></td>
            <td><%= s.getCourse() %></td>
            <td><%= s.getGrade() %></td>
            <td>
                <a href="edit?rollNo=<%= s.getRollNo() %>">Edit</a> |
                <a href="delete?rollNo=<%= s.getRollNo() %>">Delete</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
    <%
        }
    %>
    <br/>
    <a href="add_student.jsp">Add New Student</a>
</body>
</html>