package com.example.meraki.services.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateAdvertsResponse {

    @ApiModelProperty(value = "title")
    private String title;

    @ApiModelProperty(value = "description")
    private String description;

    @ApiModelProperty(value = "image")
    private String image;
    //private byte[] image;

    @ApiModelProperty(value = "active state")
    private Boolean active;
}
