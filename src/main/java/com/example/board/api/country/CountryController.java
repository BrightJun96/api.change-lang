package com.example.board.api.country;

import com.example.board.api.country.dto.response.CountryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.base-path}/country")
public class CountryController {
    private final CountryService countryService;

    @GetMapping("/all")
    public List<CountryResponse> getAllBoards() {
        return countryService.getAllCountry();
    }
    /**
     * 검색어로 나라 정보 조회
     */
    @GetMapping("/search")
    public List<CountryResponse> searchCountries(@RequestParam String searchTerm) {
        return countryService.searchCountries(searchTerm);
    }
}
