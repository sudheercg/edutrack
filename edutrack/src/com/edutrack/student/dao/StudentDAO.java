package com.edutrack.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutrack.student.model.Student;
import com.edutrack.util.DBUtil;

public class StudentDAO {

  

    public void addStudent(Student student) {
        String query = "INSERT INTO Students (rollNo, name, age, gender) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, student.getRollNo());
            pstmt.setString(2, student.getName());
            pstmt.setInt(3, student.getAge());
            pstmt.setString(4, String.valueOf(student.getGender()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(Student student) {
        String query = "UPDATE Students SET name = ?, age = ?, gender = ? WHERE rollNo = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, student.getName());
            pstmt.setInt(2, student.getAge());
            pstmt.setString(3, String.valueOf(student.getGender()));
            pstmt.setInt(4, student.getRollNo());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int studentId) {
        String query = "DELETE FROM Students WHERE studentId = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, studentId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Student getStudent(int studentId) {
        String query = "SELECT * FROM Students WHERE studentId = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, studentId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                student.setStudentId(rs.getInt("studentId"));
                student.setRollNo(rs.getInt("rollNo"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setGender(rs.getString("gender").charAt(0));
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    
    
    public Student getStudentByRollNo(int rollNo) {
        String query = "SELECT * FROM Students WHERE rollNo = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, rollNo);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                student.setStudentId(rs.getInt("studentId"));
                student.setRollNo(rs.getInt("rollNo"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setGender(rs.getString("gender").charAt(0));
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    
    
    
    

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM Students";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Student student = new Student();
                student.setStudentId(rs.getInt("studentId"));
                student.setRollNo(rs.getInt("rollNo"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setGender(rs.getString("gender").charAt(0));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
