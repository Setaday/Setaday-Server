package com.meet.command.dto;

public record EnterRoomDto(
    String roomId,
    String userId,
    String password
) {

}
