package com.example.meraki.controllers.adminPortalUsersDTO;

import com.example.meraki.controllers.roleDTO.RoleDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "AdminPortalUsers detailed info")
public class AdminPortalUsersDetailDTO {

    private AdminPortalUsersDTO adminPortalUsers;


    private RoleDTO role;
}
