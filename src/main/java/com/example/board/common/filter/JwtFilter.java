package com.example.board.common.filter;

import com.example.board.api.member.MemberService;
import com.example.board.api.member.dto.response.MemberResponse;
import com.example.board.common.utils.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.io.IOException;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final MemberService memberService;
    private final JwtUtil jwtUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 쿠키에서 JWT 토큰을 추출
        Cookie[] cookies = request.getCookies();

        if(cookies != null){

            String accessToken = getCookieValue(cookies, "accessToken");
            System.out.println("accessToken = " + accessToken);

            if(accessToken != null){
                // JWT에서 사용자 정보 추출
                String username = jwtUtil.extractUsername(accessToken);

                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                    UserDetails userDetails = this.memberService.loadUserByUsername(username);

                    // JWT 토큰 검증
                    if (jwtUtil.validateToken(accessToken, userDetails.getUsername())) {

                        // 인증 성공 시 SecurityContext에 사용자 정보 저장
                        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );

                        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    }
                }

            }
        }


        // 다음 필터로 전달
        filterChain.doFilter(request, response);
    }

    /**
     * Cookie 조회
     */
    private String getCookieValue(Cookie[] cookies, String cookieName) {
        return Arrays.stream(cookies)
                .filter(cookie -> cookie.getName().equals(cookieName))
                .map(Cookie::getValue)
                .findFirst()
                .orElse(null);
    }
}
