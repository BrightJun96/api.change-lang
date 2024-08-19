package com.example.board.api.member;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<MemberEntity> getAllMember() {
        return memberRepository.findAll();
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
}
