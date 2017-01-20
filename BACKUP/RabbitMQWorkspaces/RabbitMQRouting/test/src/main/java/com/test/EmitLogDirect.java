package com.test;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

public class EmitLogDirect {

    private static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] argv)
                  throws java.io.IOException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = null;
        
		try {
			connection = factory.newConnection();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "direct");

        String severity = "" + getSeverity();
        String message = getMessage(argv);

        channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes());
        System.out.println(" [x] Sent '" + severity + "':'" + message + "'");

        try {
			channel.close();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
        
        connection.close();
    }
    
    /*
     *  1 = Info
     *  2 = Warning
     *  3 = Error
     *  
     *  If this were real, each message would have an appropriate severity.
     */
    public static int getSeverity(){
    	return 1;
    }

    private static String getMessage(String[] strings){
	    if (strings.length < 1)
	        return "Hello World!";
	    return joinStrings(strings, " ");
	}

	private static String joinStrings(String[] strings, String delimiter) {
	    int length = strings.length;
	    if (length == 0) return "";
	    StringBuilder words = new StringBuilder(strings[0]);
	    for (int i = 1; i < length; i++) {
	        words.append(delimiter).append(strings[i]);
	    }
	    return words.toString();
	}     
}
