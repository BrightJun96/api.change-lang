package com.example.board.api.member.dto.response;

import com.example.board.api.member.enums.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
public class MemberResponse {

    // 회원 PK
    private Long id;

    // 이메일
    private String email;

    // 이름
    private String username;

    // 비밀번호
    private String password;

    // 성별
    private Gender gender;

    // 생년월일
    private String birth;

    // 나라
    private Integer country;

    // 언어
    private Integer rootLang;

    // 휴대폰 번호
    private String phone;

    // 자기소개
    private String introduce;

    //
    private String co;



}
