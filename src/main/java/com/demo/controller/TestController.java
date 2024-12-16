package com.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Student;
import com.demo.serviceImpl.TestServiceImpl;

@RestController
public class TestController {

	@Autowired
	TestServiceImpl testServiceImpl;

	@PostMapping("/saveStudent")
	public void saveStudent(@RequestBody Student student) {
		testServiceImpl.saveStudent(student);
	}
	
	@GetMapping("/getAllStudent")
	public List<Student> getAllStudent(){
		return testServiceImpl.getAllStudent();
	}
	
	@PostMapping("/getStudentByEmailId")
	public List<Student> getByFieldName(@RequestBody Student student){
		return testServiceImpl.getStudentByEmailId(student.getEmailId());
	}
	
	@PostMapping("/getStudentByFieldName")
	public List<Student> getByFieldName(@RequestBody Map<String,String> requestBody){
		return testServiceImpl.getStudentByFieldName(requestBody.get("fieldName"),requestBody.get("fieldValue"));
	}
}


