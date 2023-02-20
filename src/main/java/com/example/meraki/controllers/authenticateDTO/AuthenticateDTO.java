package com.example.meraki.controllers.authenticateDTO;

import com.example.meraki.entities.Authenticate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "authentication")
public class AuthenticateDTO {

    @ApiModelProperty(example = "InnovationEcocash")
    private String username;

    @ApiModelProperty(example = "InnoEco@15022023#")
    private String password;

    public static AuthenticateDTO fromAuthentication(Authenticate authenticate) {

        return new AuthenticateDTO(authenticate.getUsername(), authenticate.getPassword());
    }

}
