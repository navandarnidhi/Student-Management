<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Add Student</title></head>
<body>
    <h2>Add Student</h2>
    <form action="add" method="post">
        Roll No: <input type="number" name="rollNo" required /><br/><br/>
        Name: <input type="text" name="name" required /><br/><br/>
        Email: <input type="email" name="email" required /><br/><br/>
        Course: <input type="text" name="course" required /><br/><br/>
        Grade: <input type="text" name="grade" required /><br/><br/>
        <input type="submit" value="Add Student" />
    </form>
    <br/>
    <a href="view">View All Students</a>
</body>
</html>