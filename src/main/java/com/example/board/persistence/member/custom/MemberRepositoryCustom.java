package com.example.board.persistence.member.custom;

import com.example.board.api.member.dto.response.MemberResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberRepositoryCustom {

    Page<MemberResponse> getMemberList(Pageable pageable);

}
