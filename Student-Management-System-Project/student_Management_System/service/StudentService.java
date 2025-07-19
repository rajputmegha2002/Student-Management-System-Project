package com.Megha.student_Management_System.service;

import java.util.List;

import com.Megha.student_Management_System.entity.Student;

public interface StudentService {
	
	public List<Student> getAllStudents();
	
	public Student saveStudent(Student student);
	
	public Student getById(int id);
	
	public void deleteById(int id);

}
