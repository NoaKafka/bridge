package com.bridge.bridge.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberRequest {

    private String userId;
    private String pw;
    private String nickName;
    private String profile;
}
