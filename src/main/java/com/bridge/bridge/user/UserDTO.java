package com.bridge.bridge.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;

@AllArgsConstructor
@Getter
@ToString
public class UserDTO {
    private String userId;
    private String pw;
    private String nickName;
    private String profile;

    public UserDTO(UserEntity user) {
        this(user.getUserId(), user.getPw(), user.getNickName(), user.getProfile());
    }
}
