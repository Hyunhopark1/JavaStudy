package com.maven.springboot.mymustache.security.controller;


import com.maven.springboot.mymustache.member.IMember;
import com.maven.springboot.mymustache.member.IMemberService;
import com.maven.springboot.mymustache.member.MemberServiceImpl;
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
@RequestMapping("/user")
public class UserController {
    @Autowired
    private MemberServiceImpl memberService;


    @GetMapping("/infoCookie")
    private String showInfoCookie(Model model, @CookieValue(name="loginId", required = false) String loginId) {
        if ( loginId == null ) {
            return "redirect:/";
        }
        IMember loginUser = memberService.findByLoginId(loginId);
        model.addAttribute("loginUser", loginUser);
        return "user/info";
    }


    @GetMapping("/infoSession")
    private String showInfoSession(Model model) {
        IMember loginUser = (IMember)model.getAttribute("loginUser");
        if ( loginUser == null ) {
            return "redirect:/";
        }
        return "user/info";
    }
}
