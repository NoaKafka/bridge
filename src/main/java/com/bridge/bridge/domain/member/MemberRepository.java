package com.bridge.bridge.domain.member;

import com.bridge.bridge.api.UserDTO;
import com.bridge.bridge.api.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Slf4j
public class MemberRepository {

    private static Map<Long, Member> store = new ConcurrentHashMap<>();
    private static long sequence = 0L;

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    public Optional<Member> findByLoginId(String loginId){
        return findAll().stream()
                .filter(m -> m.getLoginId().equals(loginId))
                .findFirst();
    }

    public void clearStore(){
        store.clear();
    }

    public Member update(Member member) {
        store.put(member.getId(), member);
        return member;
    }

    public Member delete(Member member) {
        Member user = store.get(member.getId());
        if(user != null){
            store.remove(user.getId());
        }
        return null;
    }
}
