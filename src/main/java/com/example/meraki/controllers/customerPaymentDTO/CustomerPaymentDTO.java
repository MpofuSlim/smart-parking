package com.example.meraki.controllers.customerPaymentDTO;

import com.example.meraki.entities.CustomerPayment;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "payments")
public class CustomerPaymentDTO {

    @ApiModelProperty(value = "email", required = true ,example = "t.knigel3@gmail.com")
    private String email;

    @ApiModelProperty(value = "product title", required = true ,example = "Apple")
    private String title;

    @ApiModelProperty(value = "amount", required = true ,example = "2.3")
    private double amount;

    @ApiModelProperty(value = "phone", required = true ,example = "0771111111")
    private String phone;

    public static CustomerPaymentDTO fromCustomerPayment(CustomerPayment customerPayment){
        return new CustomerPaymentDTO(customerPayment.getEmail(), customerPayment.getTitle(), customerPayment.getAmount(), customerPayment.getPhone());
    }
}
