package com.example.meraki.common.createrequests;

import com.example.meraki.controllers.vouchersDTO.SellVouchersDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Create vouchers payload")
public class CreateSellVoucherRequestDTO {



    @ApiModelProperty(value = "Id of voucher", example = "1")
    private Long id;



}
