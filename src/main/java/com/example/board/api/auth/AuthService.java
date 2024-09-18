package com.example.board.api.auth;

import com.example.board.common.exception.CustomException;
import com.example.board.api.auth.dto.request.AuthRequest;
import com.example.board.api.member.MemberService;
import com.example.board.api.member.dto.response.MemberResponse;
import com.example.board.common.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberService memberService;
    private final JwtUtil jwtUtil;

    public String login(AuthRequest authRequest) {
        // 로그인 로직
      MemberResponse member = memberService.getMemberByEmail(authRequest.getEmail());




        if (!member.getPassword().equals(authRequest.getPassword())) {
           throw new CustomException("비밀번호가 일치하지 않습니다.", HttpStatus.UNAUTHORIZED);
        }



//             쿠키 생성
//            ResponseCookie cookie = jwtUtil.createCookie("access_token", AccessToken,10000);

            // JWT 생성 및 반환
            return jwtUtil.generateToken(member.getEmail());

    }

}
