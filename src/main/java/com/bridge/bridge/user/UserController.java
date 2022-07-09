package com.bridge.bridge.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/")
    public ResponseEntity handleUserRequest(@RequestBody UserRequest userReq){
        Action action = userReq.getAction();
        if(action == null) return null;

        UserDTO userDTO = new UserDTO(userReq.getUserId(), userReq.getPw(), userReq.getNickName(), userReq.getProfile());

        if(action.equals(Action.JOIN)){
            userRepository.saveUser(userDTO);
        } else if (action.equals(Action.WITHDRAW)) {
            userRepository.updateUser(userDTO);
        } else if (action.equals(Action.LOGIN)) {

        } else if (action.equals(Action.LOGOUT)) {

        }
        return null;
    }

}
