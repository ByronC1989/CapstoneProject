package com.group2.services;

import java.util.List;

import com.group2.beans.Record;
import com.group2.user.User;

public interface ApplicationServices {
	
	// Interface for handling ApplicationServices that can be extended
	
	// User Operations
	public void createUser(User user);
	public boolean verifyUsername(String username);
	public boolean verifyEmail(String email);
	public boolean verifyUsernamePassword(String username, String password);
	public User selectUser(String username);
	public boolean updatePassword(String username, String password);
	public boolean updateEmail(String username, String email);
	
	
	// Record Operations
	public void createPost(Record record);
	public List<Record> searchRecords(String search);
	public boolean verifyRecord(String healthCardID);
	
}
