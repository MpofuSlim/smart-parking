
package com.example.meraki.services.response;

import com.example.meraki.entities.AdminPortalUsers;
import com.example.meraki.entities.BundleCategory;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateBundleCategoryResponse {
    private BundleCategory bundleCategory;
    private AdminPortalUsers user;
}


