package com.test.tests;

import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.test.models.Comment;

public class PostComments extends TemplateSetup {
	private static final Logger logger = LoggerFactory.getLogger(PostComments.class);
	
	public static void main(String[] args) {
		new PostComments();
	}
	
	PostComments(){
		String postId = "2";
		Comment comment = new Comment();
		comment.setText("This is comment 1");
		addComments(postId, comment);
		
		postId = "2";
		comment = new Comment();
		comment.setText("This is comment 2");
		addComments(postId, comment);		
		
		postId = "2";
		comment = new Comment();
		comment.setText("This is comment 3");
		addComments(postId, comment);	
		
		postId = "3";
		comment = new Comment();
		comment.setText("This is comment 4");
		addComments(postId, comment);	
		
		postId = "3";
		comment = new Comment();
		comment.setText("This is comment 5");
		addComments(postId, comment);	
		
		postId = "4";
		comment = new Comment();
		comment.setText("This is comment 6");
		addComments(postId, comment);	
	}
	
	void addComments(String postId, Comment comment) {
        try{
            RestTemplate rt = getRestTemplate();
            String uri = "http://localhost:8080/postCommentToPosts/" + postId;
            rt.postForObject(uri, comment, Comment.class);         
        }
        catch(Exception e){
            logger.error("POST Comment error:  " + e.getMessage());
        }
	}	
}
