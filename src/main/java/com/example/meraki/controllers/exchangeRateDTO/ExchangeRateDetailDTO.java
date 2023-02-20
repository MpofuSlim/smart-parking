package com.example.meraki.controllers.exchangeRateDTO;

import com.example.meraki.controllers.adminPortalUsersDTO.AdminPortalUsersDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "ExchangeRate detailed info")
public class ExchangeRateDetailDTO {

    private ExchangeRateDTO exchangeRate;

    private AdminPortalUsersDTO user;
}
