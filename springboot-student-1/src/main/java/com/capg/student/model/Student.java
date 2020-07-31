package com.capg.student.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Student {
	@Id
	private int id;
	private String Name;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date dob;
	public Student() {
	}
	public Student(int id, String name, Date dob) {
		super();
		this.id = id;
		Name = name;
		this.dob = dob;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
}
