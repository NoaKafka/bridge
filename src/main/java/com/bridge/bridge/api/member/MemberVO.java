package com.bridge.bridge.api.member;

import com.bridge.bridge.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {

    private Long id;
    private String memberId;
    private String name;


    public MemberVO(Member member) {
        this.memberId = member.getMemberId();
        this.name = member.getName();
        this.id = member.getId();
    }
}
