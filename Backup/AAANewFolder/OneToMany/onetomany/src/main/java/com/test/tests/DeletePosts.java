package com.test.tests;

import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.test.models.Post;

public class DeletePosts extends TemplateSetup {
	private static final Logger logger = LoggerFactory.getLogger(DeletePosts.class);
	
	public static void main(String[] args) {
		new DeletePosts();
	}
	
	DeletePosts(){
		delete("1");
	}
	
	void delete(String id) {
        try{
            RestTemplate rt = getRestTemplate();
            String uri = "http://localhost:8080/posts/" + id;
            rt.delete(uri);
        }
        catch(Exception e){
            System.out.println("delete post error:  " + e.getMessage());
        }		
	}
}
