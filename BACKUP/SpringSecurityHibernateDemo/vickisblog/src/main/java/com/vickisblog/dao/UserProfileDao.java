package com.vickisblog.dao;

import java.util.List;

import com.vickisblog.model.UserProfile;


public interface UserProfileDao {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}
