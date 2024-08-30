package com.example.board.api;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class CustomException {
    private final String message="존재하지 않습니다.";


}
