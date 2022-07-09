package com.bridge.bridge.user;

public interface UserRepository {
    UserDTO saveUser(UserDTO userDTO);

    UserDTO updateUser(UserDTO userDTO);
}
