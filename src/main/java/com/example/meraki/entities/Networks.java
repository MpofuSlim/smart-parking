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
@Entity(name="networks")
public class Networks extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private AdminPortalUsers user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organisations organisations;


    @Column(name = "name", nullable = false)
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedBy
    @Column(name = "date_created", nullable = false)
    private Date date_created;

    @Column(name = "active", nullable = false)
    private Boolean active;
}
