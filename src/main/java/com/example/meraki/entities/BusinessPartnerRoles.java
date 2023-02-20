package com.example.meraki.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EntityManager;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EntityListeners(EntityManager.class)
@Entity(name = "business_partner_roles")

public class BusinessPartnerRoles extends BaseEntity{

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "vat", nullable = false)
    private Double vat;

    @Column(name = "discount", nullable = false)
    private Double discount;


}
