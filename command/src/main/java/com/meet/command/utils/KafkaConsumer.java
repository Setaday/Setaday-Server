package com.meet.command.utils;

import com.meet.command.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumer {

    private final KafkaProducer kafkaProducer;
    private final RoomService roomService;

    @KafkaListener(topics = "update")
    public void listener(String roomId) {
        kafkaProducer.send("timeTable", roomService.createTimeTable(roomId));
    }


}
