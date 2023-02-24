package com.example.meraki.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EntityListeners(EntityManager.class)
@Entity(name = "admin_portal_users")
public class AdminPortalUsers extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ManyToOne(optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "email_address", unique = true)
    private String emailAddress;

    @Column(name = "password", nullable = false)
    private String password;


    @Column(name = "active", nullable = false)
    private Boolean active;

}


