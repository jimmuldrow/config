package com.workQueue;

import com.test.Receive;
import com.test.Send;

public class Test {
	public static void main(String[] args){
		String[] message1 = {"This", "is", "a", "message"};
		String[] message2 = {"Another", "message", "is", "sent"};
		
		for(int i = 0; i < 2; i++){
			Worker.main();
			Worker.main();
		}		
		
		for(int i = 0; i < 3; i++){
			NewTask.main(message1);
		}		
		
		for(int i = 0; i < 2; i++){
			NewTask.main(message2);
		}				
	}
}
