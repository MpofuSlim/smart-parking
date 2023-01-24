package com.example.meraki.services.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateBundleCategoryResponse {

    @ApiModelProperty(value = "name", example = "")
    private String name;

    @ApiModelProperty(value = "name", example = "2400")
    private Integer duration;

    @ApiModelProperty(value = "description", example = "")
    private String description;

    @ApiModelProperty(value = "active state", example = "true")
    private Boolean active;
}