package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

public class MessageProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    @Value(value = "${partitioned.topic.name}")
    private String partionedTopicName;

    public void sendMessageToPartion(String message, int partition) {
        kafkaTemplate.send(partionedTopicName, partition, message);
    }
}
