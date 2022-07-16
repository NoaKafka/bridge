package com.bridge.bridge.api;

import lombok.Getter;

@Getter
public class UserRequest {
    private Action action;
    private String userId;
    private String pw;
    private String nickName;
    private String profile;

    public UserRequest(Action action, String userId, String pw) {
        this.action = action;
        this.userId = userId;
        this.pw = pw;
    }

    public UserRequest(Action action, String userId, String pw, String nickName, String profile) {
        this.action = action;
        this.userId = userId;
        this.pw = pw;
        this.nickName = nickName;
        this.profile = profile;
    }
}

enum Action {
    JOIN, UPDATE, WITHDRAW, LOGIN, LOGOUT
}