package com.example.board.persistence.member;

import com.example.board.api.member.dto.response.MemberResponse;
import com.example.board.persistence.member.custom.MemberRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity,Long>, MemberRepositoryCustom {
    Optional<MemberResponse> findByEmail(String email);

}
