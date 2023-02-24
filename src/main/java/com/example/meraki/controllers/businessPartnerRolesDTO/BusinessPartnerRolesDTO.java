package com.example.meraki.controllers.businessPartnerRolesDTO;

import com.example.meraki.entities.BusinessPartnerRoles;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Business Partner Roles payload")
public class BusinessPartnerRolesDTO {

    @ApiModelProperty(value = "name of the business partner role", required = true,example = "admin")
    private String name;

    @ApiModelProperty(value = "the values of the vat", required = true, example = "8.90")
    private Double vat;

    @ApiModelProperty(value = "discount of the business partners", required = true,example = "7.8")
    private Double discount;

    public static BusinessPartnerRolesDTO fromBusinessPartnerRoles(BusinessPartnerRoles businessPartnerRoles){
        return new BusinessPartnerRolesDTO (businessPartnerRoles.getName(), businessPartnerRoles.getVat(), businessPartnerRoles.getDiscount());
    }
}
