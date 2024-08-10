package com.edutrack.student.service;

import java.util.List;

import com.edutrack.student.dao.StudentDAO;
import com.edutrack.student.model.Student;

public class StudentService {

    private StudentDAO studentDAO = new StudentDAO();

    public void addStudent(Student student) {
       
        studentDAO.addStudent(student);
    }

    public void updateStudent(Student student) {
       
        studentDAO.updateStudent(student);
    }

    public void deleteStudent(int studentId) {
       
        studentDAO.deleteStudent(studentId);
    }

    public Student getStudent(int studentId) {
       
        return studentDAO.getStudent(studentId);
    }

    public Student getStudentByRollNo(int rollNo) {
        
        return studentDAO.getStudentByRollNo(rollNo);
    }
    
    
    public List<Student> getAllStudents() {
       
        return studentDAO.getAllStudents();
    }
}
