package com.example.board.persistence.country.custom;

import com.example.board.api.country.dto.response.CountryResponse;

import java.util.List;

public interface CountryRepositoryCustom {

   List<CountryResponse> getCountryList(String searchTerm);
}
