package com.example.board.persistence.country.custom;

import com.example.board.api.country.dto.response.CountryResponse;
import com.example.board.api.country.dto.response.QCountryResponse;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.board.persistence.country.QCountryEntity.countryEntity;

@RequiredArgsConstructor
public class CountryRepositoryImpl implements CountryRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<CountryResponse> getCountryList(String searchTerm) {

        return queryFactory.select(new QCountryResponse(countryEntity.id, countryEntity.name, countryEntity.lang))
                .from(countryEntity)
                .where(countryEntity.name.contains(searchTerm))
                .fetch();
    };
}
