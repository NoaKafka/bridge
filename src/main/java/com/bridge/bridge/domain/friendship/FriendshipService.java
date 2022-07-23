package com.bridge.bridge.domain.friendship;

import com.bridge.bridge.api.friendship.FriendshipVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@AllArgsConstructor
@Service
public class FriendshipService {

    private final FriendshipRepo friendshipRepo;

    public List<Friendship> findAllById(String id){
        return friendshipRepo.findAllById(Long.valueOf(id));
    }

    public FriendshipVO save(FriendshipVO friendshipVO) {
        return new FriendshipVO(friendshipRepo.save(new Friendship(friendshipVO)));
    }
}
