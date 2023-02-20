package com.example.meraki.controllers.networksDTO;


import com.example.meraki.controllers.adminPortalUsersDTO.AdminPortalUsersDTO;
import com.example.meraki.controllers.organisationDTO.OrganisationDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "networks detailed info")
public class NetworksDetailDTO {

    private NetworksDTO networks;

    private AdminPortalUsersDTO user;

    private OrganisationDTO organisation;
}
