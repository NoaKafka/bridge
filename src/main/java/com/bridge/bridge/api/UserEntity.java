package com.bridge.bridge.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
@AllArgsConstructor
public class UserEntity {

    @Id
    private String userId;

    @Column
    private String pw;

    @Column
    private String nickName;

    @Column
    private String profile;

    public UserEntity(UserDTO user) {
        this(user.getUserId(), user.getPw(), user.getNickName(), user.getProfile());
    }

    public UserEntity updateUser(UserDTO user){
        this.userId = user.getUserId();
        this.pw = user.getPw();
        this.nickName = user.getNickName();
        this.profile = user.getProfile();

        return this;
    }
}
