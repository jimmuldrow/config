package com.test.tests;

import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.test.models.Post;

public class PutPosts extends TemplateSetup {
	private static final Logger logger = LoggerFactory.getLogger(PutPosts.class);
	
	public static void main(String[] args) {
		new PutPosts();
	}
	
	PutPosts(){
		Post post = getPost("4");		
		
		if(post != null) {
			post.setTitle("Updated Title 4");
			post.setDescription("Updated Description 4");
			updatePost(post);
		}
		else {
			logger.error("**** post is null");
		}
	}
	
	Post getPost(String id) {
		RestTemplate restTemplate = getRestTemplate();
		String uri = "http://localhost:8080/postById/" + id;
		return restTemplate.getForObject(uri, Post.class);
	}	
	
	void updatePost(Post post) {
        try{
            RestTemplate rt = getRestTemplate();
            String uri = "http://localhost:8080/posts";
            rt.put(uri, post);
        }
        catch(Exception e){
        	logger.error("Put posts error:  " + e.getMessage());
        }
	}	
}
