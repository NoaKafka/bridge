package com.bridge.bridge.user;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MemoryUserRepository implements UserRepository{

    Map<String, UserEntity> userMap = new ConcurrentHashMap<>();

    @Override
    public UserDTO saveUser(UserDTO userDTO){
        UserEntity user = new UserEntity(userDTO);
        userMap.put(user.getUserId(), user);
        return new UserDTO(userMap.get(user.getUserId()));
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        UserEntity user = userMap.get(userDTO.getUserId());
        return new UserDTO(user.updateUser(userDTO));
    }
}
