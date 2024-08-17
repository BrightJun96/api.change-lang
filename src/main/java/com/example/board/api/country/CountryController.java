package com.example.board.api.country;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.base-path}/country")
public class CountryController {
    private final CountryService countryService;

    @GetMapping("/all")
    public List<CountryEntity> getAllBoards() {
        return countryService.getAllCountry();
    }
}
