package com.example.meraki.common.createrequests;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Authentication")

public class CreateMobileMoneyRequestDTO {
    @ApiModelProperty
    String  customerMobileNumber;
    @ApiModelProperty
    String  merchantRef;

    @ApiModelProperty
    double amount;

    @ApiModelProperty
    String transactionDescription;





}
