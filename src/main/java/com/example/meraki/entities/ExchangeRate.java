package com.example.meraki.entities;


import lombok.*;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name="exchange_rate")
public class ExchangeRate extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private AdminPortalUsers user;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "rate", nullable = false)
    private Double rate;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedBy
    @Column(name = "date_created", nullable = false)
    private Date date_created;

}
