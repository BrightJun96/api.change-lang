package com.example.board.api.country;

import com.example.board.api.country.dto.response.CountryResponse;
import com.example.board.api.country.dto.response.mapper.CountryResponseMapper;
import com.example.board.persistence.country.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository countryRepository;
    private final CountryResponseMapper countryResponseMapper;

    /**
     * 모든 나라 정보 조회
     */
    public List<CountryResponse> getAllCountry() {
        return countryRepository.findAll().stream()
                .map(countryResponseMapper::toCountryResponse)
                .toList();
    }

    /**
     * 검색어로 나라 정보 조회
     * @param searchTerm 검색어
     * @return 검색된 나라 정보 리스트
     */
    public List<CountryResponse> searchCountries(String searchTerm) {
        return countryRepository.getCountryList(searchTerm);
    }
}
