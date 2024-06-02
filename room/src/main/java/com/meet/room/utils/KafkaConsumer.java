package com.meet.room.utils;

import com.meet.room.message.ChatMessage;
import com.meet.room.message.RoomInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumer {

    private final SimpMessagingTemplate template;

    @KafkaListener(topics = "timeTable", containerFactory = "roomInfoKafkaListenerContainerFactory")
    public void timeTableListener(RoomInfo data) {
        String uri = data.getRoomId().substring(1, data.getRoomId().length() - 1);
        template.convertAndSend("/topic/"+uri, data.getTimeTable()); //이 경로의 끝 주소를 room-id로 하는건가? 그러면 해당 destination을 구독하고 있는 client만 값을 받게되는데
    }

    @KafkaListener(topics = "chat", containerFactory = "chatMessageKafkaListenerContainerFactory")
    public void chatListener(ChatMessage data) {
        String uri = data.getRoomId().substring(1, data.getRoomId().length() - 1);
        template.convertAndSend("/topic/"+uri, data);
    }
}