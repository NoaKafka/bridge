package com.bridge.bridge.domain.friendship;

import com.bridge.bridge.api.friendship.FriendshipVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "relation")
public class Friendship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String memberId;

    @Column
    private String friendId;

    public Friendship(FriendshipVO friendshipVO) {
        this.memberId = friendshipVO.getMemberId();
        this.friendId = friendshipVO.getFriendId();
    }
}
