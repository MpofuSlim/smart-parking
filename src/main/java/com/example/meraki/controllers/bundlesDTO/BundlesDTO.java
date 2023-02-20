package com.example.meraki.controllers.bundlesDTO;


import com.example.meraki.entities.Bundles;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.EntityManager;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EntityListeners(EntityManager.class)
@ApiModel(description = "bundles")
public class BundlesDTO {


    @ApiModelProperty(value = "name of the sender.", example = "Bundle")
    private String name;

    @ApiModelProperty(value = "group policy id.", example = "1234567")
    private String groupPolicyId;

    @ApiModelProperty(value = "bundle description", example = "Bundle for telone")
    private String description;


    @ApiModelProperty(value = "The image", example = "https://www.image.com")
    private String image;

    @ApiModelProperty(value = "bundle price", example = "60.8")
    private Double price;



    public static BundlesDTO fromBundles(Bundles bundles) {
        return new BundlesDTO(bundles.getName(), bundles.getGroupPolicyId(), bundles.getDescription(),
                bundles.getImage(), bundles.getPrice());

    }

}
