package com.example.meraki.common.createrequests;

import com.example.meraki.controllers.roleDTO.RoleDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Create role payload")
public class CreateRoleRequestDTO {

    private RoleDTO role;
}
