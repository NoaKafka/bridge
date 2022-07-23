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

import javax.servlet.http.Cookie;
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
    public @ResponseBody MemberVO login(@RequestBody LoginForm loginForm, HttpSession httpSession,
                          HttpServletResponse response) throws Exception{

        MemberVO memberVO = loginService.login(loginForm.getLoginId(), loginForm.getPassword());


        if(memberVO != null){
            // check session
            if(sessionCheck(httpSession) == false){
                httpSession.setAttribute("memberId", UUID.randomUUID().toString());
            }
            Cookie cookie = new Cookie("id", memberVO.getId().toString());
            response.addCookie(cookie);

            return memberVO;
        }
        return memberVO;
    }

    private Boolean sessionCheck(HttpSession httpSession){
        return httpSession.getAttribute("memberId") != null;
    }

}
