package com.example.board.api.country.dto.response;

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
}
