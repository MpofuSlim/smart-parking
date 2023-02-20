package com.example.meraki.common.createrequests;

import com.example.meraki.controllers.businessPartnerRolesDTO.BusinessPartnerRolesDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Create Business Partner Roles")

public class CreateBusinessPartnerRolesRequestDTO {

    BusinessPartnerRolesDTO businessPartnerRoles;




}
