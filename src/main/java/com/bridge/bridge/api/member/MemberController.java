package com.bridge.bridge.api.member;

import com.bridge.bridge.domain.member.Member;
import com.bridge.bridge.domain.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberservice;

    @GetMapping
    public List<Member> findAllMember(){
        return memberservice.findMembers() ;
    }

    @PostMapping
    public Member save(@RequestBody MemberRequest memReq){
        Member member = Member.builder().
                memberId(memReq.getUserId()).
                name(memReq.getNickName()).
                password(memReq.getPw()).build();
        return memberservice.save(member);
    }

    @GetMapping("/{memberId}/exists")
    public ResponseEntity<Boolean> checkMemberIdDuplicate(@PathVariable String memberId){
        return ResponseEntity.ok(memberservice.checkIdDuplicate(memberId));
    }
}
