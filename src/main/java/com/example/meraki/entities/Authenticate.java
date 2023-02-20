package com.example.meraki.entities;

import lombok.Data;

import javax.persistence.Column;

@Data
public class Authenticate{


    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;
}

