package com.meet.room.service;

import com.meet.room.domain.Room;
import com.meet.room.infrastructure.RoomRepository;
import com.meet.room.message.DragMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TimeTableService {

    private final RoomRepository roomRepository;

    public void pushTimeTable(DragMessage dragMessage) {
        Room room = roomRepository.findById(dragMessage.getRoomId()).get();
        room.updateTimeTable(dragMessage.getUserId(), dragMessage.getTimeTable());
        roomRepository.save(room);
    }

}
