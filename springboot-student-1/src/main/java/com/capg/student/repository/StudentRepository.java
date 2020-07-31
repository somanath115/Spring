package com.capg.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.student.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
}
