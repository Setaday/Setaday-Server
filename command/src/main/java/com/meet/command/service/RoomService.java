package com.meet.command.service;

import com.meet.command.domain.Room;
import com.meet.command.dto.CreateRoomDto;
import com.meet.command.infrastructure.RoomRepository;
import com.meet.command.message.RoomInfo;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public Room createRoom(CreateRoomDto roomDto) {
        return roomRepository.save(new Room(null, roomDto.roomName(), null, null, null, null));
    }

    public RoomInfo createTimeTable(String roomId) {
        String substring = roomId.substring(1, roomId.length() - 1);
        Room room = roomRepository.getRoomById(substring);
        Map<LocalDateTime, List<String>> result = new HashMap<>();

        for (Map.Entry<String, List<LocalDateTime>> entry : room.getUserData().entrySet()) {
            for (LocalDateTime localDateTime : entry.getValue()) {
                if (result.containsKey(localDateTime)) {
                    List<String> user = result.get(localDateTime);
                    if (!user.contains(entry.getKey())) {
                        user.add(entry.getKey());
                        result.put(localDateTime, user);
                    }
                    continue;
                }
                List<String> newUser = new ArrayList<>();
                newUser.add(entry.getKey());
                result.put(localDateTime, newUser);
            }
        }
        return new RoomInfo(roomId, result);
    }

}
