package com.meet.room.message;

import java.io.Serializable;
import lombok.Data;

@Data
public class ChatMessage implements Serializable {
    private String roomId;
    private String userId;
    private String content;
}
