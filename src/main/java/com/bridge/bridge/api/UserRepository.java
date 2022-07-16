package com.bridge.bridge.api;

public interface UserRepository {
    UserDTO saveUser(UserDTO userDTO);

    UserDTO updateUser(UserDTO userDTO);
    UserDTO deleteUser(UserDTO userDTO);
}
