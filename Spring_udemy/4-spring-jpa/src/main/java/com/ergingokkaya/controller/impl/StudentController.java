package com.ergingokkaya.controller.impl;

import java.util.List;
import com.ergingokkaya.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ergingokkaya.controller.IStudentControler;
import com.ergingokkaya.entity.Student;
import com.ergingokkaya.service.IStudentService;

@RestController
@RequestMapping(path = "/rest/api")
public class StudentController implements IStudentControler {

    private final StudentService studentService_1;
	
	@Autowired
	private IStudentService studentService;

    StudentController(StudentService studentService_1) {
        this.studentService_1 = studentService_1;
    }
	
	@PostMapping(path = "/save")
	@Override
	public Student saveStudent(@RequestBody Student student)
	{
		return studentService.saveStudent(student);
	}

	@GetMapping(path = "/get-all")
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentService.getAllStudents();
	}

	@GetMapping(path = "/get/{id}")
	@Override
	public Student getStudentById(@PathVariable(name = "id") Integer id) {
		// TODO Auto-generated method stub
		return studentService.getStudentById(id);
	}

	@DeleteMapping(path = "/delete/{id}")
	@Override
	public void deleteById(@PathVariable(name = "id") Integer id) {
		studentService.deleteById(id);
		
	}

	@PutMapping(path = "/update")
	@Override
	public Student updateStudentById(@RequestBody Student updatedStudent) {
		
		return studentService.updateById(updatedStudent);
	}
	
}
