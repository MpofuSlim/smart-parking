package com.example.meraki.services.response;

import com.example.meraki.entities.BasePrice;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateBasePriceResponse {

    @ApiModelProperty(value = "id of the base price", example = "1")
    private Long id;
    @ApiModelProperty(value = "currency base price", example = "1.19")
    private Double price;

}
