package com.maven.springboot.mymustache.security.controller;

import com.maven.springboot.mymustache.member.IMemberService;
import com.maven.springboot.mymustache.member.MemberDto;
import com.maven.springboot.mymustache.security.dto.SignUpRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/cologin")
public class LoginCookieController {
    @Qualifier("IMemberService")
    @Autowired
    private IMemberService memberService;

    @GetMapping("")
    private String home() {
        return "login/home";
    }

    @GetMapping("/signup")
    private String viewSignUp() {
        return "login/signup";
    }

    @PostMapping("/signup")
    private String signUp(@ModelAttribute SignUpRequest dto) {
        try {
            if (dto == null) {
                return "redirect:/cologin";
            }
            this.memberService.addMember(dto);
        } catch (Exception ex) {
            log.error(ex.toString());
        }
        return "redirect:/cologin";
    }
}
