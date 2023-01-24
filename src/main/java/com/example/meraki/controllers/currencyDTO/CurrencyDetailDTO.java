package com.example.meraki.controllers.currencyDTO;

import com.example.meraki.controllers.userDTO.UserDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Currency detailed info")
public class CurrencyDetailDTO {

    private CurrencyDTO currency;

    private UserDTO user;
}
