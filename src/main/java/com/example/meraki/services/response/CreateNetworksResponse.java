package com.example.meraki.services.response;

import com.example.meraki.entities.*;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "networks  payload")
public class CreateNetworksResponse {

    private Networks networks;

    private AdminPortalUsers user;

    private Organisations organisations;
}
