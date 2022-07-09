package com.bridge.bridge.user;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class MemoryUserRepositoryTest {

    @Autowired
    private UserRepository repository = new MemoryUserRepository();

    @Test
    void joinUser() {
        UserDTO user = new UserDTO("noakafka", "1234", "noa", "Repo Test");
        UserDTO savedUser = repository.saveUser(user);
        log.info(savedUser.toString());
        assertThat(savedUser.getUserId()).isEqualTo(user.getUserId());
    }

    @Test
    void updateUser() {
        UserDTO user = new UserDTO("noakafka", "1234", "noa", "Repo Test");
        UserDTO savedUser = repository.saveUser(user);

        UserDTO user2update = new UserDTO("noakafka", "1234", "noa", "Update Test");
        UserDTO updatedUser = repository.updateUser(user2update);
        log.info(updatedUser.toString());
        assertThat(updatedUser.getProfile()).isEqualTo(user2update.getProfile());
    }

}