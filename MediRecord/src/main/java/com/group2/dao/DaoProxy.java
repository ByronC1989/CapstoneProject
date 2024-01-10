package com.group2.dao;

import java.util.List;

import com.group2.beans.Record;
import com.group2.services.ApplicationServices;
import com.group2.user.User;

public class DaoProxy implements ApplicationServices {
	
	// Adding Proxy Design Pattern to limit access to ApplicationDao
	
	// Hold reference to real dao class
	ApplicationDao dao = new ApplicationDao();

	@Override
	public void createUser(User user) {
		dao.createUser(user);
	}

	@Override
	public boolean verifyUsername(String username) {
		return dao.verifyUsername(username);
	}

	@Override
	public boolean verifyEmail(String email) {
		return dao.verifyEmail(email);
	}

	@Override
	public boolean verifyUsernamePassword(String username, String password) {
		return dao.verifyUsernamePassword(username, password);
	}

	@Override
	public void createPost(Record record) {
		dao.createPost(record);
	}

	@Override
	public List<Record> searchRecords(String search) {
		return dao.searchRecords(search);
	}

	@Override
	public boolean verifyRecord(String healthCardID) {
		return dao.verifyRecord(healthCardID);
	}

	@Override
	public User selectUser(String username) {
		return dao.selectUser(username);
	}
	
	
}
