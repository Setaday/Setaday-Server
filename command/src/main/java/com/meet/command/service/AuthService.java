package com.meet.command.service;

import com.meet.command.domain.Auth;
import com.meet.command.dto.EnterRoomDto;
import com.meet.command.infrastructure.AuthRepository;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;

    private void createAuth(EnterRoomDto enterRoomDto) {
        authRepository.save(new Auth(enterRoomDto.roomId(), enterRoomDto.userId(),
            enterRoomDto.password()));
    }

    private boolean comparePassword(EnterRoomDto enterRoomDto) {
        Auth auth = authRepository.getAuthByRoomIdAndUserId(enterRoomDto.roomId(),
            enterRoomDto.userId());
        return Objects.equals(auth.getPassword(), enterRoomDto.password());
    }

    public String enterRoom(EnterRoomDto enterRoomDto) {
        if (!authRepository.existsByRoomIdAndUserId(enterRoomDto.roomId(), enterRoomDto.userId())) { // 해당 방 auth 정보에 아이디 일치하는 데이터가 없는경우
            createAuth(enterRoomDto);
            return "새로운 사용자 입장";
        }
        //아닐때 비번이 틀린 경우
        if(!comparePassword(enterRoomDto)){
            return "비밀번호가 틀렸습니다.";
        }
        return "로그인 성공";
    }

}
