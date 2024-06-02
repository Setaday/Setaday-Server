package com.meet.room.message;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class DragMessage implements Serializable {
    private String roomId;
    private String userId;
    private List<LocalDateTime> timeTable;

}
