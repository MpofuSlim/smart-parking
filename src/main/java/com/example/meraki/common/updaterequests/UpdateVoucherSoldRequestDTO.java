package com.example.meraki.common.updaterequests;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class UpdateVoucherSoldRequestDTO {


    @ApiModelProperty(value = "Status of voucher", example = "true")
    private Long id;

    @ApiModelProperty(value = "Status of voucher", example = "true")
    private Boolean sold;
}
