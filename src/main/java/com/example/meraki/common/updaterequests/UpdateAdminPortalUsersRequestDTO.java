package com.example.meraki.common.updaterequests;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateAdminPortalUsersRequestDTO {

    @ApiModelProperty(value = "Id of voucher", example = "1")
    private Long id;

    @ApiModelProperty(value = "firstName", example = "")
    private String firstname;

    @ApiModelProperty(value = "surname", example = "")
    private String surname;

    @ApiModelProperty(value = "email-address", example = "")
    private String emailAddress;

    @ApiModelProperty(value = "password", example = "")
    private String password;

    @ApiModelProperty(value = "active state", example = "")
    private Boolean active = false;
}

