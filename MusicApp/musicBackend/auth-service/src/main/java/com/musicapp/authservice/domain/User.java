package com.musicapp.authservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class User {
    
    @Id @GeneratedValue
    private Integer id;

    @Column(unique = true)
    private String userName;
    @Column(nullable = false, unique = true)
    private String email;
    private String password;
}
