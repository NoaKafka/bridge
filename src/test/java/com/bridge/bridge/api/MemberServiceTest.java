package com.bridge.bridge.api;

import com.bridge.bridge.domain.member.MemberRepo;
import com.bridge.bridge.domain.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberRepo memberRepo;

    @Test
    void 유저아이디중복검사() {
        // given
        memberRepo.save(Member.builder()
                .memberId("noakafka")
                .password("1234")
                .name("유종우")
                .build());

        // when
        Boolean isExist = memberRepo.existsByMemberId("noakafka");
        // then
        assertThat(isExist).isEqualTo(true);
    }

    @Test
    void 멤버전부불러오기() {
        // given
        memberRepo.save(Member.builder()
                .memberId("noakafka")
                .password("1234")
                .name("유종우")
                .build());
        memberRepo.save(Member.builder()
                .memberId("noakafka2")
                .password("1234")
                .name("유종우2")
                .build());
        memberRepo.save(Member.builder()
                .memberId("noakafka3")
                .password("1234")
                .name("유종우3")
                .build());
        // when
        List<Member> memList = memberRepo.findAll();
        // then
        for(Member m : memList){
            System.out.println(m.toString());
        }
    }

    @Test
    void 멤버저장하기() {
        // given
        Member member = Member.builder()
                .memberId("noakafka")
                .password("1234")
                .name("유종우")
                .build();

        // when
        Member dbMember = memberRepo.save(member);
        //then
        assertThat(dbMember.getMemberId()).isEqualTo("noakafka");

    }
}