package com.meet.command.infrastructure;

import com.meet.command.domain.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends MongoRepository<Room, String> {

    default Room getRoomById(String id) {
        return this.findById(id).orElseThrow(NullPointerException::new);
    }

}
