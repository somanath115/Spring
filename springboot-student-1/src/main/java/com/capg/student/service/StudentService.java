package com.capg.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.student.model.Student;
import com.capg.student.repository.StudentRepository;

@Service
public class StudentService implements IStudentService{
	@Autowired
	private StudentRepository repo;

	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		return repo.save(student);
	}

	@Override
	public String deleteStudent(int id) {
		// TODO Auto-generated method stub
		Student s = repo.getOne(id);
		repo.delete(s);
		return "Deleted!";
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		Student s = repo.getOne(student.getId());
		s.setId(student.getId());
		s.setName(student.getName());
		s.setDob(student.getDob());
		repo.save(s);
		return s;
	}

	@Override
	public Student getStudent(int id) {
		// TODO Auto-generated method stub
		return repo.getOne(id);
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
}
