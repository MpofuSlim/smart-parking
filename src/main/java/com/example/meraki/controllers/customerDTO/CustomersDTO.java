package com.example.meraki.controllers.customerDTO;

import com.example.meraki.entities.Customers;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "voucher")
public class CustomersDTO {


    @ApiModelProperty(value ="voucher batchID", required = true, example = "Mike")
    private String firstname;

    @ApiModelProperty(value ="voucher batchName", required = true, example = "Johns")
    private String surname;

    @ApiModelProperty(value ="voucherCode", required = true, example = "078567893")
    private String phone_number;

    @ApiModelProperty(value ="email", required = true, example = "mikejohns@gmail.com")
    private String email;

    @ApiModelProperty(value ="password", required = true, example = "12345678")
    private String password;

    public static CustomersDTO fromCustomer(Customers customers){
        return new CustomersDTO(customers.getFirstname(),customers.getSurname(),customers.getPhone_number(),customers.getEmail(), customers.getPassword());
    }
}


