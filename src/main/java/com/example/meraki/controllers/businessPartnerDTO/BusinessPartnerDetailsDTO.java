package com.example.meraki.controllers.businessPartnerDTO;

import com.example.meraki.controllers.businessPartnerRolesDTO.BusinessPartnerRolesDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Business Partner detailed info")

public class BusinessPartnerDetailsDTO {

    private BusinessPartnerDTO businessPartner;

    private BusinessPartnerRolesDTO businessPartnerRolesDTO;
}
