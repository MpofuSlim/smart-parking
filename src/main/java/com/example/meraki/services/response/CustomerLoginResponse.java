package com.example.meraki.services.response;

import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Create customer login payload")

public class CustomerLoginResponse {

    private Long customerId;
    private String name;
    private String surname;

}
