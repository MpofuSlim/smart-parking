package com.example.meraki.controllers.paymentsDTO;

import com.example.meraki.controllers.customerDTO.CustomersDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "payments detailed info")
public class PaymentsDetailDTO {

    private PaymentsDTO payments;

    private CustomersDTO customers;

}
