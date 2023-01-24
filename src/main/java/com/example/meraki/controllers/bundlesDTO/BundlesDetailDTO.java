package com.example.meraki.controllers.bundlesDTO;

import com.example.meraki.controllers.currencyDTO.CurrencyDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Bundle detailed info")
public class BundlesDetailDTO {

    private BundlesDTO bundles;

    private BundleCategoryDTO bundleCategory;

    private CurrencyDTO currency;
}
