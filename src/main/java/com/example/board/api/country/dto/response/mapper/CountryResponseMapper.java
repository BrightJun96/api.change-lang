package com.example.board.api.country.dto.response.mapper;

import com.example.board.persistence.country.CountryEntity;
import com.example.board.api.country.dto.response.CountryResponse;
import org.springframework.stereotype.Component;

@Component
public class CountryResponseMapper {
    public CountryResponse toCountryResponse(CountryEntity countryEntity) {
    return CountryResponse.builder()
            .id(countryEntity.getId())
            .name(countryEntity.getName())
            .lang(countryEntity.getLang())
            .build();
    }

}
