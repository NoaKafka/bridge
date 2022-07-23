package com.bridge.bridge.api.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequest {

    private String userId;
    private String pw;
    private String nickName;
    private String profile;
}
