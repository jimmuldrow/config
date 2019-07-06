package com.test.tests;

import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.test.models.Post;

public class PostPosts extends TemplateSetup {
	private static final Logger logger = LoggerFactory.getLogger(PostPosts.class);
	
	public static void main(String[] args) {
		new PostPosts();
	}
	
	PostPosts(){
		Post post = new Post();
		post.setTitle("Title 1");
		post.setDescription("Description 1");
		post.setContent("Content 1");
		addPosts(post);
		
		post = new Post();
		post.setTitle("Title 2");
		post.setDescription("Description 2");
		post.setContent("Content 2");
		addPosts(post);		
		
		post = new Post();
		post.setTitle("Title 3");
		post.setDescription("Description 3");
		post.setContent("Content 3");
		addPosts(post);			
		
		post = new Post();
		post.setTitle("Title 4");
		post.setDescription("Description 4");
		post.setContent("Content 4");
		addPosts(post);		
		
		post = new Post();
		post.setTitle("Title 5");
		post.setDescription("Description 5");
		post.setContent("Content 5");
		addPosts(post);			
	}
	
	void addPosts(Post post) {
        try{
            RestTemplate rt = getRestTemplate();
            String uri = "http://localhost:8080/posts";
            rt.postForObject(uri, post, Post.class);         
        }
        catch(Exception e){
            logger.error("POST users error:  " + e.getMessage());
        }
	}	
}
