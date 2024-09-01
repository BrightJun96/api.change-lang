package com.example.board.persistence.member.custom;

import com.example.board.api.member.dto.response.MemberResponse;
import com.example.board.api.member.dto.response.QMemberResponse;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import static com.example.board.persistence.member.QMemberEntity.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class MemberRepositoryCustomImpl implements MemberRepositoryCustom {
    private final JPAQueryFactory queryFactory;


    /**
     * 회원 목록 조회
     */
    @Override
    public Page<MemberResponse> getMemberList(Pageable pageable) {



        Pageable pagable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());


        List<MemberResponse> memberList = queryFactory
                .select(new QMemberResponse(
                        memberEntity.id,
                        memberEntity.email,
                        memberEntity.username,
                        memberEntity.password,
                        memberEntity.gender,
                        memberEntity.birth,
                        memberEntity.country,
                        memberEntity.rootLang,
                        memberEntity.phone,
                        memberEntity.introduce
                ))
                .from(memberEntity)
                .offset(pagable.getOffset())
                .limit(pagable.getPageSize())
                .fetch();


// 전체 데이터 수 계산
        long total = Optional.ofNullable(queryFactory
                .select(memberEntity.count())
                .from(memberEntity)
                .fetchOne()).orElse(0L);

        return new PageImpl<>(memberList, pageable, total);
    }


}
