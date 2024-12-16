package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.UserModel;
@Repository
public interface UserRepository extends JpaRepository<UserModel, String> {
	UserModel findByUserName(String userName);
}
