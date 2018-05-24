package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DSRestController {
	
	@Autowired
	ProfileServiceDao profileDao;
	
	@Autowired
	TaskServiceDao taskDao;

	@RequestMapping("/usercount")
	public String userCountFromProfileService() {
		return "Count from users table is : " + profileDao.getCount();
	}
	
	@RequestMapping("/taskcount")
	public String userCountFromTaskService() {
		return "Count from task table is : " + taskDao.getCount();
	}
}
