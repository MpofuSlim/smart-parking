package com.example.meraki.controllers.advertsDTO;

import com.example.meraki.entities.Adverts;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "adverts")
public class AdvertsDTO {


    @ApiModelProperty(value = "", example = "")
    private String title;

    @ApiModelProperty(value = "", example = "")
    private String description;

    @ApiModelProperty(value = "", example = "")
    private String image;
    //private byte[] image;


    public static AdvertsDTO fromAdverts(Adverts adverts) {

        return new AdvertsDTO(adverts.getTitle(), adverts.getDescription(), adverts.getImage());
    }
}
