package com.example.meraki.services.response;

import com.example.meraki.entities.AdminPortalUsers;
import com.example.meraki.entities.ExchangeRate;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "exchange-rate  payload")
public class CreateExchangeRateResponse {

    private ExchangeRate exchangeRate;

    private AdminPortalUsers user;
}
