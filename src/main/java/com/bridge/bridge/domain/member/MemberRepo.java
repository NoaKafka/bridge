package com.bridge.bridge.domain.member;

import com.bridge.bridge.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepo extends JpaRepository<Member, Long> {
    Boolean existsByMemberId(String memberId);

    Optional<Member> findByMemberId(String memberId);
}
