package com.meet.command.utils;

import com.meet.command.message.RoomInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, RoomInfo> kafkaTemplate;

    public void send(String topic, RoomInfo result) {
        kafkaTemplate.send(topic, result);
    }
}
