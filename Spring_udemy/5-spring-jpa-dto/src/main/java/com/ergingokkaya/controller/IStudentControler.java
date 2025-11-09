package com.ergingokkaya.controller;

import java.util.List;

import com.ergingokkaya.dto.StudentDto;
import com.ergingokkaya.dto.StudentDtoIU;

public interface IStudentControler {
	public StudentDto saveStudent(StudentDtoIU studentIU);
	public List<StudentDto> getAllStudents();
	public StudentDto getStudentById(Integer id);
	public void deleteById(Integer id);
	public StudentDto updateStudentById(Integer id, StudentDtoIU updatedStudent);
}
