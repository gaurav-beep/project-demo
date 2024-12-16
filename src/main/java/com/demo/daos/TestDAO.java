package com.demo.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TestDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void databaseConnection() {
		String sql = "select count(*) from user.student";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println("database connection : " + count);
	}
}
