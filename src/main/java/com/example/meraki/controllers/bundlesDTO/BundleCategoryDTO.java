package com.example.meraki.controllers.bundlesDTO;

import com.example.meraki.entities.BundleCategory;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Bundle Category")
public class BundleCategoryDTO {


    @ApiModelProperty (value = "Name of category",required = true, example = "Rush Hour")
    private String name;

    @ApiModelProperty(value = "A short Description the of category",required = true, example = "Bundle for one hour")
    private String description;

    @ApiModelProperty(value = "A short Description the of category",required = true, example = "3600")
    private Integer duration;

    @ApiModelProperty(value = "A short Description the of category",required = true, example = "")
    private Date dateCreated;


    public static BundleCategoryDTO fromBundleCategory(BundleCategory bundleCategory){
        return new BundleCategoryDTO(bundleCategory.getName(),
                   bundleCategory.getDescription(), bundleCategory.getDuration(), bundleCategory.getDateCreated());
    }
}








