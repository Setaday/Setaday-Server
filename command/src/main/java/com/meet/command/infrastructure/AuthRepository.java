package com.meet.command.infrastructure;

import com.meet.command.domain.Auth;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends MongoRepository<Auth, String> {

    Optional<Auth> findByRoomIdAndUserId(String roomId, String userId);

    boolean existsByRoomIdAndUserId(String roomId, String userId);

    default Auth getAuthByRoomIdAndUserId(String roomId, String userId) {
        return this.findByRoomIdAndUserId(roomId, userId).orElseThrow(NullPointerException::new);
    }

}
