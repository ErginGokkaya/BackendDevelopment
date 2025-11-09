package com.ergingokkaya.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ergingokkaya.entity.Student;
import com.ergingokkaya.repository.IStudentRepository;
import com.ergingokkaya.service.IStudentService;

@Service
public class StudentService implements IStudentService{

	@Autowired
	private IStudentRepository studentRepository;
	
	@Override
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(Integer id) {
		Optional<Student> student = studentRepository.findById(id);
		return student.isPresent() ? student.get() : null;
	}

	@Override
	public void deleteById(Integer id) {
		Student student = getStudentById(id);
		if(student != null)
			studentRepository.delete(student);

	}

	@Override
	public Student updateById(Student updatedStudent) {
		Student student = getStudentById(updatedStudent.getId());
		if(student != null)
		{
			student.setFirstName(updatedStudent.getFirstName());
			student.setLastName(updatedStudent.getLastName());
			student.setBirthDate(updatedStudent.getBirthDate());
			return studentRepository.save(student);
		}
		
		return null;
	}

}
