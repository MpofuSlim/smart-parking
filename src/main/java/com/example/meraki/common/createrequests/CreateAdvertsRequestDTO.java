package com.example.meraki.common.createrequests;

import com.example.meraki.controllers.advertsDTO.AdvertsDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Create adverts")
public class CreateAdvertsRequestDTO {

    private AdvertsDTO advertsDTO;

}
