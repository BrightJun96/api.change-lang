package com.example.board.api.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.base-path}/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/all")
    public List<MemberEntity> getAllMembers() {
        return memberService.getAllMember();
    }
}
