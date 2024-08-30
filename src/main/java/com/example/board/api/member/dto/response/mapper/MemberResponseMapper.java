package com.example.board.api.member.dto.response.mapper;

import com.example.board.api.member.MemberEntity;
import com.example.board.api.member.dto.response.MemberResponse;
import org.springframework.stereotype.Component;

@Component
public class MemberResponseMapper {
    public MemberResponse toMemberResponse(MemberEntity memberEntity){
        return MemberResponse.builder()
                .id(memberEntity.getId())
                .email(memberEntity.getEmail())
                .username(memberEntity.getUsername())
                .password(memberEntity.getPassword())
                .gender(memberEntity.getGender())
                .birth(memberEntity.getBirth())
                .country(memberEntity.getCountry())
                .rootLang(memberEntity.getRootLang())
                .phone(memberEntity.getPhone())
                .introduce(memberEntity.getIntroduce())
                    .build();

    }
}
