package com.vvs.springposrgrapp.controller;

import java.security.Principal;
import java.util.Date;

import com.vvs.springposrgrapp.entities.Member;
import com.vvs.springposrgrapp.repositories.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    MemberRepository memberRepository;
    
    @GetMapping("/")
    public String showIndex(Model model, Principal principal, Member member) {
        if (principal == null) {
            return "views/loginForm";
        }
        model.addAttribute("message", "Hello everyone, we are go to back to Spring with together.");
        model.addAttribute("date", new Date());
        model.addAttribute("members", memberRepository.getOne(principal.getName()));
        return "index";
    }
}
