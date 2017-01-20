package com.test.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ClientApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfiguration.class);
		MyApplication app = context.getBean(MyApplication.class);		
		app.processMessage("Hi Pankaj", "pankaj@abc.com");
		context.close();
	}
}