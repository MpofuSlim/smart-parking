package com.example.meraki.services.response;

import com.example.meraki.entities.Authenticate;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "authenticate  payload")
public class CreateAuthenticateResponse {

    Authenticate authenticate;
}
