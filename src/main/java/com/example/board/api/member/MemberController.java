package com.example.board.api.member;

import com.example.board.api.member.dto.response.MemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.base-path}/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/all")
    public Page<MemberResponse> getAllMembers(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "10") int size) {
        return memberService.getAllMember(page,size);
    }

    @GetMapping("/exception")
    public String getExceptionMessage() {
        return  memberService.getExceptionMessage();
    }
}
