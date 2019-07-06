package com.test.service;

import org.springframework.stereotype.Service;

import com.test.model.User;
import com.test.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class DBService {
	@Autowired
	UserRepository userRepository;
	
	public void add(String userId, String password) {
		User user = new User();
		user.setLoginId(userId);
		user.setPass(password);
		user.setRoletype("user");
		userRepository.save(user);
	}
	
	public List<User> findUser(String userId) {
		return userRepository.findUser(userId);
	}
}
