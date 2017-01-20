package com.test;

import java.net.URI;
import java.util.*;
import org.springframework.web.client.RestTemplate;
 
 
public class SpringRestTestClient {
 
    public static final String REST_SERVICE_URI = "http://localhost:8080/test";

    // Objects in List stored as LinkedHashMap objects
    /* GET */
    @SuppressWarnings("unchecked")
    private static void listAllUsers(){
        System.out.println("Testing listAllUsers API-----------");
         
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> usersMap = restTemplate.getForObject(REST_SERVICE_URI+"/listAllUsers", List.class);
         
        if(usersMap!=null){
            for(LinkedHashMap<String, Object> map : usersMap){
                System.out.println("User : id="+map.get("id")+", Name="+map.get("name")+", Age="+map.get("age")+", Salary="+map.get("salary"));
            }
        }else{
            System.out.println("No user exist----------");
        }
    }
     
    /* GET */
    private static void getUser(){
        System.out.println("Testing getUser API----------");
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(REST_SERVICE_URI+"/getUser/1", User.class);
        System.out.println("id:  " + user.getId() + "   name: " + user.getName() + "   age: " + user.getAge() + "   salary: " + user.getSalary());
    }     
    
    /* POST */
    private static void createUser() {
        System.out.println("Testing create User API----------");
        RestTemplate restTemplate = new RestTemplate();
        User user = new User(0,"Sarah",51,134);
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/createUser", user, User.class);
        System.out.println("Location : "+uri.toASCIIString());
    }
 
    /* PUT */
    private static void updateUser() {
        System.out.println("Testing update User API----------");
        RestTemplate restTemplate = new RestTemplate();
        User user  = new User(1,"Tomy",33, 70000);
        restTemplate.put(REST_SERVICE_URI+"/updateUser/1", user);
        System.out.println(user);
    }
 
    /* DELETE */
    private static void deleteUser() {
        System.out.println("Testing delete User API ID 3 ----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/deleteUser/3");
    }
 
 
    /* DELETE */
    private static void deleteAllUsers() {
        System.out.println("Testing all delete Users API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/deleteAllUsers");
    }
 
    public static void main(String args[]){
        listAllUsers();
        getUser();
        createUser();
        listAllUsers();
        updateUser();
        listAllUsers();
        deleteUser();
        listAllUsers();
        deleteAllUsers();
        listAllUsers();
    }
}
