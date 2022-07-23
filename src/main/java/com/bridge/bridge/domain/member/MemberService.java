package com.bridge.bridge.domain.member;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MemberService {

    private final MemberRepo memberRepo;

    public Boolean checkIdDuplicate(String memberId) {
        return memberRepo.existsByMemberId(memberId);
    }

    public List<Member> findMembers() {
        return memberRepo.findAll();
    }

    public Member save(Member member) {
        return memberRepo.save(member);
    }

}
