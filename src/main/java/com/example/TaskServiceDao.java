package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TaskServiceDao {
	
	@Qualifier("jdbcTaskService")
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int getCount() {
		return jdbcTemplate.queryForObject("select count(*) from task", Integer.class);
	}

}
