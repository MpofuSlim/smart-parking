package com.example.meraki.controllers.mobileMoneyDTO;

import com.example.meraki.controllers.authenticateDTO.AuthenticateDTO;
import com.example.meraki.entities.Authenticate;
import com.example.meraki.entities.MobileMoney;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "MobileMoney")
public class MobileMoneyDTO {

        @ApiModelProperty(example = "customerMobileNumber")

        String  customerMobileNumber;
        @ApiModelProperty(example = "merchantRef")
        String  merchantRef;

        @ApiModelProperty(example = "amount")
        double amount;

        @ApiModelProperty(example = "transactionDescription")
        String transactionDescription;

        public static MobileMoneyDTO fromAuthentication(MobileMoney mobileMoney) {

            return new MobileMoneyDTO(mobileMoney.getCustomerMobileNumber(),mobileMoney.getMerchantRef(),
                    mobileMoney.getAmount(), mobileMoney.getTransactionDescription());
        }
}
