package com.example.meraki.services.response;

import com.example.meraki.entities.Customers;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Customer  payload")
public class CreateCustomerResponse {

    private Customers customers;


}
