package model;

import java.sql.*;
import java.util.*;

public class StudentDAO {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/studentdb";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "1307";

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public void addStudent(Student student) throws Exception {
        String sql = "INSERT INTO students (roll_no, name, email, course, grade) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, student.getRollNo());
            stmt.setString(2, student.getName());
            stmt.setString(3, student.getEmail());
            stmt.setString(4, student.getCourse());
            stmt.setString(5, student.getGrade());
            stmt.executeUpdate();
        }
    }

    public List<Student> getAllStudents() throws Exception {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students ORDER BY name";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Student student = new Student();
                student.setRollNo(rs.getInt("roll_no"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setCourse(rs.getString("course"));
                student.setGrade(rs.getString("grade"));
                list.add(student);
            }
        }
        return list;
    }

    public Student getStudent(int rollNo) throws Exception {
        Student student = new Student();
        String sql = "SELECT * FROM students WHERE roll_no = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, rollNo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                student.setRollNo(rs.getInt("roll_no"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setCourse(rs.getString("course"));
                student.setGrade(rs.getString("grade"));
            }
        }
        return student;
    }

    public void updateStudent(Student student) throws Exception {
        String sql = "UPDATE students SET name=?, email=?, course=?, grade=? WHERE roll_no=?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());
            stmt.setString(3, student.getCourse());
            stmt.setString(4, student.getGrade());
            stmt.setInt(5, student.getRollNo());
            stmt.executeUpdate();
        }
    }

    public void deleteStudent(int rollNo) throws Exception {
        String sql = "DELETE FROM students WHERE roll_no=?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, rollNo);
            stmt.executeUpdate();
        }
    }
}