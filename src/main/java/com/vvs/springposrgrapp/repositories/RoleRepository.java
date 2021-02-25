package com.vvs.springposrgrapp.repositories;

import com.vvs.springposrgrapp.entities.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
    
}
