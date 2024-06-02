package com.meet.command.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "auth")
@AllArgsConstructor
@NoArgsConstructor
public class Auth {

    private String roomId;
    private String userId;
    private String password;

}
