package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bean.Test;
import com.example.dao.TestDao;

@Service("testService")
public class TestServiceImp implements TestService{

	@Autowired
	private TestDao testDao;
	
	public void setTestDAO(TestDao testDAO) {
		System.out.println("This is test service");
		this.testDao = testDAO;
	}
	
	@Override
	@Transactional
	public void addTest(Test test) {
		testDao.addTest(test);
	}

}
