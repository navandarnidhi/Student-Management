<%@ page import="model.Student" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head><title>Edit Student</title></head>
<body>
    <h2>Edit Student</h2>
    <form action="edit" method="post">
        <%
            Student s = (Student) request.getAttribute("student");
        %>
        Roll No: <input type="number" name="rollNo" value="<%= s.getRollNo() %>" readonly /><br/><br/>
        Name: <input type="text" name="name" value="<%= s.getName() %>" required /><br/><br/>
        Email: <input type="email" name="email" value="<%= s.getEmail() %>" required /><br/><br/>
        Course: <input type="text" name="course" value="<%= s.getCourse() %>" required /><br/><br/>
        Grade: <input type="text" name="grade" value="<%= s.getGrade() %>" required /><br/><br/>
        <input type="submit" value="Update Student" />
    </form>
</body>
</html>