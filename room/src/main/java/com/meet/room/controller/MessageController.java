package com.meet.room.controller;

import com.meet.room.message.ChatMessage;
import com.meet.room.message.DragMessage;
import com.meet.room.service.TimeTableService;
import com.meet.room.utils.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MessageController {

    private final KafkaProducer kafkaProducer;
    private final TimeTableService timeTableService;

    @MessageMapping("/drag")
    public void sendDragMessage(DragMessage dragMessage) {
        timeTableService.pushTimeTable(dragMessage);
        try {
            kafkaProducer.send("update", dragMessage.getRoomId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @MessageMapping("/chat")
    public void sendChatMessage(ChatMessage chatMessage) {
        try {
            kafkaProducer.send("chat", chatMessage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
