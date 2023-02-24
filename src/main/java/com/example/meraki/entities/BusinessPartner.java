package com.example.meraki.entities;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EntityListeners(EntityManager.class)
@Entity(name="business_partner")
public class BusinessPartner extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ManyToOne(optional = false)
    @JoinColumn(name = "business_partner_role_id", nullable = false)
    private BusinessPartnerRoles businessPartnerRoles;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "business_address", nullable = false)
    private String businessAddress;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "active", nullable = false)
    private Boolean active;
}
