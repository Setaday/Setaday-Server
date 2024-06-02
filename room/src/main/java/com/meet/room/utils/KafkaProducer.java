package com.meet.room.utils;

import com.meet.room.message.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void send(String topic, String roomId) {
        kafkaTemplate.send(topic, roomId);
    }

    public void send(String topic, ChatMessage chatMessage) {
        kafkaTemplate.send(topic, chatMessage);
    }
}
