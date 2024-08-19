package com.example.board.api.member.enums;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Gender {
    male("male"),
    female("female");

    private final String value;

}
