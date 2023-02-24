package com.example.meraki.controllers.customerDTO;

import com.example.meraki.controllers.customerPaymentDTO.CustomerPaymentDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@ApiModel(description = "customer payment")
public class CustomerPaymentRequestDTO {

    private CustomerPaymentDTO customerPayment;

    private Long customerID;
}
