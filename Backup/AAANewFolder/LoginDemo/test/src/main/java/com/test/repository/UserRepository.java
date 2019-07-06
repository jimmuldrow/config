package com.test.repository;

import org.springframework.data.repository.CrudRepository;

import com.test.model.User;

import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
	@Query(nativeQuery = true, value="select * from user u where u.login_id = ?1") 
	List<User> findUser(String userId);
}
