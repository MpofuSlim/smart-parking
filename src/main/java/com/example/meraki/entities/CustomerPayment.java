package com.example.meraki.entities;

import lombok.*;

import javax.persistence.*;
import java.security.SecureRandom;
import java.util.Base64;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(EntityManager.class)
@ToString
@Entity(name="customer_payment")
public class CustomerPayment extends BaseEntity{

    private static final long serialVersionUID = 1L;

    public static String generateRandomBase64Token(int byteLength) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] token = new byte[byteLength];
        secureRandom.nextBytes(token);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(token); //base64 encoding
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customers customer;

    @Column(name="reference", nullable = false)
    private String reference = generateRandomBase64Token(8) ;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="product_title", nullable = false)
    private String title;

    @Column(name="amount", nullable = false)
    private double amount;

    @Column(name="phone", nullable = false)
    private String phone;

    public CustomerPayment(Customers customer,String email,String title, double amount,String phone){
        this.customer = customer;
        this.email = email;
        this.title = title;
        this.amount = amount;
        this.phone = phone;

    }
}
