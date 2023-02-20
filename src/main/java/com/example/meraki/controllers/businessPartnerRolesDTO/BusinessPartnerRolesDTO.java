package com.example.meraki.controllers.businessPartnerRolesDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;

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
}
