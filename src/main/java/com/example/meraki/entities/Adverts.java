package com.example.meraki.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name="adverts")
public class Adverts extends BaseEntity{
    private static final long serialVersionUID = 1L;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "image", nullable = false)
    private String image;
    //private byte[]  image;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "active", nullable = false)
    private Boolean active;
}
