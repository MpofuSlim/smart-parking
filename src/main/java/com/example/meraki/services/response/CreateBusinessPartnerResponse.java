package com.example.meraki.services.response;

import com.example.meraki.entities.BusinessPartner;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateBusinessPartnerResponse {

    private BusinessPartner businessPartner;
}
