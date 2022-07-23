package com.bridge.bridge.api.member;

import com.bridge.bridge.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberVO {

    private String memberId;
    private String name;
    private String jSessionId;

    public MemberVO(Member member) {
        this.memberId = member.getMemberId();
        this.name = member.getName();
    }
}
