package com.capg.student.service;

import java.util.List;

import com.capg.student.model.Student;

public interface IStudentService {
	Student addStudent(Student student);
	String deleteStudent(int id);
	Student updateStudent(Student student);
	Student getStudent(int id);
	List<Student> getAllStudents();
	
}
