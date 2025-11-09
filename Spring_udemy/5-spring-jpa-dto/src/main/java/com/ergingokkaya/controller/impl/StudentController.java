package com.ergingokkaya.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ergingokkaya.controller.IStudentControler;
import com.ergingokkaya.dto.StudentDto;
import com.ergingokkaya.dto.StudentDtoIU;
import com.ergingokkaya.service.IStudentService;

@RestController
@RequestMapping(path = "/rest/api/student")
public class StudentController implements IStudentControler {

	@Autowired
	private IStudentService studentService;
	
	@PostMapping(path = "/save")
	@Override
	public StudentDto saveStudent(@RequestBody StudentDtoIU studentIU)
	{
		return studentService.saveStudent(studentIU);
	}

	@GetMapping(path = "/get-all")
	@Override
	public List<StudentDto> getAllStudents() {
		return studentService.getAllStudents();
	}

	@GetMapping(path = "/get/{id}")
	@Override
	public StudentDto getStudentById(@PathVariable(name = "id") Integer id) {
		return studentService.getStudentById(id);
	}

	@DeleteMapping(path = "/delete/{id}")
	@Override
	public void deleteById(@PathVariable(name = "id") Integer id) {
		studentService.deleteById(id);
		
	}

	@PutMapping(path = "/update/{id}")
	@Override
	public StudentDto updateStudentById(@PathVariable(name = "id") Integer id, @RequestBody StudentDtoIU updatedStudent) {
		
		return studentService.updateById(id, updatedStudent);
	}
	
}
