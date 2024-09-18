package com.example.board.api.member;


import com.example.board.common.exception.CustomException;
import com.example.board.api.member.dto.response.MemberResponse;
import com.example.board.api.member.dto.response.mapper.MemberResponseMapper;
import com.example.board.persistence.member.MemberEntity;
import com.example.board.persistence.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private  CustomException customException;
    private final MemberResponseMapper memberResponseMapper;


    /**
     * 모든 회원 조회
     */
    public Page<MemberResponse> getAllMember(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        return memberRepository.getMemberList(pageable);
    }

    /**
     * 이메일 값으로 회원 조회
     */
    public MemberResponse getMemberByEmail(String email) {
        return memberRepository.findByEmail(email).orElseThrow(() -> new CustomException("회원이 존재하지 않습니다.", HttpStatus.NOT_FOUND));
    }

    /**
     * JWT 토큰에서 사용자 이름을 추출한 후, 이를 기반으로 사용자의 세부 정보를 조회 후 시큐리티 UserDetails 객체를 반환
     */
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        MemberResponse member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다."));
        return new org.springframework.security.core.userdetails.User(member.getEmail(), member.getPassword(), new ArrayList<>());
    }


    public MemberEntity getMember(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    public MemberEntity saveMember(MemberEntity memberEntity) {
        return memberRepository.save(memberEntity);
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    public String getExceptionMessage() {
        return customException.getMessage();
    }




}
