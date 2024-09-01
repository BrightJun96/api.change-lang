package com.example.board.persistence.country;

import com.example.board.persistence.country.custom.CountryRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<CountryEntity, Long>, CountryRepositoryCustom {
//    @Query("SELECT c FROM CountryEntity c WHERE c.name LIKE %:searchTerm% OR c.lang LIKE %:searchTerm%")
//    List<CountryEntity> searchByNameOrLang(@Param("searchTerm") String searchTerm);
}
