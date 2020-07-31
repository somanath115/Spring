package com.capg.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.student.model.Student;
import com.capg.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> students=service.getAllStudents();
		return new ResponseEntity<List<Student>>(students,HttpStatus.FOUND);
	}
	
	@GetMapping("/id/{id}")	
	public ResponseEntity<Student> getStudent(@PathVariable int id){
		Student student = service.getStudent(id);
		return new ResponseEntity<Student>(student,HttpStatus.FOUND);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		service.addStudent(student);
		return new ResponseEntity<Student>(student,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student){
		Student s = service.updateStudent(student);
		return new ResponseEntity<Student>(student,HttpStatus.ACCEPTED);	
	}
		
	@DeleteMapping("/delete/id/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable int id) {
		Student deleted = service.getStudent(id);
		if(deleted.getId()==id) {
			String message = service.deleteStudent(id);
			return new ResponseEntity<String>(message,HttpStatus.OK);
		}
		return new ResponseEntity<String>("Unable to delete!!",HttpStatus.BAD_REQUEST);
		
	}
}
