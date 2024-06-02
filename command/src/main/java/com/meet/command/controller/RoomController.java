package com.meet.command.controller;

import com.meet.command.dto.CreateRoomDto;
import com.meet.command.dto.EnterRoomDto;
import com.meet.command.service.AuthService;
import com.meet.command.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;
    private final AuthService authService;

    @PostMapping
    public String createRoom(CreateRoomDto roomDto) {
        return roomService.createRoom(roomDto).getId();
    }

    @PostMapping("/enter")
    public String enterRoom(EnterRoomDto enterRoomDto) {
        return authService.enterRoom(enterRoomDto);
    }
}
