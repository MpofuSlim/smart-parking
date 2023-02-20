package com.example.meraki.common.createrequests;

import com.example.meraki.controllers.authenticateDTO.AuthenticateDTO;
import com.example.meraki.entities.Authenticate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Authentication")
public class CreateAuthenticationRequestDTO {

    @ApiModelProperty
    private String username = "InnovationEcocash";

    @ApiModelProperty
    private String password = "InnoEco@15022023#";

}
