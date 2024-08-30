package com.example.board.api.member;


import com.example.board.api.CustomException;
import com.example.board.api.member.dto.response.MemberResponse;
import com.example.board.api.member.dto.response.mapper.MemberResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final CustomException customException;
    private final MemberResponseMapper memberResponseMapper;


    /**
     * 모든 회원 조회
     */
    public List<MemberResponse> getAllMember() {
        return memberRepository.findAll().stream()
                .map(memberResponseMapper::toMemberResponse)
                .toList();
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
