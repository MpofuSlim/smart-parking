package com.example.meraki.services.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateVouchersStatusByIdResponse {

    @ApiModelProperty(value = "List of Ids of vouchers", example = "[1, 2, 4]")
    private ArrayList<Long> voucherId;

    @ApiModelProperty(value = "sold status of bundle", example = "true")
    private Boolean sold;
}
