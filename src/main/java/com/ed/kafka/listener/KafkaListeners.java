package com.ed.kafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static com.ed.kafka.config.KafkaTopicConfig.TOPIC;

@Component
public class KafkaListeners {

    @KafkaListener(topics = {TOPIC}, groupId = "groupIdA")
    void listen(String data) {
        System.out.println("Received: " + data);
    }
}
