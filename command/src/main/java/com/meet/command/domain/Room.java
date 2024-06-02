package com.meet.command.domain;

import com.meet.command.utils.DateData;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "room")
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    @Id
    private String id;
    private String roomName;
    private List<DateData> date;
    private String startTime;
    private String endTime;
    private Map<String, List<LocalDateTime>> userData = new HashMap<>();

}
