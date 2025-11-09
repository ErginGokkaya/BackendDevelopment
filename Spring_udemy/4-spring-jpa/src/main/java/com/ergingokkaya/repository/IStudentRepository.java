package com.ergingokkaya.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ergingokkaya.entity.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {

}
