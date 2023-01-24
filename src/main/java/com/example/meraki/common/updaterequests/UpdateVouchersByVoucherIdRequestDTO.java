package com.example.meraki.common.updaterequests;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class UpdateVouchersByVoucherIdRequestDTO {

    @ApiModelProperty(value = "Id of voucher", example = "1")
    private ArrayList<Long> voucherId;

    @ApiModelProperty(value = "sold status of bundle", example = "1")
    private Boolean sold;
}
