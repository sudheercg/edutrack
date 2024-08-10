package com.edutrack;

import java.util.List;
import java.util.Scanner;

import com.edutrack.student.model.Student;
import com.edutrack.student.service.StudentService;

public class EduTrackSystem {

	 private static Scanner scanner = new Scanner(System.in);
	
	 private static StudentService studentService = new StudentService();
	 
	 private static void addStudent() {
	        System.out.println("Enter Roll No:");
	        int rollNo = scanner.nextInt();
	        System.out.println("Enter Name:");
	        String name = scanner.next();
	        System.out.println("Enter Age:");
	        int age = scanner.nextInt();
	        System.out.println("Enter Gender (M/F):");
	        char gender = scanner.next().charAt(0);

	        Student student = new Student();
	        student.setRollNo(rollNo);
	        student.setName(name);
	        student.setAge(age);
	        student.setGender(gender);

	        studentService.addStudent(student);
	        System.out.println("Student added successfully!");
	    }
	 
	 
	 private static void updateStudent() {
	        System.out.println("Enter Roll No:");
	        int rollNo = scanner.nextInt();
	        System.out.println("Enter New Name:");
	        String name = scanner.next();
	        System.out.println("Enter New Age:");
	        int age = scanner.nextInt();
	        System.out.println("Enter New Gender (M/F):");
	        char gender = scanner.next().charAt(0);

	        Student student = new Student();
	        student.setRollNo(rollNo);
	        student.setName(name);
	        student.setAge(age);
	        student.setGender(gender);

	        studentService.updateStudent(student);
	        System.out.println("Student updated successfully!");
	    }

	    private static void deleteStudent() {
	        System.out.println("Enter Student ID:");
	        int studentId = scanner.nextInt();
	        studentService.deleteStudent(studentId);
	        System.out.println("Student deleted successfully!");
	    }

	    private static void viewStudent() {
	        System.out.println("Enter Roll No.:");
	        int rollNo = scanner.nextInt();
	        Student student = studentService.getStudentByRollNo(rollNo);
	        if (student != null) {
	            System.out.println("Student ID: " + student.getStudentId());
	            System.out.println("Roll No: " + student.getRollNo());
	            System.out.println("Name: " + student.getName());
	            System.out.println("Age: " + student.getAge());
	            System.out.println("Gender: " + student.getGender());
	        } else {
	            System.out.println("Student not found.");
	        }
	    }

	    private static void viewAllStudents() {
	        List<Student> students = studentService.getAllStudents();
	        for (Student student : students) {
	            System.out.println("Student ID: " + student.getStudentId());
	            System.out.println("Roll No: " + student.getRollNo());
	            System.out.println("Name: " + student.getName());
	            System.out.println("Age: " + student.getAge());
	            System.out.println("Gender: " + student.getGender());
	            System.out.println("------");
	        }
	    }
	
	


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("EduTrack - Student Management System");
			System.out.println("1. Add Student");
			System.out.println("2. Update Student");
			System.out.println("3. Delete Student");
			System.out.println("4. View Student");
			System.out.println("5. Manage Courses");
			System.out.println("6. Manage Instructors");
			System.out.println("7. Manage Batches");
			System.out.println("8. Manage Timeslots");
			System.out.println("9. Assign Instructor to Course");
			System.out.println("10. Enroll Student in Batch");
			System.out.println("11. View Students by Batch or Course");
			System.out.println("12. Exit");
			System.out.print("Choose an option: ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				// Add Student
				addStudent();
				break;
			case 2:
				// Update Student
				updateStudent();
				break;
			case 3:
				// Delete Student
				deleteStudent();
				break;
			case 4:
				// View Student
				viewStudent();
				break;
			case 5:
				// Manage Courses
				viewAllStudents();
				break;
			case 6:
				// Manage Instructors
				break;
			case 7:
				// Manage Batches
				break;
			case 8:
				// Manage Timeslots
				break;
			case 9:
				// Assign Instructor to Course
				break;
			case 10:
				// Enroll Student in Batch
				break;
			case 11:
				// View Students by Batch or Course
				break;
			case 12:
				System.out.println("Exiting...");
				System.exit(0);
			default:
				System.out.println("Invalid option. Please try again.");
			}
		}
	}
}
