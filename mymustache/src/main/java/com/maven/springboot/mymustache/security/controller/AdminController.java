package com.maven.springboot.mymustache.security.controller;

import com.maven.springboot.mymustache.member.IMember;
import com.maven.springboot.mymustache.member.IMemberService;
import com.maven.springboot.mymustache.member.MemberRole;
import com.maven.springboot.mymustache.member.MemberServiceImpl;
import com.maven.springboot.mymustache.security.config.SecurityConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;


@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private IMemberService memberService;

    @GetMapping("/infoCookie")
    private String showInfoCookie(Model model, @CookieValue(name =" loginId", required = false) String loginId) {
        if ( loginId == null ) {
            return "redirect:/";
        }
        IMember loginUser = memberService.findByLoginId(loginId);
        if ( !loginUser.getRole().equals(MemberRole.ADMIN.toString()) ) {
            return "redirect:/";
        }
        model.addAttribute(SecurityConfig.LOGINUSER, loginUser);
        return "admin/info";
    }

    @GetMapping("/infoSession")
    private String showInfoSession(Model model) {
        IMember loginUser = (IMember)model.getAttribute(SecurityConfig.LOGINUSER);
        if ( loginUser == null ) {
            return "redirect:/";
        }
        if ( !loginUser.getRole().equals(MemberRole.ADMIN.toString()) ) {
            return "redirect:/";
        }
        return "admin/info";
    }
}
