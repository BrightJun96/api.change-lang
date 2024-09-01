package com.example.board.api.country.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CountryResponse {

    // 나라 PK
    private Long id;

    // 나라이름
    private String name;

    // 언어
    private String lang;

    @QueryProjection
    public CountryResponse(Long id, String name, String lang) {
        this.id = id;
        this.name = name;
        this.lang = lang;
    }
}
