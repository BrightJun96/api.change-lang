package com.example.board.api.auth;

import com.example.board.api.auth.dto.request.AuthRequest;
import com.example.board.api.member.dto.response.MemberResponse;
import com.example.board.common.utils.JwtUtil;
import com.example.board.persistence.member.MemberEntity;
import com.example.board.persistence.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;
    private final JwtUtil jwtUtil;

    public String login(AuthRequest authRequest) {
        // 로그인 로직
        Optional<MemberResponse> member = memberRepository.findByEmail(authRequest.getEmail());


        if (member.isEmpty()) {
            return "회원이 존재하지 않습니다.";
        }

        if (!member.get().getPassword().equals(authRequest.getPassword())) {

            return "비밀번호가 일치하지 않습니다.";
        }


        /**
         * @Todo
         * 쿠키로 accessToken 발급
         */

        String AccessToken = jwtUtil.generateToken(member.get().getEmail());

        ResponseCookie cookie = jwtUtil.createCookie("access_token", AccessToken,10000);

        return cookie.toString();

    }

}
