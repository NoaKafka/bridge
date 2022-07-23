package com.bridge.bridge.api.login;


import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginForm {

    private String loginId;
    private String password;

}
