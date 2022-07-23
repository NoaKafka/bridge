package com.bridge.bridge.api.login;

import com.bridge.bridge.api.member.MemberVO;
import com.bridge.bridge.domain.login.LoginService;
import com.bridge.bridge.domain.member.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;
import java.util.UUID;


@Slf4j
@RequiredArgsConstructor
@Controller
public class LoginController {

    private final LoginService loginService;

    @RequestMapping("/login")
    public @ResponseBody MemberVO login(@RequestBody LoginForm loginForm,
                          HttpServletRequest request,
                          HttpServletResponse response) throws Exception{

        MemberVO memberVO = loginService.login(loginForm.getLoginId(), loginForm.getPassword());
        if(memberVO != null){
            HttpSession session = request.getSession();
            // check session
            if(sessionCheck(request) == false){
                session.setAttribute("memberId", UUID.randomUUID().toString());
            }
            String sessionId = (String)session.getAttribute("memberId");
            memberVO.setJSessionId(sessionId);

            return memberVO;
        }

        return memberVO;
    }

    private Boolean sessionCheck(HttpServletRequest request){
        HttpSession session = request.getSession();
        return session.getAttribute("memberId") != null;
    }

}
