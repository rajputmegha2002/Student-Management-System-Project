package com.Megha.student_Management_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Megha.student_Management_System.entity.Student;
@Repository
public interface Studentrepository extends JpaRepository<Student, Integer> {

}
