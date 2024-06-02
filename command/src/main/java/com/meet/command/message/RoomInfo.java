package com.meet.command.message;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
public class RoomInfo implements Serializable {
    private String roomId;
    private Map<LocalDateTime, List<String>> timeTable;

    public RoomInfo(String roomId, Map<LocalDateTime, List<String>> timeTable) {
        this.roomId = roomId;
        this.timeTable = timeTable;
    }
}
