package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.entity.Student;

public interface TestRepository extends JpaRepository<Student, Integer> {
	
	List<Student> findByEmailId(@Param("emailId") String emailId);
}
