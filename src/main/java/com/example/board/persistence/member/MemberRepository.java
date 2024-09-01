package com.example.board.persistence.member;

import com.example.board.persistence.member.custom.MemberRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity,Long>, MemberRepositoryCustom {
}
