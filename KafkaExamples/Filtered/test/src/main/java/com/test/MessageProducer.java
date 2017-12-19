package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

public class MessageProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    @Value(value = "${filtered.topic.name}")
    private String filteredTopicName;

 
    public void sendMessageToFiltered(String message) {
        kafkaTemplate.send(filteredTopicName, message);
    }
}
