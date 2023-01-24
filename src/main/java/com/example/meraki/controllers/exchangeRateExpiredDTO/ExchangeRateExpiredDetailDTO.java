package com.example.meraki.controllers.exchangeRateExpiredDTO;

import com.example.meraki.controllers.userDTO.UserDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "ExchangeRateExpired detailed info")
public class ExchangeRateExpiredDetailDTO {

    private ExchangeRateExpiredDTO exchangeRateExpired;

    private UserDTO user;
}
