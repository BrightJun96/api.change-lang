package com.example.board.common.exception;

import com.example.board.common.response.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 인증 실패 시(401) 처리하는 핸들러
 */
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper;

    public CustomAuthenticationEntryPoint(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);  // 401 상태 코드 설정
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);  // JSON 응답 설정
        response.setCharacterEncoding("UTF-8");

        // 실패 응답을 JSON으로 변환하여 응답 본문에 씀
        Response<String> customResponse = Response.fail("로그인이 필요합니다.");
        response.getWriter().write(objectMapper.writeValueAsString(customResponse));
    }
}
