package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

public class MessageProducer {

    @Autowired
    private KafkaTemplate<String, Greeting> greetingKafkaTemplate;
    
    @Value(value = "${greeting.topic.name}")
    private String greetingTopicName;

    public void sendGreetingMessage(Greeting greeting) {
        greetingKafkaTemplate.send(greetingTopicName, greeting);
    }
}
