package com.example.board.api.member;


import com.example.board.api.CustomException;
import com.example.board.api.member.dto.response.MemberResponse;
import com.example.board.api.member.dto.response.mapper.MemberResponseMapper;
import com.example.board.persistence.member.MemberEntity;
import com.example.board.persistence.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final CustomException customException;
    private final MemberResponseMapper memberResponseMapper;


    /**
     * 모든 회원 조회
     */
    public Page<MemberResponse> getAllMember(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        return memberRepository.getMemberList(pageable);
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
