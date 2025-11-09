package com.ergingokkaya.service.impl;

import java.beans.Beans;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ergingokkaya.dto.StudentDto;
import com.ergingokkaya.dto.StudentDtoIU;
import com.ergingokkaya.entity.Student;
import com.ergingokkaya.repository.IStudentRepository;
import com.ergingokkaya.service.IStudentService;

@Service
public class StudentService implements IStudentService{

	@Autowired
	private IStudentRepository studentRepository;
	
	@Override
	public StudentDto saveStudent(StudentDtoIU studentIU) {
		Student student = new Student();
		BeanUtils.copyProperties(studentIU, student);
		StudentDto studentDto = new StudentDto();
		BeanUtils.copyProperties(studentRepository.save(student), studentDto);
		return studentDto;
	}

	@Override
	public List<StudentDto> getAllStudents() {
		List<StudentDto> studentListDto = new ArrayList<>();
		List<Student> studentList = studentRepository.findAll();
		
		for (Student student : studentList) {
			StudentDto temp = new StudentDto();
			BeanUtils.copyProperties(student, temp);
			studentListDto.add(temp);
		}
		
		return studentListDto;
	}

	@Override
	public StudentDto getStudentById(Integer id) {
		Optional<Student> student = studentRepository.findById(id);
		StudentDto studentDto = new StudentDto();
		if(student.isPresent())
			BeanUtils.copyProperties(student.get(), studentDto);
		return studentDto;
	}

	@Override
	public void deleteById(Integer id) {
		Optional<Student> student = studentRepository.findById(id);
		if(student.isPresent())
			studentRepository.delete(student.get());
	}

	@Override
	public StudentDto updateById(Integer id,StudentDtoIU updatedStudent) {
		Optional<Student> student = studentRepository.findById(id);
		if(student.isPresent())
		{
			student.get().setFirstName(updatedStudent.getFirstName());
			student.get().setLastName(updatedStudent.getLastName());
			student.get().setBirthDate(updatedStudent.getBirthDate());

			StudentDto studentDto = new StudentDto();
			BeanUtils.copyProperties(studentRepository.save(student.get()), studentDto);

			return studentDto;
		}
		
		return null;
	}

}
