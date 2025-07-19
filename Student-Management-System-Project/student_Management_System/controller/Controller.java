package com.Megha.student_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Megha.student_Management_System.entity.Student;
import com.Megha.student_Management_System.service.StudentService;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	private StudentService Service;
	
	@GetMapping("/home")
	public String home() {
		
		return "home";// view page html file -> home.html
	}
	
	@GetMapping("/students")
	public String getAllStudent(Model model) {
		
		model.addAttribute("students", Service.getAllStudents());
		return "students";
		
	}
	@GetMapping("students/new")
	public String createStudentForm(Model model) {
		
		Student student = new Student(); // to hold student object
		model.addAttribute("students", student);
		
		return "create-student";
	}
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		
		Service.saveStudent(student);
		return "redirect:/students"; //to direct to the list of student
	}
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable int id, Model model) {
		model.addAttribute("student", Service.getById(id));
		return "edit_student";
		
	}
	
	@PostMapping("/students/edit/{id}")
	public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student) {
		
		Student existingStudent=Service.getById(id);
		
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		Service.saveStudent(existingStudent);
		
		return "redirect:/students";
	}
	@GetMapping("/students/{id}")
	public String deleteById(@PathVariable int id) {
		
		Service.deleteById(id);
		
		return "redirect:/students";
	}
}
	
	


