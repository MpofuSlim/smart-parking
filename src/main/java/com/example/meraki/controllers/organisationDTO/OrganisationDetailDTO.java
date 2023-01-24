package com.example.meraki.controllers.organisationDTO;

import com.example.meraki.controllers.userDTO.UserDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "organisation detailed info")
public class OrganisationDetailDTO {

    private OrganisationDTO organisation;

    private UserDTO user;
}
