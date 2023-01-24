package com.example.meraki.controllers.adminPortalUsersDTO;

import com.example.meraki.entities.AdminPortalUsers;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "AdminPortalUsers")
public class AdminPortalUsersDTO {

    @ApiModelProperty(value ="first name of the user", required = true, example = "Tawanda")
    private String firstname;

    @ApiModelProperty(value ="surname of the user", required = true, example = "Mpofu")
    private String surname;

    @ApiModelProperty(value ="email address", required = true, example = "test@gmail.com")
    private String email_address;

    @ApiModelProperty(value ="password", required = true, example = "twdgfths")
    private String password;


    public static  AdminPortalUsersDTO fromAdminPortalUsers(AdminPortalUsers adminPortalUsers){
        return new AdminPortalUsersDTO (adminPortalUsers.getFirstname(),adminPortalUsers.getSurname(),adminPortalUsers.getEmailAddress(), adminPortalUsers.getPassword());
    }

}

