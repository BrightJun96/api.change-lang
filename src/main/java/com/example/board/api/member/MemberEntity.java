package com.example.board.api.member;

import com.example.board.api.member.enums.Gender;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

@Entity
@Getter
@Table(name = "members")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("PK")
    private Long id;

    @Column(nullable = false)
    @Comment("이메일")
    private String email;

    @Column(nullable = false)
    @Comment("이름")
    private String username;

    @Column(nullable = false)
    @Comment("비밀번호")
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @Comment("성별")
    private Gender gender;

    @Column(nullable = false)
    @Comment("생년월일")
    private String birth;

    @Column(nullable = false)
    @Comment("나라")
    private Integer country;

    @Column(name = "root_lang", nullable = false)
    @Comment("언어")
    private Integer rootLang;

    @Column(nullable = false)
    @Comment("휴대폰 번호")
    private String phone;

    @Comment("자기소개")
    private String introduce;

    @Comment("sns 종류")
    private String provider;

    @Comment("sns 고유값")
    private String providerId;
}
