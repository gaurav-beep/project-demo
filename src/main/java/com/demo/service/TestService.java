package com.demo.service;

import java.util.List;

import com.demo.entity.Student;

abstract public class TestService {
public abstract List<Student> getAllStudent();
public abstract void saveStudent(Student student);
public abstract List<Student> getStudentByEmailId(String emailId);
public abstract List<Student> getStudentByFieldName(String fieldName,String fieldValue);
}
