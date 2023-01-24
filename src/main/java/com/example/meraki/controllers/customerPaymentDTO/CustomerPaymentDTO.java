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

    @ApiModelProperty(value = "amount", required = true, example = "")
    private BigDecimal amount;

    @ApiModelProperty(value = "phone_number", required = true, example = "")
    private String phoneNumber;

    @ApiModelProperty(value = "product_id", required = true, example = "1")
    private Long productId;

    @ApiModelProperty(value = "email", required = true, example = "")
    private String email;

    @ApiModelProperty(value = "product_title", required = true, example = "")
    private String productTitle;

    public static CustomerPaymentDTO fromCustomerPayment(CustomerPayment customerPayment) {
        return new CustomerPaymentDTO(customerPayment.getAmount(), customerPayment.getPhoneNumber(), customerPayment.getProductId(),customerPayment.getEmail(), customerPayment.getProductTitle());
    }
}
