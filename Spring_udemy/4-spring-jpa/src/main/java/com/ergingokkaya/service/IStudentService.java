package com.ergingokkaya.service;

import java.util.List;
import com.ergingokkaya.entity.Student;

public interface IStudentService {
	public Student saveStudent(Student student);
	public List<Student> getAllStudents();
	public Student getStudentById(Integer id);
	public void deleteById(Integer id);
	public Student updateById(Student updatedStudent);

}
