package com.example.meraki.services.response;

import com.example.meraki.entities.AdminPortalUsers;
import com.example.meraki.entities.ExchangeRateExpired;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "exchange-rate-expired  payload")
public class CreateExchangeRateExpiredResponse {

    private ExchangeRateExpired exchangeRateExpired;

    private AdminPortalUsers user;
}
