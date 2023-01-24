package com.example.meraki.common.updaterequests;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateAdvertsRequestDTO {

    @ApiModelProperty(value = "id", example = "1")
    private Long id;

    @ApiModelProperty(value = "title", example = "")
    private  String title;

    @ApiModelProperty(value = "description", example = "")
    private String description;

    @ApiModelProperty(value = "image", example = "")
    private String image;
    //private byte[] image;

    @ApiModelProperty(value = "active", example = "")
    private Boolean active;
}
