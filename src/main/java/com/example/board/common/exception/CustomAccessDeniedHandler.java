package com.example.board.common.exception;

import com.example.board.common.response.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import java.io.IOException;


/**
 * 권한이 없을 때(403) 처리하는 핸들러
 */
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private final ObjectMapper objectMapper;

    public CustomAccessDeniedHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException {

        response.setStatus(HttpServletResponse.SC_FORBIDDEN);  // 403 상태 코드 설정
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);  // JSON 형식으로 응답 설정
        response.setCharacterEncoding("UTF-8");

        // JSON 응답 생성
        Response<String> customResponse = Response.fail("권한이 없습니다.");

        // JSON으로 변환 후 응답 본문에 쓰기
        response.getWriter().write(objectMapper.writeValueAsString(customResponse));
    }

}
