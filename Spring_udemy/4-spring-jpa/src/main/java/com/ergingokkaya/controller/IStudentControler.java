package com.ergingokkaya.controller;

import java.util.List;

import com.ergingokkaya.entity.Student;

public interface IStudentControler {
	public Student saveStudent(Student student);
	public List<Student> getAllStudents();
	public Student getStudentById(Integer id);
	public void deleteById(Integer id);
	public Student updateStudentById(Student updatedStudent);
}
