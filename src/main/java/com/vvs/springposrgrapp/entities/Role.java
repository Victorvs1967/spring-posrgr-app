package com.vvs.springposrgrapp.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role {
    
    @Id
    private String name;

    @ManyToMany(mappedBy = "role")
    private List<Member> members;
}