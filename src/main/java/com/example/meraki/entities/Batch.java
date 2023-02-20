package com.example.meraki.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "batch")
public class Batch extends BaseEntity {

    private static final long serialVersionUID = 1L;


    @Column(name = "batchName", nullable = false)
    private String batchName;

    @Column(name = "active", nullable = false)
    private Boolean active;

    @Column(name = "suspended", nullable = false)
    private Boolean suspended;



}
