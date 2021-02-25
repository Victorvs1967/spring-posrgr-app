package com.vvs.springposrgrapp.controller;

import javax.validation.Valid;

import com.vvs.springposrgrapp.entities.Member;
import com.vvs.springposrgrapp.repositories.MemberRepository;
import com.vvs.springposrgrapp.services.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;
    
    @GetMapping("/login")
    public String showLoginForm() {
        return "views/loginForm";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("member", new Member());
        return "views/registerForm";
    }

    @PostMapping("/register")
    public String registerMember(@Valid Member member, Model model) {
        String email = member.getEmail();
        if (memberRepository.findByEmail(email) != null) {
            model.addAttribute("exist", true);
            return "views/registerForm";
        }
        memberService.createMember(member);
        model.addAttribute("success", true);
        return "views/loginForm";
    }

    @GetMapping("/logout")
    public String logoutMember() {
        return "views/loginForm";
    }
}
