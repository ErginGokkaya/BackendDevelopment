package com.ergingokkaya.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ergingokkaya.entity.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {
	
	//@Query(value = "select * from student.student", nativeQuery = true)
	@Query(value = "from Student", nativeQuery = false)
	List<Student> findAllStudents();
	
	@Query(value = "from Student s where s.id=: studentId", nativeQuery = false)
	Student findStudentById(Integer studentId);

}
