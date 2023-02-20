package com.example.meraki.common.createrequests;

import com.example.meraki.controllers.basePriceDTO.BasePriceDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "create base_price payload")
public class CreateBasePriceRequestDTO {

    @ApiModelProperty(value = "", example = "1")
    private Long id;
    @ApiModelProperty(value = "", example = "7.89")
    private Double price;
    //private BasePriceDTO basePrice;

}
