package com.vvs.springposrgrapp.services;

import java.util.ArrayList;
import java.util.List;

import com.vvs.springposrgrapp.entities.Member;
import com.vvs.springposrgrapp.entities.Role;
import com.vvs.springposrgrapp.repositories.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    
    @Autowired
    private MemberRepository memberRepository;

    public Member createMember(Member member) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        member.setPassword(encoder.encode(member.getPassword()));
        Role memberRole = new Role("ADMIN");
        List<Role> roles = new ArrayList<>();
        roles.add(memberRole);
        member.setRole(roles);
        memberRepository.save(member);
        return member;
    }
}
