package com.example.meraki.services.response;

import com.example.meraki.entities.AdminPortalUsers;
import com.example.meraki.entities.Role;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "CreateAdminPortalUsers payload")
public class CreateAdminPortalUsersResponse {

    private AdminPortalUsers adminPortalUsers;

    private Role role;
}
