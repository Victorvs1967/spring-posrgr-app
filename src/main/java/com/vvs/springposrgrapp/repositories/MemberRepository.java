package com.vvs.springposrgrapp.repositories;

import com.vvs.springposrgrapp.entities.Member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {

	Object findByEmail(String email); 
}
