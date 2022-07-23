package com.bridge.bridge.api.friendship;

import com.bridge.bridge.domain.friendship.Friendship;
import lombok.Data;

import javax.persistence.Column;

@Data
public class FriendshipVO {

    private String memberId;
    private String friendId;

    public FriendshipVO(Friendship friendship) {
        this.memberId = friendship.getMemberId();
        this.friendId = friendship.getFriendId();
    }
}
