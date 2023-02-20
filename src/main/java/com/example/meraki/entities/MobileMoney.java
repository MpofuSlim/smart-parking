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
@Entity(name = "mobile_money")
public class MobileMoney extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @Column(name = "customerMobileNumber")

   String  customerMobileNumber;
    @Column(name = "merchantRef")
   String  merchantRef;

    @Column(name = "amount")
   double amount;

    @Column(name = "transactionDescription")
   String transactionDescription;

}
