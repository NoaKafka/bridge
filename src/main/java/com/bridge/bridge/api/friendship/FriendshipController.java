package com.bridge.bridge.api.friendship;

import com.bridge.bridge.domain.friendship.Friendship;
import com.bridge.bridge.domain.friendship.FriendshipService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@Slf4j
@AllArgsConstructor
@RestController("/friendship")
public class FriendshipController {

    private final FriendshipService friendshipService;

    @PostMapping
    public FriendshipVO save(@CookieValue(name = "id") String id, @RequestBody FriendshipVO friendshipVO){
        return friendshipService.save(friendshipVO);
    }

    @GetMapping
    public List<Friendship> getFriendList(@CookieValue(name = "id") String id){
        return friendshipService.findAllById(id);
    }
}
