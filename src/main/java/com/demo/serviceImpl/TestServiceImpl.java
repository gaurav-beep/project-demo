package com.demo.serviceImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Student;
import com.demo.repository.TestRepository;
import com.demo.service.TestService;
@Service
public class TestServiceImpl extends TestService {
	
	@Autowired
	TestRepository testRepository;
	
	@PersistenceContext
    private EntityManager entityManager;

	public List<Student> getAllStudent() {
		return testRepository.findAll();
	}

	public void saveStudent(Student student) {
		testRepository.save(student);
	}

	public List<Student> getStudentByFieldName(String fieldName, String fieldValue) {
        String query = "SELECT s FROM Student s WHERE s." + fieldName + " = :fieldValue";
        return entityManager.createQuery(query, Student.class)
                            .setParameter("fieldValue", fieldValue)
                            .getResultList();
    }

	@Override
	public List<Student> getStudentByEmailId(String emailId) {
		return testRepository.findByEmailId(emailId);
	}

}
