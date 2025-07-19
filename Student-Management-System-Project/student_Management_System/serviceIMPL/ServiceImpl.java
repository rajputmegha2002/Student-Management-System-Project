package com.Megha.student_Management_System.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Megha.student_Management_System.entity.Student;
import com.Megha.student_Management_System.service.StudentService;

@Service
public class ServiceImpl implements StudentService{
    
	@Autowired
	com.Megha.student_Management_System.repository.Studentrepository Studentrepository;
	
	@Override
	public List<Student> getAllStudents() {
		
		 
		List<Student> list=Studentrepository.findAll();
		return list;
	}
	
	public Student saveStudent(Student student) {
		
		return Studentrepository.save(student);
	}

	@Override
	public Student getById(int id) {
		
		return Studentrepository.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		
		Studentrepository.deleteById(id);
	}

}
