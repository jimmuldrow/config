package com.test;
import java.util.*;
import org.springframework.stereotype.Component;

@Component
public class UserService {
	
	private Map<Long, User> userMap = new HashMap<Long, User>();
	
	public UserService(){
		User user = new User(1, "Bob", 32, 40000);
		userMap.put(user.getId(), user);
		user = new User(2, "Jane", 21, 32000);
		userMap.put(user.getId(), user);		
		user = new User(3, "Chang", 41, 56000);
		userMap.put(user.getId(), user);
		user = new User(4, "Krishna", 55, 80000);
		userMap.put(user.getId(), user);			
	}
	
	public List<User> findAllUsers(){
		Set<Long> set = userMap.keySet();
		List<User> userList = new ArrayList<User>();
		
		for(long l: set){
			userList.add(userMap.get(l));
		}
		
		return userList;
	}
	
	public User findById(long i){
		return userMap.get(i);
	}
	
	public boolean isUserExist(User user){
		if(user == null){return false;}
		User user2 = userMap.get(user.getId());
		return ((user2 == null) ? false : true);
	}
	
	public void saveUser(User user){
		User user2 = userMap.get(user.getId());

		if(user2 == null){
			userMap.put(user.getId(), user);
		}
	}
	
	public void updateUser(User user){
		User user2 = userMap.get(user.getId());

		if(user2 != null){
			userMap.put(user.getId(), user);
		}
	}
	
	public void deleteUserById(long id){
		userMap.remove(id);
	}
	
	public void deleteAllUsers(){
		userMap.clear();
	}
}
