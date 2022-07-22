package com.bridge.bridge.api;

import com.bridge.bridge.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepo extends JpaRepository<Member, Long> {
    Boolean existsByMemberId(String memberId);
}
