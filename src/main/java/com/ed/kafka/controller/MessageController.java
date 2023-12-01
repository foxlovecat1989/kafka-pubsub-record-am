package com.ed.kafka.controller;

import com.ed.kafka.dto.MessageRequest;
import com.ed.kafka.pojo.Message;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import static com.ed.kafka.config.KafkaTopicConfig.TOPIC;

@RestController("api/v1/messages")
public class MessageController {
    private final KafkaTemplate<String, Message> kafkaTemplate;

    public MessageController(KafkaTemplate<String, Message> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("send")
    public void publish(@RequestBody MessageRequest request) {
        Message message = new Message(request.message(), request.from(), LocalDateTime.now());
        kafkaTemplate.send(TOPIC, message);
    }
}
