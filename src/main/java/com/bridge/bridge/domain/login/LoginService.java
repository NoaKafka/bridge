package com.bridge.bridge.domain.login;

import com.bridge.bridge.api.member.MemberVO;
import com.bridge.bridge.domain.member.Member;
import com.bridge.bridge.domain.member.MemberRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LoginService {
    private final MemberRepo memberRepo;

    public MemberVO login(String loginId, String password){
        Member member = memberRepo.findByMemberId(loginId)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
        if(member != null){
            return new MemberVO(member);
        }
        return null;
    }
}
