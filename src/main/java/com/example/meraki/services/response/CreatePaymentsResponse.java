package com.example.meraki.services.response;

import com.example.meraki.entities.Customers;
import com.example.meraki.entities.Payments;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Payments")
public class CreatePaymentsResponse {

    private Payments payments;

    private Customers customers;
}
