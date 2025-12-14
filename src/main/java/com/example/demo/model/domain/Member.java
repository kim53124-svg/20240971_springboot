package com.example.demo.model.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name = "";

    @Column(name = "email", unique = true, nullable = false)
    private String email = "";

    @Column(name = "password", nullable = false)
    private String password = "";

    @Column(name = "age")
    private String age;

    @Column(name = "mobile")
    private String mobile;
    
    @Column(name = "address")
    private String address;

    @Builder
    public Member(String name, String email, String password, String age, String mobile, String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.mobile = mobile;
        this.address = address;
    }
}
