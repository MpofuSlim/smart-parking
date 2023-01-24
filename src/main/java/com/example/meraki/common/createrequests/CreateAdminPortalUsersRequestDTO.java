package com.example.meraki.common.createrequests;

import com.example.meraki.controllers.adminPortalUsersDTO.AdminPortalUsersDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "create-admin-portal-users payload")
public class CreateAdminPortalUsersRequestDTO {

    private AdminPortalUsersDTO adminPortalUsersDTO;

    private Long roleID;

}
