package com.ergingokkaya.service;

import java.util.List;

import com.ergingokkaya.dto.StudentDto;
import com.ergingokkaya.dto.StudentDtoIU;

public interface IStudentService {
	public StudentDto saveStudent(StudentDtoIU studentIU);
	public List<StudentDto> getAllStudents();
	public StudentDto getStudentById(Integer id);
	public void deleteById(Integer id);
	public StudentDto updateById(Integer id, StudentDtoIU updatedStudent);

}
