package com.example.meraki.services.response;


import com.example.meraki.entities.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateBundlesResponse {

    private Bundles bundles;
    private AdminPortalUsers user;
    private Currency currency;
    private BundleCategory bundleCategory;

}



